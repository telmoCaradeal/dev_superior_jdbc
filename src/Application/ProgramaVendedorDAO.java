package Application;

import Model.DAO.DaoFactory;
import Model.DAO.VendedorDao;
import Model.Entites.Departamento;
import Model.Entites.Vendedor;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProgramaVendedorDAO {

    public static void main(String[] args) throws SQLException {

        //Faz a conexão com o banco de dados
        VendedorDao vendedorDao = DaoFactory.createVendedorDao();

        Vendedor vendedor = vendedorDao.findById(1);
        System.out.println("=========== Teste de FindById ===========");
        System.out.println(vendedor);

        System.out.println();
        System.out.println("=========== Teste de FindByIdDepartamento ===========");
        Departamento departamento = new Departamento(4, null);
        List<Vendedor> listaVendedores = vendedorDao.findByDepartamento(departamento);
        for (Vendedor vendedor1 : listaVendedores) {
            System.out.println(vendedor1);
        }

        System.out.println();
        System.out.println("=========== Teste de FindAll ===========");

        List<Vendedor> listarTodosVendedores = vendedorDao.findAll();
        for (Vendedor todosVendedor : listarTodosVendedores) {
            System.out.println(todosVendedor);
        }

        System.out.println();
        System.out.println("=========== Teste de Insert ===========");
        Vendedor vendedorInsert =  new Vendedor(null, "Bernardo",
                "bernardo.oliveira@gmail.com", new Date(), 1500.0, departamento);
        vendedorDao.insert(vendedorInsert);
        System.out.println("Vendedor inserido com sucesso, ID: " +  vendedorInsert.getIdVendedor());

        System.out.println();
        System.out.println("=========== Teste de Update ===========");
        Vendedor vendedorUpdate = vendedorDao.findById(4);
        vendedorUpdate.setNome("Martha Waine");
        vendedorDao.update(vendedorUpdate);
        System.out.println("Vendedor atualizado com sucesso: " +  vendedorUpdate);

        System.out.println();
        System.out.println("=========== Teste de Delete ===========");
        vendedorDao.deleteById(21);
        //System.out.println("Vendedor excluído com sucesso.");

    }
}
