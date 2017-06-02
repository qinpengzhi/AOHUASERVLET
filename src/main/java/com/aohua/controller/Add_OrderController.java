package com.aohua.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aohua.model.Pu_PurOrder;
import com.aohua.model.Pu_PurOrderDt;
import com.aohua.model.Se_Order;
import com.aohua.model.Se_OrderDt;
import com.aohua.service.DepartMentService;
import com.aohua.service.EmployeeService;
import com.aohua.service.GoodsCodeService;
import com.aohua.service.Pu_PurOrderService;
import com.aohua.service.Pu_SupplierService;
import com.aohua.service.Se_CustomerService;
import com.aohua.service.Se_OrderService;
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
	@Autowired
	private GoodsCodeService goodsCodeService;
	@Autowired
	private Pu_SupplierService pu_SupplierService;
	@Autowired
	private Se_OrderService Se_OrderService;
	@Autowired
	private Pu_PurOrderService pu_PurOrderService;
	//获取所属部门列表
	@RequestMapping("getdepartment")
	public void getdepartment(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(departMentService.getDepartMent());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//获取运输方式列表
	@RequestMapping("gettransportmode")
	public void gettransportmode(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(transportModelService.getTransportMode());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//获取结算方式列表
	@RequestMapping("getsettlemode")
	public void getsettlemode(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(settleModeService.getSettleMode());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//获取所有客户的列表
	@RequestMapping("getse_customer")
	public void getse_customer(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(se_CustomerService.getSe_Customer());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//获取业务员列表
	@RequestMapping("getemployee")
	public void getemployee(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(employeeService.getEmployee());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//获取物料列表
	@RequestMapping("getgoodscode")
	public void getgoodscode(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(goodsCodeService.getGoodsCode());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	@RequestMapping("getsupplier")
	public void getsupplier(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		JSONArray jsonObject=JSONArray.fromObject(pu_SupplierService.getPu_Supplier());
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println(jsonObject.toString());
		System.out.println(jsonObject.toString());
	}
	//提交销售订单和订单详情
	@RequestMapping("addorder")
	public void addorder(HttpServletRequest req,HttpServletResponse res) throws IOException{
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("order"));
		//System.out.println(req.getSession().getAttribute("userid"));
		//这个是对订单数据进行封装
		JSONObject jsonObject=JSONObject.fromObject(req.getParameter("order"));		
		Se_Order se_Order=new Se_Order();
		se_Order.setOrderCode((String) jsonObject.get("OrderCode"));
		se_Order.setCustID((Integer) jsonObject.get("CustID"));
		se_Order.setContractCode((String) jsonObject.get("ContractCode"));
		se_Order.setSellerID((Integer) jsonObject.get("SellerID"));
		se_Order.setSignAddr((String) jsonObject.get("SignAddr"));
		se_Order.setSignDate((String) jsonObject.get("SignDate"));
		se_Order.setDeliveryAddr((String) jsonObject.get("DeliveryAddr"));
		se_Order.setDeliveryDate((String) jsonObject.get("DeliveryDate"));
		if(!jsonObject.get("Freight").toString().equals(""))
			se_Order.setFreight(Double.valueOf(jsonObject.get("Freight").toString()));
		se_Order.setTransportID((Integer) jsonObject.get("TransportID"));
		se_Order.setSettleID((Integer) jsonObject.get("SettleID"));
		if(!jsonObject.get("ReceDays").toString().equals(""))
			se_Order.setReceDays((Integer.parseInt( jsonObject.get("ReceDays").toString())));
		se_Order.setDeptID((Integer) jsonObject.get("DeptID"));
	//	se_Order.setWritePersonID((Integer) jsonObject.get("WritePersonID"));//就是用户对应的id;
		se_Order.setWritePersonID(1);
		se_Order.setWriteDate((String) jsonObject.get("WriteDate"));
		
		Long OrderID=Se_OrderService.add(se_Order);
		System.out.println("新增的order自增主键："+OrderID);
		//这个是对订单详情进行批量插入
		JSONArray jsonArray=JSONArray.fromObject(jsonObject.get("Se_OrderDt"));
		List<Se_OrderDt> listSe_OrderDt=new ArrayList<Se_OrderDt>();
		for(int i=0;i<jsonArray.size();i++){
			Se_OrderDt se_OrderDt=new Se_OrderDt();
			JSONObject jsonDt=JSONObject.fromObject(jsonArray.get(i));
			se_OrderDt.setOrderID(Integer.parseInt(OrderID.toString()));
			se_OrderDt.setGoodsID((Integer.parseInt( jsonDt.get("GoodsID").toString())));
			if(!jsonDt.get("Number").toString().equals(""))
				se_OrderDt.setNumber(Double.valueOf( jsonDt.get("Number").toString()));
			else se_OrderDt.setNumber(null);
			if(!jsonDt.get("Price").toString().equals(""))
				se_OrderDt.setPrice(Double.valueOf( jsonDt.get("Price").toString()));
			else se_OrderDt.setPrice(null);
			if(!jsonDt.get("Money").toString().equals(""))
				se_OrderDt.setMoney(Double.valueOf( jsonDt.get("Money").toString()));
			else se_OrderDt.setMoney(null);
				
			se_OrderDt.setDtDeliveryDate((String) jsonDt.get("DtDeliveryDate"));
			se_OrderDt.setDtNotes((String) jsonDt.get("DtNotes"));
			if(!jsonDt.get("PKGNum").toString().equals(""))
				se_OrderDt.setPKGNum(Double.valueOf( jsonDt.get("PKGNum").toString()));
			listSe_OrderDt.add(se_OrderDt);
		}
		Se_OrderService.addDt(listSe_OrderDt);
	}
	//提交采购订单和订单详情
		@RequestMapping("addpur_order")
		public void addpur_order(HttpServletRequest req,HttpServletResponse res) throws IOException{
			req.setCharacterEncoding("utf-8");
			System.out.println(req.getParameter("order"));
			//System.out.println(req.getSession().getAttribute("userid"));
			//这个是对订单数据进行封装
			JSONObject jsonObject=JSONObject.fromObject(req.getParameter("order"));		
			Pu_PurOrder pu_Order=new Pu_PurOrder();
			pu_Order.setPurOrderCode((String) jsonObject.get("PurOrderCode"));
			pu_Order.setBuyerID((Integer) jsonObject.get("BuyerID"));
			pu_Order.setContractCode((String) jsonObject.get("ContractCode"));
			pu_Order.setSupplierID((Integer) jsonObject.get("SupplierID"));
			pu_Order.setSignAddr((String) jsonObject.get("SignAddr"));
			pu_Order.setSignDate((String) jsonObject.get("SignDate"));
			pu_Order.setDeliveryAddr((String) jsonObject.get("DeliveryAddr"));
			pu_Order.setAogDate((String) jsonObject.get("AogDate"));
			pu_Order.setSettleID((Integer) jsonObject.get("SettleID"));
			if(!jsonObject.get("PayDays").toString().equals(""))
				pu_Order.setPayDays((Integer.parseInt( jsonObject.get("PayDays").toString())));
		//	se_Order.setWritePersonID((Integer) jsonObject.get("WritePersonID"));//就是用户对应的id;
			pu_Order.setWritePersonID(1);
			pu_Order.setWriteDate((String) jsonObject.get("WriteDate"));
			
			Long PurOrderID=pu_PurOrderService.add(pu_Order);
			System.out.println("新增的order自增主键："+PurOrderID);
			//这个是对订单详情进行批量插入
			JSONArray jsonArray=JSONArray.fromObject(jsonObject.get("Pu_PurOrderDt"));
			List<Pu_PurOrderDt> list_OrderDt=new ArrayList<Pu_PurOrderDt>();
			for(int i=0;i<jsonArray.size();i++){
				Pu_PurOrderDt pu_PurOrderDt=new Pu_PurOrderDt();
				JSONObject jsonDt=JSONObject.fromObject(jsonArray.get(i));
				pu_PurOrderDt.setPurOrderID(Integer.parseInt(PurOrderID.toString()));
				pu_PurOrderDt.setGoodsID((Integer.parseInt( jsonDt.get("GoodsID").toString())));
				if(!jsonDt.get("Number").toString().equals(""))
					pu_PurOrderDt.setNumber(Double.valueOf( jsonDt.get("Number").toString()));
				else pu_PurOrderDt.setNumber(null);
				if(!jsonDt.get("Price").toString().equals(""))
					pu_PurOrderDt.setPrice(Double.valueOf( jsonDt.get("Price").toString()));
				else pu_PurOrderDt.setPrice(null);
				if(!jsonDt.get("Money").toString().equals(""))
					pu_PurOrderDt.setMoney(Double.valueOf( jsonDt.get("Money").toString()));
				else pu_PurOrderDt.setMoney(null);
					
				pu_PurOrderDt.setDtAogDate((String) jsonDt.get("DtAogDate"));
				pu_PurOrderDt.setDtNotes((String) jsonDt.get("DtNotes"));
				if(!jsonDt.get("PKGNum").toString().equals(""))
					pu_PurOrderDt.setPKGNum(Double.valueOf( jsonDt.get("PKGNum").toString()));
				list_OrderDt.add(pu_PurOrderDt);
			}
			pu_PurOrderService.addDt(list_OrderDt);
		}
}
