package Model.DAO;

import Model.Entites.Departamento;
import Model.Entites.Vendedor;

import java.sql.SQLException;
import java.util.List;

public interface VendedorDao {

    void insert(Vendedor vendedor) throws SQLException;
    void update(Vendedor vendedor);
    void deleteById(Integer id);

    Vendedor findById(Integer id);
    List<Vendedor> findAll();
    List<Vendedor> findByDepartamento(Departamento departamento);
}
