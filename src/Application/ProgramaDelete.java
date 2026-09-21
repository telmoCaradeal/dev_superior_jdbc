package Application;

import db.DB;
import Exception.DbIntegrityException;

import java.sql.*;

public class ProgramaDelete {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            conn = DB.conectar();

            st = conn.prepareStatement("delete from departamento where Id = ?");
            st.setInt(1, 1);

            int resultadoDelete = st.executeUpdate();




        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }

        finally {
            DB.closeResultSet(rs);
            DB.closeStatment(st);
            DB.fecharConexao(conn);
        }
    }
}
