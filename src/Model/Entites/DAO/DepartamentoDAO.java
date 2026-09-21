package Model.Entites.DAO;

import Model.Entites.Entites.Departamento;

import java.util.List;

public interface DepartamentoDAO {

    void insert(Departamento departamento);
    void update(Departamento departamento);
    void deleteById(Integer id);

    Departamento findById(Integer id);
    List<Departamento> findAll();
}
