package Application;

import db.DB;

import java.sql.*;

public class ProgramaUpdate {

    public static void main(String[] args) throws SQLException {


        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;


        try {
            conn = DB.conectar();

            st = conn.prepareStatement("SELECT * FROM vendedor WHERE DepartmentId = ?");
            st.setInt(1, 4);
            rs = st.executeQuery();

            System.out.println("Salário depois da alteração: ");
            System.out.println();
            while(rs.next()) {
                System.out.println(rs.getInt("id") +
                        ", " + rs.getString("name") +
                        ", " + rs.getDouble("BaseSalary"));
            }

            st = conn.prepareStatement(
                    "Update vendedor "
                         + "SET BaseSalary =  BaseSalary + ?  "
                         +   "where DepartmentId = ? ");

            st.setDouble(1, 200.0);
            st.setInt(2, 4);

            System.out.println();
            int linhasAtualizadas = st.executeUpdate();
            System.out.println();

            System.out.println("linhas atualizadas: " + linhasAtualizadas);

            st = conn.prepareStatement("SELECT * FROM vendedor WHERE DepartmentId = ?");
            st.setInt(1, 4);
            rs = st.executeQuery();

            System.out.println("Salário depois da alteração: ");
            System.out.println();
            while(rs.next()) {
                System.out.println(rs.getInt("id") +
                        ", " + rs.getString("name") +
                        ", " + rs.getDouble("BaseSalary"));
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
