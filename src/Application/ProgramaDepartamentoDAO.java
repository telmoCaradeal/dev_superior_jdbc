package Application;

import Model.DAO.DaoFactory;
import Model.DAO.DepartamentoDao;
import Model.DAO.VendedorDao;
import Model.Entites.Departamento;
import Model.Entites.Vendedor;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProgramaDepartamentoDAO {

    public static void main(String[] args) throws SQLException {

        //Faz a conexão com o banco de dados
        DepartamentoDao departamentoDao = DaoFactory.createDepartamentoDao();

        Departamento departamento = departamentoDao.findById(1);
        System.out.println("=========== Teste de FindById ===========");
        System.out.println(departamento);

        System.out.println();
        System.out.println("=========== Teste de FindAll ===========");
        List<Departamento> list = departamentoDao.findAll();
        for (Departamento d : list) {
            System.out.println(d);
        }

        System.out.println();
        System.out.println("=========== Teste de Insert ===========");
        Departamento insertDepartamento = new Departamento(null,"Negocios");
        departamentoDao.insert(insertDepartamento);
        System.out.println("Departamento inserido: " + insertDepartamento.getIdDepartamento());

        System.out.println();
        System.out.println("=========== Resultado Pós Insert ===========");
        List<Departamento> listaPosIsert = departamentoDao.findAll();
        for (Departamento d : listaPosIsert) {
            System.out.println(d);
        }

        System.out.println();
        System.out.println("=========== Teste de Update ===========");
        Departamento updateDepartamento = new Departamento(2,"Eletronicos");
        departamentoDao.update(updateDepartamento);
        System.out.println("Departamento atualizado: " + updateDepartamento.getIdDepartamento() + "," + updateDepartamento.getName());

        System.out.println();
        System.out.println("=========== Resultado Pós Update ===========");
        List<Departamento> listaPosUpdate = departamentoDao.findAll();
        for (Departamento d : listaPosUpdate) {
            System.out.println(d);
        }


        System.out.println();
        System.out.println("=========== Teste de Delete ===========");
        departamentoDao.deleteById(7);

        System.out.println();
        System.out.println("=========== Resultado Pós Delete ===========");
        List<Departamento> listaPosDelete = departamentoDao.findAll();
        for (Departamento d : listaPosDelete) {
            System.out.println(d);
        }

    }
}
