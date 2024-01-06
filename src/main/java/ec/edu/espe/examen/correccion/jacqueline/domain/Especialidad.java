package ec.edu.espe.examen.correccion.jacqueline.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESPECIALIDAD")
public class Especialidad {
    @Id
    @Column(name = "COD_ESPECIALIDAD", length = 10)
    private String codigo;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    public Especialidad() {
    }

    public Especialidad(String codigo) {
        this.codigo = codigo;
    }

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Especialidad other = (Especialidad) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Especialidad [codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}