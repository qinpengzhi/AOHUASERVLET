package com.aohua.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
}
