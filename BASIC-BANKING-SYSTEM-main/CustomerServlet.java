import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;
public class CustomerServlet extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<center><h1>Customer Details</h1></center>");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","HOnEY@18022003");
Statement stm = con.createStatement();
ResultSet rs=stm.executeQuery("select * from customer");
out.println("<center> <table width=100% height=100% border=1px >");
out.println("<tr><th>Bank Account Number</th> <th> Name of the Accountant</th> <th> E-mail id</th> <th> Current Balance</th> </tr>");
while(rs.next())
{
out.println("<tr> <td> "+rs.getString(1)+"</td> ");
out.println("<td> "+rs.getString(2)+"</td> ");
out.println("<td> "+rs.getString(3)+"</td>");
out.println("<td> "+rs.getInt(4)+"</td></tr> ");
}
out.println("</table></center>");
con.close();
}
catch(SQLException sq)
{
out.println("sql exception"+sq);
}

catch(ClassNotFoundException cl)
{
out.println("class not found"+cl);
}
}
}