package testjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//setup connection variables
		final String jdbcUrl = "jdbc:mysql://localhost:3306/mateuszs_WirtualnyDziekanat?useSSL=false";
		final String user = "mateuszs_root";
		final String pass = "polki1234";
		String driver = "com.mysql.jdbc.Driver";
		
		//get connection to database
		try{
			PrintWriter out = response.getWriter();
			
			out.println("Connectin to databse: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println(" ");
			out.println("Connection succesful!");
			
			myConn.close();
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
	}

}
