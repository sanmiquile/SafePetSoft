package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private Integer valor;

    @ManyToMany(mappedBy = "servicios")
    private List<Plan> plan;


    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor){this.valor=valor;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servicio)) return false;
        Servicio servicio = (Servicio) o;
        return getId().equals(servicio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
