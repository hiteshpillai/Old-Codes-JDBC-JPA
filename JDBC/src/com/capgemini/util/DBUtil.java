/*This is only to create a connection*/

package com.capgemini.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	static Connection con;
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.51.103.201:1521:orcl11g";
			String user = "lab03trg9";
			String password = "lab03oracle";
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnect(){
		return con;
	}
	
}
