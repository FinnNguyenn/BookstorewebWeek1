/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverlet;


import dao.khachHangDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import java.io.IOException;


/**
 *
 * @author AN THANH
 */
@WebServlet("/login")
public class LoginSeverlet extends HttpServlet {
    private khachHangDAO ad;
    private static final long serialVersionUID = 1L;
    
     public void init(){
         ad = new khachHangDAO();
     }
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         Account tmp = new Account();
         tmp.setUsername(username);
         tmp.setPassword(password);
         
         boolean isValid = ad.checkLogin(tmp);
         if(isValid){
             request.getSession().setAttribute("account", tmp);
            response.sendRedirect("home.jsp");
         }
         else{
              request.setAttribute("errorMessage", "Sai username hoặc password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
         }
     }
     
}
