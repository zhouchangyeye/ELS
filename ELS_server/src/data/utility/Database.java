package data.utility;

import  java.sql.*;

public class Database {
		Connection con;
        
        final String URL="jdbc:mysql://127.0.0.1:3306/elsdb";
	
	public Database(){	
        try {
		    Class.forName("com.mysql.jdbc.Driver");        //加载jdbc驱动程序
		    con=DriverManager.getConnection(URL,"root","");
		    System.out.println("连接数据库成功");
	    } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
	    }
	}
	public Connection getConnection(){
		return con;
	}
}
 