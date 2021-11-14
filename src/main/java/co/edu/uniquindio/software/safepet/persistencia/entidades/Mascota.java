package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Mascota implements Serializable {
    @Id
    @Column(length = 15)
    private String id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 15)
    private Integer edad;
    @Column(length = 50)
    private String genero;

    @ManyToOne
    @JoinColumn (name="id_Plan")// Para designar el nombre de la llave foránea
    private  Plan plan;
    @JoinColumn (name="id_TipoMascota")// Para designar el nombre de la llave foránea
    @ManyToOne
    private TipoMascota  tipoMascota;

    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {return nombre;}

    public void setNombre(String id) {
        this.nombre = nombre;
    }

    public Integer getMensualidad() {
        return edad;
    }
    public void setMensualidad(Integer edad){this.edad=edad;}
    public String getGenero() {return genero;}

    public void setGener(String genero) {this.id =genero;}


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
