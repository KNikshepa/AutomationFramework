package com.DatabaseUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Enum.EnumForConfigFile;
import com.PropertyFileReader.ReadPropertyFile;

public class DatabaseConnection {

	private static ThreadLocal<Connection> threadLocalConnection=ThreadLocal.withInitial(()->
	{
		
		try {
			return createConnection();
		}catch (SQLException | IOException e) {
			   e.printStackTrace();
			   return null;
		}}
	);

	private static Connection createConnection() throws SQLException,IOException
	{
		String dbUrl=ReadPropertyFile.getValue(EnumForConfigFile.dburl);
		String dbusername=ReadPropertyFile.getValue(EnumForConfigFile.dbusername);
		String dbemailid=ReadPropertyFile.getValue(EnumForConfigFile.dbpassword);
		return DriverManager.getConnection(dbUrl, dbusername, dbemailid);
	}
	
	public static Connection getConnection()
	{
		return threadLocalConnection.get();
	}
	
	public static void closeConnection() throws SQLException
	{
		Connection connec=threadLocalConnection.get();
		if(connec!=null && !connec.isClosed())
		{
			connec.close();
            threadLocalConnection.remove();
		}
	}
	
	 public static ResultSet getUserData() throws SQLException {
	        Connection conn = getConnection();
	        Statement stmt = conn.createStatement();
	        String sql = "SELECT username, email_address FROM users";
	        return stmt.executeQuery(sql);
	    }
}
