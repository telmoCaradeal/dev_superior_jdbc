package Model.DAO;

import Model.Entites.Departamento;

import java.util.List;

public interface DepartamentoDao {

    void insert(Departamento departamento);
    void update(Departamento departamento);
    void deleteById(Integer id);

    Departamento findById(Integer id);
    List<Departamento> findAll();
}
