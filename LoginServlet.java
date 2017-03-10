package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon=null;
      static ResultSet rs=null;
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("un");
		String pwd=request.getParameter("pw");
		
		Statement smt=null;
		String searchQuery="select *from reg_details where uname='"+uname+"' AND password='"+pwd+"'";
		System.out.println("your user name"+uname);
		System.out.println("your user name"+pwd);
		try{
			//Class.forName("com.mysql.jdbc.Driver");	
			currentCon=ConnectionManager.getConnection();
			smt=currentCon.createStatement();
			rs=smt.executeQuery(searchQuery);
			boolean more=rs.next();
			if(!more)
			{
				System.out.println("sorry,you are not registered");
			}
			else if(more)
			{
				String firstName=rs.getString("uname");
				PrintWriter out=response.getWriter();
				System.out.println("welcome"+firstName);
				out.println("welcome"+firstName);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("login Failed");
		}
		finally
		{
			if(rs!=null){
				try{
					rs.close();
				}catch (Exception e){}
				rs=null;
			}
			if(smt!=null){
				try{
					smt.close();
					
				}catch (Exception e){}
				smt=null;
			}
			if(currentCon!=null){
				try{
					currentCon.close();
					
				}catch (Exception e){}
				currentCon=null;
			}
		}
	}

}
