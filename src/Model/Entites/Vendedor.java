package Model.Entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable {


    private Integer IdVendedor;
    private String Nome;
    private String email;
    private Date DtAniversario;
    private Double Salario;

    private Departamento departamento;

    public Vendedor(){

    }

    public Vendedor(Integer idVendedor, String nome, String email, Date dtAniversario, Double salario, Departamento departamento) {
        IdVendedor = idVendedor;
        Nome = nome;
        this.email = email;
        DtAniversario = dtAniversario;
        Salario = salario;
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(IdVendedor, vendedor.IdVendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(IdVendedor);
    }

    public int getIdVendedor() {
        return IdVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        IdVendedor = idVendedor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Date getDtAniversario() {
        return DtAniversario;
    }

    public void setDtAniversario(Date dtAniversario) {
        DtAniversario = dtAniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double salario) {
        Salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "IdVendedor=" + IdVendedor +
                ", Nome='" + Nome + '\'' +
                ", email='" + email + '\'' +
                ", DtAniversario=" + DtAniversario +
                ", Salario=" + Salario +
                ", departamento=" + departamento +
                '}';
    }
}
