package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class TipoMascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String tipo;


    @OneToMany (mappedBy = "tipoMascota")
    private List<Mascota> Mascotas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Mascota> getMascotas() {
        return Mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        Mascotas = mascotas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoMascota)) return false;
        TipoMascota tipoMascota = (TipoMascota) o;
        return getId().equals(tipoMascota.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
