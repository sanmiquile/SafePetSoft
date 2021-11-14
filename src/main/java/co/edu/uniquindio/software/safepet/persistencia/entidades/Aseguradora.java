package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Aseguradora implements Serializable {
    @Id
    @Column(length = 15)
    private String id;

    @ManyToOne
    @JoinColumn (name="id_Plan")// Para designar el nombre de la llave foránea
    private  Plan plan;
    @JoinColumn (name="id_CentroVeterinario")// Para designar el nombre de la llave foránea


    @OneToMany (mappedBy = "aseguradora")
    private List<EmpleadoSafePet> empleadoSafePetList;

    @OneToMany (mappedBy = "Aseguradora")
    private List<CentroVeterinario> centroVeterinarios;

    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aseguradora)) return false;
        Aseguradora aseguradora = (Aseguradora) o;
        return getId().equals(aseguradora.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
