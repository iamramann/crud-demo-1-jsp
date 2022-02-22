
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = GetConnection.getConnection();
            PreparedStatement details = conn.prepareStatement("UPDATE employees SET name = ?, department = ?, salary = ? WHERE email = ?");
            String name = request.getParameter("name");
            details.setString(1, name);
            String department = request.getParameter("department");
            details.setString(2, department);
            String salary = request.getParameter("salary");
            details.setString(3, salary);
            String email = request.getParameter("email");
            details.setString(4, email);

            details.executeUpdate();
            request.setAttribute("updation_message", "Record udpated successfully");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.include(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
