package com.aohua.controller;

import java.io.IOException;
import java.nio.channels.WritePendingException;
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
	public void getUserid(HttpServletRequest req,HttpServletResponse res,HttpSession session) throws IOException{
		//设置编码，解决中文乱码
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("user"));
		String name=req.getParameter("user");
		String password=req.getParameter("pwd");
		int userid=userListService.getUserID(name, password);
		res.setContentType("text/html;charset=utf-8");
		if(userid>0){
			session.setAttribute("userid", userid);
		}
		try{
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("userid", userid);
			res.getWriter().println(jsonobj.toString());
		}catch(JSONException je){
			je.printStackTrace();
		}
		//JSONObject jo=JSONObject.fromObject(param);
		
	}
	@RequestMapping("getse_orderlist")
	public void getse_orderlist(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		int WritePersonID=1;//这里应该是对应的uerid
		JSONArray jsonObject=JSONArray.fromObject(se_OrderService.find(WritePersonID));
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	@RequestMapping("getpu_purorderlist")
	public void getpu_purorderlist(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		int WritePersonID=1;//这里应该是对应的uerid
		JSONArray jsonObject=JSONArray.fromObject(pu_PurOrderService.find(WritePersonID));
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
}
