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

import com.aohua.model.Pu_PurOrder;
import com.aohua.model.Pu_PurOrderDt;
import com.mysql.jdbc.Statement;

@Repository
public class Pu_PurOrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//新增订单数据，返回主键
	public Long add(final Pu_PurOrder pu_PurOrder){

		KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(java.sql.Connection con)
					throws SQLException {
				String sql = "insert into pu_purorder(PurOrderCode,BuyerID,SupplierID,"
						+ "ContractCode,SettleID,PayDays,"
						+ "SignAddr,SignDate,DeliveryAddr,"
						+ "AogDate,WritePersonID,WriteDate) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";   
				PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
				ps.setString(1, pu_PurOrder.getPurOrderCode());
				if(pu_PurOrder.getBuyerID()==null)
					ps.setNull(2,Types.INTEGER);
				else ps.setInt(2, pu_PurOrder.getBuyerID());
				if(pu_PurOrder.getSupplierID()==null)
					ps.setNull(3,Types.INTEGER);
				else ps.setInt(3, pu_PurOrder.getSupplierID());
				ps.setString(4, pu_PurOrder.getContractCode());
				if(pu_PurOrder.getSettleID()==null)
					ps.setNull(5, Types.INTEGER);
				else ps.setInt(5, pu_PurOrder.getSettleID());
				if(pu_PurOrder.getPayDays()==null)
					ps.setNull(6, Types.INTEGER);
				else ps.setInt(6, pu_PurOrder.getPayDays());
				ps.setString(7, pu_PurOrder.getSignAddr());
				if(pu_PurOrder.getSignDate().equals(""))
					ps.setNull(8, Types.DATE);
				else ps.setString(8, pu_PurOrder.getSignDate());
				ps.setString(9, pu_PurOrder.getDeliveryAddr());
				if(pu_PurOrder.getAogDate().equals(""))
					ps.setNull(10, Types.DATE);
				else ps.setString(10, pu_PurOrder.getAogDate());
				if(pu_PurOrder.getWritePersonID()==null)
					ps.setNull(11, Types.INTEGER);
				else ps.setInt(11, pu_PurOrder.getWritePersonID());
				if(pu_PurOrder.getWriteDate().equals(""))
					ps.setNull(12, Types.INTEGER);
				else ps.setString(12, pu_PurOrder.getWriteDate());
				return ps;
			}
		}, keyHolder);
		Long generatedId = keyHolder.getKey().longValue();   
		return generatedId;   
	}
	//批量新增订单详情数据
	public void addDt(final List<Pu_PurOrderDt> list){
		String sql="insert into pu_purorderdt(PurOrderID,GoodsID,Number,"
				+ "Price,Money,DtAogDate,"
				+ "DtNotes,PKGNum) values (?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				if(list.get(i).getPurOrderID()==null)
					ps.setNull(1, Types.INTEGER);
				else ps.setInt(1, list.get(i).getPurOrderID());
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
				if(list.get(i).getDtAogDate().equals(""))
					ps.setNull(6, Types.DATE);
				else ps.setString(6, list.get(i).getDtAogDate());
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
		String sql="SELECT p.PurOrderCode,e.EmpName as BuyerName,s.Name as SupplierName,"
				+ "p.ContractCode,sm.SettleName,p.PayDays,p.SignAddr,date_format(p.SignDate , '%Y-%m-%d')as SignDate,"
				+ "p.DeliveryAddr,date_format(p.AogDate, '%Y-%m-%d')as AogDate,u.UserName as WritePersonName,"
				+ "date_format(p.WriteDate, '%Y-%m-%d')as WriteDate FROM (((pu_purorder p "
				+ "LEFT JOIN employee e ON p.BuyerID=e.EmpID) "
				+ "LEFT JOIN pu_supplier s ON p.SupplierID=s.SupplierID) "
				+ "LEFT JOIN settlemode sm ON p.SettleID=sm.SettleID) "
				+ "LEFT JOIN userlist u ON p.WritePersonID=u.UserID WHERE p.PurOrderID="+OrderID;
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public List<Map<String,Object>> finddtbyid(int OrderID){
		 //通过订单的id找到订单详情的所有消息
		String sql="SELECT g.GoodsName,o.Number,o.Price,o.Money,"
				+ "date_format(o.DtAogDate , '%Y-%m-%d') AS DtAogDate,"
				+ "o.DtNotes,o.PKGNum FROM pu_purorderdt o "
				+ "LEFT JOIN goodscode g ON o.GoodsID=g.GoodsID WHERE o.PurOrderID="+OrderID;
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public List<Map<String,Object>> find(int WritePersonID){
		//每个用户能看到的订单列表
		String sql="select p.PurOrderID,p.PurOrderCode,s.Name,p.State,"
				+ "date_format(p.WriteDate , '%Y-%m-%d') as WriteDate from pu_purorder p , pu_supplier s "
				+ "WHERE p.SupplierID=s.SupplierID AND p.WritePersonID="+WritePersonID+" order by p.State";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public void update(int PurOrderID,int State,String AuditOpinion){
		//订单审核，更新订单数据
		String sql="UPDATE pu_purorder SET State="+State+",AuditOpinion='"+AuditOpinion+"' WHERE PurOrderID="+ PurOrderID;
		jdbcTemplate.update(sql);
	}
}
