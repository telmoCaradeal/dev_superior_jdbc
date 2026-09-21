package Model.Entites.DAO;

import Model.Entites.Entites.Departamento;
import Model.Entites.Entites.Vendedor;

import java.util.List;

public interface VendedorDAO {

    void insert(Vendedor vendedor);
    void update(Vendedor vendedor);
    void deleteById(Integer id);

    Departamento findById(Integer id);
    List<Vendedor> findAll();
}
