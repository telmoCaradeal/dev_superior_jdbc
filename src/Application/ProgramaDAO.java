package Application;

import Model.DAO.DaoFactory;
import Model.DAO.VendedorDao;
import Model.Entites.Vendedor;
import Model.Impl.VendedorDaoJdbc;
import db.DB;

public class ProgramaDAO {

    public static void main(String[] args) {
        VendedorDao vendedorDao = DaoFactory.createVendedorDao();

        Vendedor vendedor = vendedorDao.findById(4);
        System.out.println(vendedor);
    }
}
