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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    "WHERE departamento.id = ?");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Departamento dep = instanciaDepartamento(rs);

                Vendedor vendedorID = instanciaVendedor(rs, dep);

                return vendedorID;

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

    private Vendedor instanciaVendedor(ResultSet rs, Departamento dep) throws SQLException {

        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(rs.getInt("id"));
        vendedor.setNome(rs.getString("nome"));
        vendedor.setEmail(rs.getString("email"));
        vendedor.setDtAniversario(rs.getDate("dt_Aniversario"));
        vendedor.setSalario(rs.getDouble("salario"));
        vendedor.setDepartamento(dep);

        return vendedor;

    }

    private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {
        Departamento dep = new Departamento();
        dep.setIdDepartamento(rs.getInt("departamento_id"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Vendedor> findAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT " +
                    "vendedor.*," +
                    "departamento.nome as DepName " +
                    "FROM vendedor INNER JOIN departamento " +
                    "ON vendedor.departamento_id = departamento.id " +
                    "ORDER BY nome"
            );

            rs = ps.executeQuery();

            List<Vendedor> listarTodosVendedores = new ArrayList<>();
            Map<Integer, Departamento> mapDepartamento = new HashMap<>();

            while (rs.next()) {
                Departamento dep = mapDepartamento.get(rs.getInt("departamento_id"));

                if (dep == null) {
                    dep = instanciaDepartamento(rs);
                    mapDepartamento.put(rs.getInt("departamento_id"), dep);
                }

                Vendedor vendedor = instanciaVendedor(rs, dep);
                listarTodosVendedores.add(vendedor);
            }

            return listarTodosVendedores;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {

            DB.closeResultSet(rs);
            DB.closeStatment(ps);

        }
    }

    @Override
    public List<Vendedor> findByDepartamento(Departamento departamento) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT " +
                    "vendedor.*," +
                    "departamento.nome as DepName " +
                    "FROM vendedor INNER JOIN departamento " +
                    "ON vendedor.departamento_id = departamento.id " +
                    "WHERE departamento.id = ? " +
                    "ORDER BY nome"
            );

            ps.setInt(1, departamento.getIdDepartamento());
            rs = ps.executeQuery();

            List<Vendedor> listaVendedores = new ArrayList<>();
            Map<Integer, Departamento> mapDepartamento = new HashMap<>();

            while (rs.next()) {
                Departamento dep = mapDepartamento.get(rs.getInt("departamento_id"));

                if (dep == null) {
                    dep = instanciaDepartamento(rs);
                    mapDepartamento.put(rs.getInt("departamento_id"), dep);
                }

                Vendedor vendedor = instanciaVendedor(rs, dep);
                listaVendedores.add(vendedor);
            }

            return listaVendedores;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {

            DB.closeResultSet(rs);
            DB.closeStatment(ps);

        }

    }
}
