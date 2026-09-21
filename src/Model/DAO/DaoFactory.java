package Model.DAO;

import Model.Impl.VendedorDaoJdbc;
import db.DB;

import java.sql.SQLException;

public class DaoFactory {

    public static VendedorDao createVendedorDao() {
        try {
            return new VendedorDaoJdbc(DB.conectar());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
