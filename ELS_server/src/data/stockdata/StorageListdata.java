package data.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import po.stockPO.StorageListPO;
import state.ResultMessage;
import dataservice.stockdataservice.StorageListdataservice;


public class StorageListdata extends UnicastRemoteObject implements StorageListdataservice {

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    JavaBean1 jb1;
    StorageListPO po;
    Stockdata stock=new Stockdata();
    
	public StorageListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(StorageListPO po) {
		// TODO Auto-generated method stub
		String sql="insert into storagelist(ID,inDate,destination,areaNum,rowNum,frameNum,positionNum,generateTime)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getInDate());
			stmt.setString(3, po.getDestination());
			stmt.setString(4, po.getAreaNum());
			stmt.setString(5, po.getRowNum());
			stmt.setString(6, po.getFrameNum());
			stmt.setString(7, po.getPositionNum());
			stmt.setString(8, po.getGenerateTime());
			stmt.executeUpdate();
			stock.storage(po);
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		String sql="delete from storagelist where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		String sql="delete from storagelist where ID=?";
		try {
			for(int i=0;i<idList.size();i++){
				stmt=con.prepareStatement(sql);
			    stmt.setString(1, idList.get(i));
			    stmt.executeUpdate();
			}
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage update(StorageListPO po) {
		// TODO Auto-generated method stub
		po=new StorageListPO();
		String sql="update storagelist set inDate=?,destination=?,areaNum=?,rowNum=?,frameNum=?,positionNum=?,generateTime=? "
				+ "where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getInDate());
			stmt.setString(2, po.getDestination());
			stmt.setString(3, po.getAreaNum());
			stmt.setString(4, po.getRowNum());
			stmt.setString(5, po.getFrameNum());
			stmt.setString(6, po.getPositionNum());
			stmt.setString(7, po.getPositionNum());
			stmt.setString(8, po.getGenerateTime());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		po=new StorageListPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from storagelist where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setId(id);
				po.setInDate(rs.getString(2));
				po.setDestination(rs.getString(3));
				po.setAreaNum(rs.getString(4));
				po.setRowNum(rs.getString(5));
				po.setFrameNum(rs.getString(6));
				po.setPositionNum(rs.getString(7));
				po.setGenerateTime(rs.getString(8));
				jb1.setObject(po);
				jb1.setResultMessage(ResultMessage.Success);
			}return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}

	}

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		po=new StorageListPO();
		ArrayList<StorageListPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from storagelist";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("inDate").equals(date)){
					po.setId(rs.getString(1));
					po.setInDate(date);
					po.setDestination(rs.getString(3));
					po.setAreaNum(rs.getString(4));
					po.setRowNum(rs.getString(5));
					po.setFrameNum(rs.getString(6));
					po.setPositionNum(rs.getString(7));
					po.setGenerateTime(rs.getString(8));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
			}jb1.setObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
		
	}


}
