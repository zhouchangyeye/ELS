
package data.inforManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.BankAccountPO;
import data.utility.Database;
import dataservice.inforManagementdataservice.BankAccountInfordataservice;
import state.ResultMessage;

public class BankAccountInfordata extends UnicastRemoteObject implements BankAccountInfordataservice {
	public BankAccountInfordata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    BankAccountPO po;
    JavaBean1 jb1;
    
    
//增加新银行账户信息
public ResultMessage add(BankAccountPO po){
	try {
		stmt = con.prepareStatement("INSERT INTO bankAccount(name,amount) VALUES(?,?)");
		stmt.setString(1, po.getName());
	    stmt.setDouble(2, po.getAmount());
	    stmt.executeUpdate();
	    return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.Fail;
	}
}

//查找银行账户信息
public JavaBean1 find(String name){
	po = new BankAccountPO();
	jb1=new JavaBean1();
	jb1.setResultMessage(ResultMessage.NotExist);
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM bankAccount WHERE name='"+name+"'");
		
		 //大小写无区别，此处大写为区别表的名字，where表示条件
		ResultSet rs=ps.executeQuery(); 
		if(rs.next()){
		    po.setName(name);
	        po.setAmount(rs.getDouble("amount"));
	        po.setUsage(rs.getString("use"));
	        jb1.setResultMessage(ResultMessage.Success);
	        jb1.setObject(po);
		}
		return jb1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return jb1;
	}
}

//删除银行信息
public ResultMessage deleteOne(String name){
	try {
		stmt=con.prepareStatement("DELETE FROM bankAccount WHERE name=?");
		stmt.setString(1, name);
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}

@Override
public ResultMessage deleteMany(ArrayList<String> names) {
	// TODO Auto-generated method stub
	try {
		for(int i=0;i<names.size();i++){
		stmt=con.prepareStatement("DELETE FROM bankAccount WHERE name=?");
		stmt.setString(1, names.get(i));
		stmt.executeUpdate();
		}
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}

//修改银行账户信息
public ResultMessage update(BankAccountPO po){
	try {
		String sql=("UPDATE bankAccount SET amount=? WHERE name=?");
		stmt=con.prepareStatement(sql);
		stmt.setDouble(1, po.getAmount());
		stmt.setString(2, po.getName());
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}
@Override
public ResultMessage updateBalance(double amount) throws RemoteException {
	// TODO Auto-generated method stub
	String sql="select * from bankaccount where use='InUse'";
	double bankAmount=0;
	try {
		stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			bankAmount=rs.getDouble(rs.getString("amount"));
		}bankAmount=bankAmount+amount;
		sql="update bankaccount set amount=? where use='InUse'";
		stmt=con.prepareStatement(sql);
		stmt.setDouble(1, bankAmount);
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.Fail;
	}
}
@Override
public ResultMessage setInUse(String accountName) throws RemoteException {
	// TODO Auto-generated method stub
	String sql="update bankaccount set use=? where name=?";
	try {
		stmt=con.prepareStatement(sql);
		stmt.setString(1, "InUse");
		stmt.setString(2, accountName);
		stmt.executeUpdate();
		sql="update bankaccount set use=? where name<>?,use='Inuse'";
		stmt=con.prepareStatement(sql);
		stmt.setString(1, "NotInUse");
		stmt.setString(2, accountName);
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}

//public static void main(String[] args) {
//	BankAccountInfordata bank=new BankAccountInfordata();
//	try {
//		bank.setInUse("00001");
//		bank.updateBalance(200);
//	} catch (RemoteException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//}
}
