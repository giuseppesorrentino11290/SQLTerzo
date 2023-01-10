import java.sql.*;
import java.util.ArrayList;

public class Start {

    public static void main(String[] args) {

        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "passwordhere";

            con = DriverManager.getConnection(url, user, password);

            Statement s = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";

            ArrayList<String> surnames = new ArrayList<>();
            s.executeUpdate(sql);
            System.out.println("Table created.");

            ResultSet rs = s.executeQuery("SELECT first_name, last_name FROM newdb.student");

            while(rs.next())
            {
                System.out.println(rs.getString("first_name"));
                surnames.add(rs.getString("last_name"));
            }

            System.out.println(surnames);

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(con != null)
                    con.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
