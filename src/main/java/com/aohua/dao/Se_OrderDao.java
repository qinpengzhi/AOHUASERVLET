package com.aohua.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.aohua.model.Se_Order;
import com.aohua.model.Se_OrderDt;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


@Repository
public class Se_OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//新增订单数据，返回主键
	public Long add(final Se_Order se_Order){
		
		 KeyHolder keyHolder = new GeneratedKeyHolder();  
		 jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(java.sql.Connection con)
					throws SQLException {
				 String sql = "insert into se_order(OrderCode,CustID,ContractCode,SellerID,"
			         		+ "SignAddr,SignDate,DeliveryAddr,DeliveryDate,Freight,TransportID,"
			         		+ "SettleID,ReceDays,DeptID,WritePersonID,WriteDate) "
			         		+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";   
				 PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
				 ps.setString(1, se_Order.getOrderCode());
				 int aa=se_Order.getCustID();
				 System.out.println(se_Order.getCustID());
				 ps.setInt(2, se_Order.getCustID());
				 ps.setString(3, se_Order.getContractCode());
				 ps.setInt(4, se_Order.getSellerID());
				 ps.setString(5, se_Order.getSignAddr());
				 ps.setString(6, se_Order.getSignDate());
				 ps.setString(7, se_Order.getDeliveryAddr());
				 ps.setString(8, se_Order.getDeliveryDate());
				 ps.setDouble(9, se_Order.getFreight());
				 ps.setInt(10, se_Order.getTransportID());
				 ps.setInt(11, se_Order.getSettleID());
				 ps.setInt(12, se_Order.getReceDays());
				 ps.setInt(13, se_Order.getDeptID());
				 ps.setInt(14, se_Order.getWritePersonID());
				 ps.setString(15, se_Order.getWriteDate());
				return ps;
			}
		}, keyHolder);
		Long generatedId = keyHolder.getKey().longValue();   
		return generatedId;   
	}
	//批量新增订单详情数据
	public void addDt(final List<Se_OrderDt> list){
		String sql="insert into se_orderdt(OrderID,GoodsID,Number,"
				+ "Price,Money,DtDeliveryDate,"
				+ "DtNotes,PKGNum) values (?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, list.get(i).getOrderID());
				ps.setInt(2, list.get(i).getGoodsID());
				ps.setDouble(3, list.get(i).getNumber());
				ps.setDouble(4, list.get(i).getPrice());
				ps.setDouble(5, list.get(i).getMoney());
				ps.setString(6, list.get(i).getDtDeliveryDate());
				ps.setString(7, list.get(i).getDtNotes());
				ps.setDouble(8, list.get(i).getPKGNum());
			}
			public int getBatchSize() {
				 return list.size();
			}
		});
	}
	public void update(Se_Order se_Order){
		System.out.println("update se_order");
	}
	public void find(int WritePersonID){
		//每个用户能看到的订单列表
		//String sql="select * from "
	}
}
