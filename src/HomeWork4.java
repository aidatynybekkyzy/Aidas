import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.*;
import java.util.ArrayList;

public class HomeWork4 {
    private final String url =
            "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "010499";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {

        HomeWork4 homeWork4 = new HomeWork4();
        System.out.println(homeWork4.totalSalary());
        System.out.println(homeWork4.listOfTrainers());
        System.out.println(homeWork4.fio_trainers());
    }

    public String listOfTrainers() {
        String SQL = "select tr.name_trainers,sp.salary from trainers tr inner join sports sp on tr.sport_id=sp.id; ";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println(
                        rs.getString("name_trainers") +
                                " " +
                                rs.getString("salary"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return " Done";
    }

    public int totalSalary() {
        String SQL = "select sum(salary) from sports; ";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {

                System.out.println("total summ : ");
                System.out.println(
                        count += rs.getInt(1));
            }
            System.out.println(count);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public String fio_trainers() {
        String SQL = "select name_trainers from trainers ";
        String list;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                list = rs.getString(1);
                if (list.length() > 3) {
                    System.out.println(list + " Молодец ");
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return " Done";
    }

}
