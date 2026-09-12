package db;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DB {

    private DB() {
    }


    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                ConfigurationDB.DB_URL,
                ConfigurationDB.DB_USER,
                ConfigurationDB.DB_PASSWORD
        );
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar a conexão com o banco.", e);
            }
        }
    }

    public static void closeStatment(Statement st){
        if(st != null ){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}

