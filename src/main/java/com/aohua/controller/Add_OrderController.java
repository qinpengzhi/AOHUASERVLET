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
import com.aohua.service.EmployeeService;
import com.aohua.service.Se_CustomerService;
import com.aohua.service.SettleModeService;
import com.aohua.service.TransportModeService;

/**
 * qin is prefect
 */
@Controller
public class Add_OrderController {
	@Autowired
	private DepartMentService departMentService;
	@Autowired
	private TransportModeService transportModelService;
	@Autowired
	private SettleModeService settleModeService;
	@Autowired
	private Se_CustomerService se_CustomerService;
	@Autowired
	private EmployeeService employeeService;
	//��ȡ���������б�
	@RequestMapping("getdepartment")
	public void getdepartment(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(departMentService.getDepartMent());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//��ȡ���䷽ʽ�б�
	@RequestMapping("gettransportmode")
	public void gettransportmode(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(transportModelService.getTransportMode());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//��ȡ���㷽ʽ�б�
	@RequestMapping("getsettlemode")
	public void getsettlemode(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(settleModeService.getSettleMode());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//��ȡ���пͻ����б�
	@RequestMapping("getse_customer")
	public void getse_customer(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(se_CustomerService.getSe_Customer());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//��ȡҵ��Ա�б�
	@RequestMapping("getemployee")
	public void getemployee(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(employeeService.getEmployee());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
}
