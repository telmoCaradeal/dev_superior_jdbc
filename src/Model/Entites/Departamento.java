package Model.Entites;

import java.io.Serializable;
import java.util.Objects;

public class Departamento implements Serializable {




    private Integer idDepartamento;
    private String name;

    public Departamento() {
    }

    public Departamento(Integer idDepartamento, String name) {
        this.idDepartamento = idDepartamento;
        this.name = name;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(idDepartamento, that.idDepartamento) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartamento, name);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", name='" + name + '\'' +
                '}';
    }


}
