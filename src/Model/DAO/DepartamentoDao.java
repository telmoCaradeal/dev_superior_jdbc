package Model.DAO;

import Model.Entites.Departamento;

import java.sql.SQLException;
import java.util.List;

public interface DepartamentoDao {

    void insert(Departamento departamento) throws SQLException;

    void update(Departamento departamento) throws SQLException;

    void deleteById(Integer id) throws SQLException;

    Departamento findById(Integer id);

    List<Departamento> findAll();
}
