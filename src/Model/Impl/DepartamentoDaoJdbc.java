package Model.Impl;

import Exception.DbException;
import Model.DAO.DepartamentoDao;
import Model.DAO.VendedorDao;
import Model.Entites.Departamento;
import Model.Entites.Vendedor;
import db.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class DepartamentoDaoJdbc implements DepartamentoDao {

    Connection con;

    public DepartamentoDaoJdbc(Connection connection) {

        this.con = connection;
    }


    @Override
    public void insert(Departamento departamento) throws SQLException {
        PreparedStatement ps = null;
        con.setAutoCommit(false);

        try {

            ps = con.prepareStatement(
                    "INSERT INTO departamento"
                            + "(nome)"
                            + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, departamento.getName());


            int linhasInseridas = ps.executeUpdate();

            if (linhasInseridas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        con.commit();
                        departamento.setIdDepartamento(id);
                    } else {
                        con.rollback();
                        throw new DbException("Erro ao obter o ID do departamento inserido");
                    }
                }
            } else {
                con.rollback();
                throw new DbException("Erro ao inserir departamento");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }

        finally {
            DB.closeStatment(ps);
        }


    }

    @Override
    public void update(Departamento departamento) throws SQLException {

        PreparedStatement ps = null;
        con.setAutoCommit(false);

        try {
            ps = con.prepareStatement("UPDATE departamento SET nome = ? WHERE id = ?");
            ps.setString(1, departamento.getName());
            ps.setInt(2, departamento.getIdDepartamento());
            int linhasAtualizadas = ps.executeUpdate();
            con.commit();

        }catch (SQLException e){
            try {
                con.rollback();
            }catch (SQLException ex){
                throw new DbException(ex.getMessage());
            }
        }
        finally {
            DB.closeStatment(ps);
        }

    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        PreparedStatement ps = null;
        con.setAutoCommit(false);

        try{
            ps = con.prepareStatement("Delete from departamento where id = ?");
            ps.setInt(1, id);

            int deleteDepartamento = ps.executeUpdate();

            if (deleteDepartamento == 0) {
                System.out.println("Erro ao deletar Departamento, Id inexistente");
            }else {
                con.commit();
                System.out.println("Departamento excluído com sucesso.");
            }

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao deletar o departamento" + ex.getMessage());
            }
        }

    }

    @Override
    public Departamento findById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT id, nome from departamento where id = ?");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Departamento departamento = instanciaDepartamento(rs);

               return departamento;

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
    public List<Departamento> findAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT id, nome from departamento order by id");
            rs = ps.executeQuery();

            List<Departamento> listaDepartamentos = new ArrayList<>();

            while (rs.next()) {
                Departamento  departamento = new Departamento();
                departamento.setIdDepartamento(rs.getInt("id"));
                departamento.setName(rs.getString("nome"));
                listaDepartamentos.add(departamento); //Adiciona o conteudo da base na lista para ser consumida pelo serviço
            }

            return listaDepartamentos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatment(ps);
        }

    }

    private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {

        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(rs.getInt("id"));
        departamento.setName(rs.getString("nome"));

        return departamento;

    }
}
