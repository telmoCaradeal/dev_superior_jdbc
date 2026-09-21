package Application;

import db.DB;
import Exception.DbIntegrityException;

import java.sql.*;

public class ProgramaCommit {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;


        try {

            conn = DB.conectar();
            conn.setAutoCommit(false); //Declara como falsa o commit

            st = conn.prepareStatement("UPDATE vendedor SET BaseSalary =  BaseSalary + ?  where DepartmentId = ? ");
            st.setDouble(1, 200.0);
            st.setInt(2, 4);
            int resultado = st.executeUpdate();

            conn.commit(); //Faz a atualização no banco de dados


        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback(); //Desfaz a alteração do banco de dados em caso de erro
                throw  new DbIntegrityException("Feito Rollback: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbIntegrityException("Erro inesperado: " + ex.getMessage());
            }
        }

        finally {

            DB.closeStatment(st);
            DB.fecharConexao(conn);
        }
    }
}
