package com.aohua.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

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
				if(se_Order.getCustID()==null)
					ps.setNull(2,Types.INTEGER);
				else ps.setInt(2, se_Order.getCustID());
				ps.setString(3, se_Order.getContractCode());
				if(se_Order.getSellerID()==null)
					ps.setNull(4,Types.INTEGER);
				else ps.setInt(4, se_Order.getSellerID());
				ps.setString(5, se_Order.getSignAddr());
				if(se_Order.getSignDate().equals(""))
					ps.setNull(6, Types.DATE);
				else ps.setString(6, se_Order.getSignDate());
				ps.setString(7, se_Order.getDeliveryAddr());
				if(se_Order.getDeliveryDate().equals(""))
					ps.setNull(8, Types.DATE);
				else ps.setString(8, se_Order.getDeliveryDate());
				if(se_Order.getFreight()==null)
					ps.setNull(9, Types.DOUBLE);
				else ps.setDouble(9, se_Order.getFreight());
				if(se_Order.getTransportID()==null)
					ps.setNull(10, Types.INTEGER);
				else ps.setInt(10, se_Order.getTransportID());
				if(se_Order.getSettleID()==null)
					ps.setNull(11, Types.INTEGER);
				else ps.setInt(11, se_Order.getSettleID());
				if(se_Order.getReceDays()==null)
					ps.setNull(12, Types.INTEGER);
				else ps.setInt(12, se_Order.getReceDays());
				if(se_Order.getDeptID()==null)
					ps.setNull(13, Types.INTEGER);
				else ps.setInt(13, se_Order.getDeptID());
				if(se_Order.getWritePersonID()==null)
					ps.setNull(14, Types.INTEGER);
				else ps.setInt(14, se_Order.getWritePersonID());
				if(se_Order.getWriteDate()==null)
					ps.setNull(15, Types.INTEGER);
				else ps.setString(15, se_Order.getWriteDate());
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
				if(list.get(i).getOrderID()==null)
					ps.setNull(1, Types.INTEGER);
				else ps.setInt(1, list.get(i).getOrderID());
				if(list.get(i).getGoodsID()==null)
					ps.setNull(2, Types.INTEGER);
				else ps.setInt(2, list.get(i).getGoodsID());
				if(list.get(i).getNumber()==null)
					ps.setNull(3, Types.DOUBLE);
				else ps.setDouble(3, list.get(i).getNumber());
				if(list.get(i).getPrice()==null)
					ps.setNull(4, Types.DOUBLE);
				else ps.setDouble(4, list.get(i).getPrice());
				if(list.get(i).getMoney()==null)
					ps.setNull(5, Types.DOUBLE);
				else ps.setDouble(5, list.get(i).getMoney());
				if(list.get(i).getDtDeliveryDate().equals(""))
					ps.setNull(6, Types.DATE);
				else ps.setString(6, list.get(i).getDtDeliveryDate());
				ps.setString(7, list.get(i).getDtNotes());
				if(list.get(i).getPKGNum()==null)
					ps.setNull(8, Types.DOUBLE);
				else ps.setDouble(8, list.get(i).getPKGNum());
			}
			public int getBatchSize() {
				return list.size();
			}
		});
	}
	public List<Map<String,Object>> findbyid(int OrderID){
		 //通过订单的id找到订单的所有消息
		String sql="SELECT o.OrderCode,c.CustName,o.ContractCode,"
				+ "e.EmpName as SellerName,o.SignAddr,date_format(o.SignDate , '%Y-%m-%d') as SignDate,"
				+ "o.DeliveryAddr,date_format(o.DeliveryDate , '%Y-%m-%d') as DeliveryDate,o.Freight,t.TransportName,"
				+ "s.SettleName,o.ReceDays,d.DeptName,u.UserName AS WritePersonName,"
				+ "date_format(o.WriteDate , '%Y-%m-%d') as WriteDate FROM (((((se_order o "
				+ "LEFT JOIN se_customer c on  o.CustID=c.CustID) "
				+ "LEFT JOIN employee e ON  o.SellerID=e.EmpID) "
				+ "LEFT JOIN transportmode t ON  o.TransportID=t.TransportID) "
				+ "LEFT JOIN settlemode s ON  o.SettleID=s.SettleID) "
				+ "LEFT JOIN department d ON o.DeptID=d.DeptID) LEFT JOIN "
				+ "userlist u ON o.WritePersonID=u.UserID WHERE o.OrderID="+OrderID;
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public List<Map<String,Object>> finddtbyid(int OrderID){
		 //通过订单的id找到订单详情的所有消息
		String sql="SELECT g.GoodsName,o.Number,o.Price,"
				+ "o.Money,date_format(o.DtDeliveryDate , '%Y-%m-%d') AS DtDeliveryDate,"
				+ "o.DtNotes,o.PKGNum FROM se_orderdt o LEFT JOIN "
				+ "goodscode g ON o.GoodsID=g.GoodsID WHERE o.OrderID="+OrderID;
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public List<Map<String,Object>> find(int WritePersonID){
		//每个用户能看到的订单列表
		String sql="select s.OrderID,s.OrderCode,c.CustName,s.State,"
				+ "date_format(s.WriteDate , '%Y-%m-%d') as WriteDate from se_order s,se_customer c "
				+ "WHERE s.CustID=c.CustID AND s.WritePersonID="+WritePersonID+" order by s.State";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public void update(int OrderID,int State,String AuditOpinion){
		//订单审核，更新订单数据
		String sql="UPDATE se_order SET State="+State+",AuditOpinion='"+AuditOpinion+"' WHERE OrderID="+ OrderID;
		jdbcTemplate.update(sql);
	}
}
