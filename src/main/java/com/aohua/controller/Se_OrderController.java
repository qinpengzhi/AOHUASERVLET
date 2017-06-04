package com.aohua.controller;

import java.io.IOException;
import java.nio.channels.WritePendingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aohua.model.UserList;
import com.aohua.service.Pu_PurOrderService;
import com.aohua.service.Se_OrderService;
import com.aohua.service.UserListService;

/**
 * qin
 */
@Controller
public class Se_OrderController {
	@Autowired
	private Se_OrderService se_OrderService;	
	@Autowired
	private UserListService userListService;
	@Autowired
	private Pu_PurOrderService pu_PurOrderService;
	//登录
	@RequestMapping("login")
	public void getUserid(HttpServletRequest req,HttpServletResponse res) throws IOException{
		//设置编码，解决中文乱码
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("user"));
		String name=req.getParameter("user");
		String password=req.getParameter("pwd");
		List<Map<String,Object>> userlist=userListService.getUserID(name, password);
		res.setContentType("text/html;charset=utf-8");
		if(userlist.size()>0){
			try{
				JSONObject jsonobj=new JSONObject();
				jsonobj.put("userid", userlist.get(0).get("UserID"));
				jsonobj.put("examine", userlist.get(0).get("Examine"));
				res.getWriter().println(jsonobj.toString());
				System.out.println(jsonobj.toString());
			}catch(JSONException je){
				je.printStackTrace();
			}
		}else{
			try{
				JSONObject jsonobj=new JSONObject();
				jsonobj.put("userid", 0);
				jsonobj.put("examine","");
				System.out.println(jsonobj.toString());
				res.getWriter().println(jsonobj.toString());
			}catch(JSONException je){
				je.printStackTrace();
			}
		}
	}
	@RequestMapping("getse_orderlist")
	public void getse_orderlist(HttpServletRequest req,HttpServletResponse res,HttpSession httpSession) throws IOException{
	//	int WritePersonID=1;//这里应该是对应的uerid 没能用session用的是android客户端保持登录信息
		req.setCharacterEncoding("utf-8");
		System.out.println("这里的userid是："+req.getParameter("userid"));
		int WritePersonID=Integer.parseInt(req.getParameter("userid"));
		int examine=Integer.parseInt(req.getParameter("examine"));
		JSONArray jsonObject=JSONArray.fromObject(se_OrderService.find(WritePersonID,examine));
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	@RequestMapping("getpu_purorderlist")
	public void getpu_purorderlist(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		//int WritePersonID=1;//这里应该是对应的uerid
		req.setCharacterEncoding("utf-8");
		System.out.println("这里的userid是："+req.getParameter("userid"));
		int WritePersonID=Integer.parseInt(req.getParameter("userid"));
		int examine=Integer.parseInt(req.getParameter("examine"));
		JSONArray jsonObject=JSONArray.fromObject(pu_PurOrderService.find(WritePersonID,examine));
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	@RequestMapping("getse_orderdetails")
	public void getse_orderdetails(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		req.setCharacterEncoding("utf-8");
		System.out.println("根据orderid来查找数据："+req.getParameter("orderid"));
		int orderid=Integer.parseInt(req.getParameter("orderid"));
		JSONArray jsonObject=JSONArray.fromObject(se_OrderService.findbyid(orderid));
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	@RequestMapping("getse_orderdtdetails")
	public void getse_orderdtdetails(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		req.setCharacterEncoding("utf-8");
		System.out.println("根据orderid来查找数据："+req.getParameter("orderid"));
		int orderid=Integer.parseInt(req.getParameter("orderid"));
		JSONArray jsonObject=JSONArray.fromObject(se_OrderService.finddtbyid(orderid));
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	@RequestMapping("getpu_purorderdetails")
	public void getpu_purorderdetails(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		req.setCharacterEncoding("utf-8");
		System.out.println("根据orderid来查找数据："+req.getParameter("orderid"));
		int orderid=Integer.parseInt(req.getParameter("orderid"));
		JSONArray jsonObject=JSONArray.fromObject(pu_PurOrderService.findbyid(orderid));
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	@RequestMapping("getpu_purorderdtdetails")
	public void getpu_purorderdtdetails(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		req.setCharacterEncoding("utf-8");
		System.out.println("根据orderid来查找数据："+req.getParameter("orderid"));
		int orderid=Integer.parseInt(req.getParameter("orderid"));
		JSONArray jsonObject=JSONArray.fromObject(pu_PurOrderService.finddtbyid(orderid));
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//审核销售订单
	@RequestMapping("updatese_order")
	public void updatese_order(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		req.setCharacterEncoding("utf-8");
		int OrderID=Integer.parseInt(req.getParameter("orderid"));
		int State=Integer.parseInt(req.getParameter("state"));
		String AuditOpinion=req.getParameter("AuditOpinion");
		se_OrderService.update(OrderID, State, AuditOpinion);
		
	}
	//审核采购订单
	@RequestMapping("updatepu_purorder")
	public void updatepu_purorder(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		req.setCharacterEncoding("utf-8");
		int PurOrderID=Integer.parseInt(req.getParameter("orderid"));
		int State=Integer.parseInt(req.getParameter("state"));
		String AuditOpinion=req.getParameter("AuditOpinion");
		pu_PurOrderService.update(PurOrderID, State, AuditOpinion);
		
	}
}
