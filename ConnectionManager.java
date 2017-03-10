package example;
import java.sql.*;

public class ConnectionManager {
	
	static Connection con;
	//static String url;
	public static Connection getConnection()
	{
		try
		{
		//String url="jdbc:mysql://localhost:3306/Demo";
		Class.forName("com.mysql.jdbc.Driver");	
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","root3");
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
catch(ClassNotFoundException e)

{
System.out.println(e);	
}
return con;
}
}
