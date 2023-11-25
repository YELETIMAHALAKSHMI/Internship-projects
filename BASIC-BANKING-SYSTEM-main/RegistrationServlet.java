import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegistrationServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String username = req.getParameter("username");
String password = req.getParameter("password");
int balance = Integer.parseInt(req.getParameter("balance"));
String email = req.getParameter("email");
Random rd = new Random();
List<String> accn = Arrays.asList("0", "1","2","3","4","5","6","7", "8", "9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
String accno = "";
for(int i = 0;i < 10; i++){
int idx = rd.nextInt(accn.size());
accno += accn.get(idx);
}
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false", "root", "HOnEY@18022003");
String q = "insert into customer(AccountNo, Name, Email, Balance, Password) values(?,?,?,?,?)";
PreparedStatement stm = con.prepareStatement(q);
stm.setString(1, accno);
stm.setString(2, username);
stm.setString(3, email);
stm.setInt(4, balance);
stm.setString(5, password);
int x = stm.executeUpdate();
System.out.println("Data upadated sucessfully...." + x);
if(x > 0){
out.print("<html><br><br><center><img src = 'data:image/jpeg;base64,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CMVDKm8rn523jMtzq1Om5Q7iwCEKqkljULhAo7z/AG2+jEr7/QGq1HJqBVqB1cqpDMjoU2MQdrKM5yRngJLaNUap1zVF60GnsIRtm2mKgAZS2eIqPyPhA2316iAD2zwLMBTYlFDFSXHye0CPsMg67TG8lXC0yVaps7JYEDapByTkgDhMJ0usH6xay9Yy7KjGnw2hmZdgzwwGI4585hp6CwaqQaX91mbcaRLYYg7WBO1l4Y5CBtvr1JcZD7u0WXq33Kq43My+A3Lyzz4Sf+dTLdiptVghfYNu8sqgA5zzZe6Vz9HqhTZ1qg5Yp2G/tbgADSbduXGCcE448psf06uyrxHWVHD9bs4jayuobx7SDMCxTVKZrGhk7wxU8OG5UWoeP1XWWE5saLWWqLhalPrC7O4KPtw1NKYC4bPKmDx8TOhTOBnnjjjxge4iICIiAiIgfBvTZeez2/vvij02Xns9v774oiA9Nl57Pb+++KPTZeez2/vviiID02Xns9v774o9Nd57Pb+++OIgPTXeez2/vvjkemu79mt/ffFEQHpru/Zrf33xQf413fs1v774oiBPprvPZ7f33xyPTXd+zW/vviiIE+mu89nt/ffHHprvPZ7f33xxEB6a7z2e3998cemu89nt/ffHEQI9Nd37Nb+++KT6a7z2e3998cRAemu89nt/ffHHprvPZ7f33xxECPTXd+zW/vvij013fs1v774oiBPprvPZ7f33xx6a7z2e3998cRAemu89nt/ffHHprvPZ7f33xxEB6a7z2e3998cemu89nt/ffHEQHprvPZ7f33xx6bLz2e3998URAemy89nt/ffFHpsvPZ7f33xREB6bLz2e3998Uemy89nt/ffFEQHpsvPZ7f33xREQP//Z' width = 500 height = 400 <br></center></html>");
out.println("<h2><center>Your account number to use for login is " + accno +"...</center></h2>");
out.println("<h1><center><a href = 'home1.html'>Cilck this to go back <---</a></center></h1>");
}
else{
out.println("<html>Register Not successful</html>");
}
con.close();}
catch(Exception e){
out.print(e);
}}}