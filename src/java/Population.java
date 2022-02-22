
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Population extends HttpServlet {

    public int getTotalRowsCount(Statement stmt) throws SQLException {
        ResultSet details = stmt.executeQuery("SELECT * FROM country_population;");
        details.last();
        return details.getRow();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int pageNumber = Integer.parseInt(request.getParameter("page"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/population", "root", "");
            Statement stmt = conn.createStatement();
            int rows_count = getTotalRowsCount(stmt);
            int minLimit = pageNumber == 1 ? 0 : (pageNumber - 1) * 5;
            int maxLimit = 5;
            ResultSet details = stmt.executeQuery("SELECT * FROM country_population LIMIT " + minLimit + "," + maxLimit + ";");
            HashMap<String, String> record = new HashMap<String, String>();

            while (details.next()) {
                String key = details.getString("country_name");
                String value = details.getString("population");
                record.put(key, value);
            }
            request.setAttribute("rows_count", rows_count);
            request.setAttribute("page_number", pageNumber);
            request.setAttribute("record", record);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view_population.jsp");
            rd.include(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Population.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Population.class.getName()).log(Level.SEVERE, null, ex);
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
