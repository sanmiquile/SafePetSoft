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
    @OneToMany(mappedBy = "afiliados")
    private List<Plan> Planes;
    @ManyToMany(mappedBy = "afiliados")
    private List<Telefono> telefonos;

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

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void seTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
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
