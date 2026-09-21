package Application;

import Model.DAO.DaoFactory;
import Model.DAO.VendedorDao;
import Model.Entites.Departamento;
import Model.Entites.Vendedor;

import java.util.List;

public class ProgramaDAO {

    public static void main(String[] args) {

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

    }
}
