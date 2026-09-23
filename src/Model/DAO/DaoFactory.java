package Model.DAO;

import Model.Impl.DepartamentoDaoJdbc;
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

    public static DepartamentoDao createDepartamentoDao() {
        try {
            return new DepartamentoDaoJdbc(DB.conectar());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
