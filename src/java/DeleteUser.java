
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

public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn= GetConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM employees WHERE email = ?");
            String email = request.getParameter("email");
            ps.setString(1, email);
            ps.execute();
            request.setAttribute("deletion_message", "record deleted successfully");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
