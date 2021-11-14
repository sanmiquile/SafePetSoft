package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Afiliado implements Serializable {
    @Id
    @Column(length = 15)
    private String id;
    @Column(length = 40)
    private String nombre;
    @OneToMany(mappedBy = "afiliado")
    private List<Plan> Planes;
    private String telefono;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Plan> getPlanes() {
        return Planes;
    }

    public void setPlanes(List<Plan> planes) {
        Planes = planes;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Afiliado)) return false;
        Afiliado afiliado = (Afiliado) o;
        return getId().equals(afiliado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
