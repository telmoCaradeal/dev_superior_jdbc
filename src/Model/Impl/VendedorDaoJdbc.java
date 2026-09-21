package Model.Impl;

import Model.DAO.VendedorDao;
import Model.Entites.Departamento;
import Model.Entites.Vendedor;
import Exception.DbException;
import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VendedorDaoJdbc implements VendedorDao {

    Connection con;

    public VendedorDaoJdbc(Connection connection) {
        this.con = connection;
    }

    @Override
    public void insert(Vendedor vendedor) {

    }

    @Override
    public void update(Vendedor vendedor) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Vendedor findById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT " +
                    "vendedor.*," +
                    "departamento.nome as DepName " +
                    "FROM vendedor INNER JOIN departamento " +
                    "ON vendedor.departamento_id = departamento.id " +
                    "WHERE vendedor.id = ?");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Departamento dep = new Departamento();
                dep.setIdDepartamento(rs.getInt("departamento_id"));
                dep.setName(rs.getString("DepName"));

                Vendedor vendedor = new Vendedor();
                vendedor.setIdVendedor(rs.getInt("id"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setDtAniversario(rs.getDate("dt_Aniversario"));
                vendedor.setSalario(rs.getDouble("salario"));
                vendedor.setDepartamento(dep);

                return vendedor;

            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {

            DB.closeResultSet(rs);
            DB.closeStatment(ps);

        }

    }

    @Override
    public List<Vendedor> findAll() {
        return List.of();
    }
}
