package org.rssfeed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public boolean getConnection() throws ClassNotFoundException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 return true;
}
}
