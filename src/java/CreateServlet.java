
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//           try {
//            Statement stmt = GetConnection.getConnection();
//            String name = request.getParameter("name");
//            String email = request.getParameter("email");
//            String salary = request.getParameter("salary");
//            String department = request.getParameter("department");            
//            String sql = "INSERT INTO country_population(name, email, salary, department) VALUES (" +name+"," +email+ "," +salary+ "," +department+ ");";
//            int b = stmt.executeUpdate(sql);
//            PrintWriter out = response.getWriter();
//            out.println("test");
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
//            rd.include(request, response);
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = GetConnection.getConnection();
            PreparedStatement details = conn.prepareStatement("INSERT INTO employees VALUES(?,?,?,?)");
            String name = request.getParameter("name");
            details.setString(1, name);
            String email = request.getParameter("email");
            details.setString(2, email);
            String salary = request.getParameter("salary");
            details.setString(3, salary);
            String department = request.getParameter("department");
            details.setString(4, department);
            details.executeUpdate();
            request.setAttribute("creation_message", "Record inserted successfully");
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
