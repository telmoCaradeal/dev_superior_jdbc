package Application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Programa {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            conn = DB.conectar();

            st = conn.createStatement();
            rs = st.executeQuery("Select * from departamento");

            while(rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            DB.closeResultSet(rs);
            DB.closeStatment(st);
            DB.fecharConexao(conn);
        }
    }
}
