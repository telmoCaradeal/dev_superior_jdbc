package Model.DAO;

import Model.Entites.Vendedor;

import java.util.List;

public interface VendedorDao {

    void insert(Vendedor vendedor);
    void update(Vendedor vendedor);
    void deleteById(Integer id);

    Vendedor findById(Integer id);
    List<Vendedor> findAll();
}
