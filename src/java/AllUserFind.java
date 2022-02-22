 

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class AllUserFind extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        try {
            Connection conn = GetConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * from employees");
            ResultSet rst = stmt.executeQuery();
            ArrayList<String[]> al = new ArrayList<String[]>();
            while(rst.next()) {
                String name = rst.getString("name");
                String salary = rst.getString("salary");
                String department = rst.getString("department");
                String email = rst.getString("email");
                al.add(new String[]{name, salary, department, email});
            }
            request.setAttribute("details", al);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AllUserJsp.jsp");
            rd.include(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllUserFind.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AllUserFind.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    } 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
