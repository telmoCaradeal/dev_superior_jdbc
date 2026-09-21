package Application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramaInsert {

    public static void main(String[] args) throws SQLException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.conectar();

            st = conn.prepareStatement(
                    "INSERT INTO vendedor"
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Pedro Lopes");
            st.setString(2, "pedro.lopes@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("29/10/1987").getTime()));
            st.setDouble(4, 1500.0);
            st.setInt(5, 4);

            int linhasInseridas = st.executeUpdate();

            if (linhasInseridas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) { int id = rs.getInt(1);
                    System.out.println("ID: " + id);
                }

                System.out.println("linhas inseridas: " + linhasInseridas);

            } else {

                System.out.println("Nenhuma linha foi inserida .");
            }





        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

        finally {
            st.close();
            conn.close();
        }

    }
}
