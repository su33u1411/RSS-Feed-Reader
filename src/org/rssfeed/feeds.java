package org.rssfeed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class feeds {
private String title;
private String link;
private String description;
String url="jdbc:mysql://db4free.net/compsci463";
String user="compsci463";
String password="love2sql";

Connect c=new Connect();

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Title :"+getTitle()+"\n"+"Link :"+getLink()+"\n"+"Description :"+getDescription()+"\n";
}

public boolean InsetRecord(String i,String j,String k) throws ClassNotFoundException{
	String Title=i;
	String Link=j;
	String Description=k;
	if(c.getConnection()==true)
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			String q = "INSERT INTO Feed(Title,Link,Description) VALUES ('"+Title+"','"+Link+"','"+Description+"')";
	    	String h="INSERT INTO compsci463(Table_name) VALUES ('Feed')";
			java.sql.Statement stmt=conn.createStatement();
	    	 stmt.executeUpdate(q);
	    	 stmt.executeUpdate(h);
	    	 return true;
		} 
	catch (SQLException e) 
	{
	e.printStackTrace();
	}
	return false;
}

public void fetchData() throws ClassNotFoundException{
	if(c.getConnection()==true)
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			String q = "SELECT ID,Title,Link,Description, Date FROM Feed";
			String h="SELECT Table_name,Last_Modified From compsci463";
	    	java.sql.Statement stmt=conn.createStatement();
	    	ResultSet rs=stmt.executeQuery(q);
	    	System.out.println("Fetching Data From Feed Table : \n");
	    	while(rs.next()){
	            //Retrieve by column name
	            int id  = rs.getInt("ID");
	            String title = rs.getString("Title");
	            String link = rs.getString("Link");
	            String Description = rs.getString("Description");
	            String Date=rs.getString("Date");

	            //Display values
	            System.out.print("ID: " + id+"\n");
	            System.out.print("Title : " + title+"\n");
	            System.out.print("Link : " + link+"\n");
	            System.out.println("Description : " + Description+"\n");
	            System.out.println("Published Date : " + Date+"\n");
	            }
	    	ResultSet rs1=stmt.executeQuery(h);
	    	System.out.println("Fetching Data From User Table : \n");
	    	while(rs1.next()){
	            //Retrieve by column name
	            String Table_name = rs1.getString("Table_name");
	            String Date=rs1.getString("Last_Modified");

	            //Display values
	            System.out.println("Student Name : compsci463");
	            System.out.print("Feed Name :" + Table_name+"\n");
	            System.out.print("Last Modified : " + Date+"\n");
	            }
		} 
	catch (SQLException e) 
	{
	e.printStackTrace();
	}
}

}
