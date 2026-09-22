package Model.DAO;

import Model.Entites.Departamento;
import Model.Entites.Vendedor;

import java.sql.SQLException;
import java.util.List;

public interface VendedorDao {

    void insert(Vendedor vendedor) throws SQLException;
    void update(Vendedor vendedor) throws SQLException;
    void deleteById(Integer id) throws SQLException;

    Vendedor findById(Integer id);
    List<Vendedor> findAll();
    List<Vendedor> findByDepartamento(Departamento departamento);
}
