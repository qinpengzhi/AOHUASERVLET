package com.aohua.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aohua.service.DepartMentService;
import com.aohua.service.TransportModelService;

/**
 * qin is prefect
 */
@Controller
public class Add_OrderController {
	@Autowired
	private DepartMentService departMentService;
	@Autowired
	private TransportModelService transportModelService;
	//获取所属部门列表
	@RequestMapping("getdepartment")
	public void getdepartment(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(departMentService.getDepartMent());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//获取运输方式列表
	@RequestMapping("gettransportmodel")
	public void gettransportmodel(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(transportModelService.getTransportMode());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
}
