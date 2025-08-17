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
import model.khachHang;
import java.io.IOException;

/**
 *
 * @author AN THANH
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String diachi = request.getParameter("diachi");
        
       khachHangDAO kd = new khachHangDAO();
       khachHang kh = new khachHang();
       kh.setName(fullName);
       kh.setTel(phone);
       kh.setEmail(email);
       kh.setAddress(diachi);
       int accountId = kd.KHregister(kh);
        System.out.println("Full name from request = " + fullName);
        System.out.println("kh.getName() before insert = " + kh.getName());
        
        if (accountId > 0) {
             Account ac = new Account();
            ac.setUsername(username);
            ac.setPassword(password);
            kh.setAccount(ac);
            kh.setId(accountId);
              System.out.println("kh.getName() before insert = " + kh.getId());
            int success = kd.register(kh);
            if (success < 0) {
                request.setAttribute("errorMessage", "Đăng ký thất bại khi lưu thông tin khách hàng.");
            } else {
                request.setAttribute("message", "Đăng ký thành công!");
            }
        } else {
            request.setAttribute("errorMessage", "Đăng ký thất bại khi lưu tài khoản.");
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}

