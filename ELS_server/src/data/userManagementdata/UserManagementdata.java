package data.userManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import po.userPO.UserPO;
import data.utility.Database;
import dataservice.userManagementdataservice.UserManagementdataservice;
import state.ResultMessage;

public class UserManagementdata extends UnicastRemoteObject implements UserManagementdataservice{
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    UserPO po;
    
    public UserManagementdata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
    
	@Override
	public ResultMessage add(UserPO po) {
		// TODO Auto-generated method stub
		
		try {
			stmt = con.prepareStatement("INSERT INTO user(ID,password) VALUES(?,?)");
			stmt.setString(1, po.getId());
		    stmt.setString(2, po.getPassword());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		try {
			stmt=con.prepareStatement("DELETE FROM user WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<Ids.size();i++){
			stmt=con.prepareStatement("DELETE FROM user WHERE ID=?");
			stmt.setString(1, Ids.get(i));
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
	public ResultMessage update(UserPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE agency SET password=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getPassword());
			stmt.setString(2, po.getId());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public UserPO find(String Id) {
		// TODO Auto-generated method stub
		po = new UserPO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM agency WHERE ID='"+Id+"'");
			
			 //大小写无区别，此处大写为区别表的名字，where表示条件
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setId(Id);
		        po.setPassword("password");
		        
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return po;
	}

}
