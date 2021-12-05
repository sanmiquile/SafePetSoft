package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 15)
    private Integer edad;
    @Column(length = 50)
    private String genero;

    @Column(length = 50)
    private Integer cantidad;
    @ManyToOne
    private  Plan plan;
    @ManyToOne
    private TipoMascota  tipoMascota;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.genero = genero;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mascota)) return false;
        Mascota mascota = (Mascota) o;
        return getId().equals(mascota.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
