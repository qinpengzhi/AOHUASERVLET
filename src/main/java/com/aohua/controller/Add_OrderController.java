package com.aohua.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aohua.service.DepartMentService;

@Controller
public class Add_OrderController {
	@Autowired
	private DepartMentService departMentService;
	@RequestMapping("getdepartment")
	public void getUserid(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONObject jsonObject = JSONObject.fromObject(departMentService.getDepartMent());
		String aaa=jsonObject.toString();
		res.getWriter().println(jsonObject.toString());
	}
}
