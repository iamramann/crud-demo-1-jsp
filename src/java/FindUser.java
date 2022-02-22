
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abc
 */
public class FindUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        try {
            conn = GetConnection.getConnection();
            PreparedStatement details = conn.prepareStatement("SELECT * FROM employees WHERE email = ? AND salary = ?");
            String email = request.getParameter("email");
            details.setString(1, email);
            String salary = request.getParameter("salary");
            details.setString(2, salary);
            ResultSet rst = details.executeQuery();
            HashMap<String, String> user = new HashMap<String, String>();
            while (rst.next()) {
                String user_name = rst.getString("name");
                user.put("name", user_name);
                String user_salary = rst.getString("salary");
                user.put("salary", user_salary);
                String user_email = rst.getString("email");
                user.put("email", user_email);
                String user_department = rst.getString("department");
                user.put("department", user_department);
            } 
            request.setAttribute("user", user);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserDetail.jsp");
            rd.include(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FindUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
