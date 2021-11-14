package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class CentroVeterinario implements Serializable {
    @Id
    @Column(length = 15)
    private String id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String contrasenia;



    @OneToMany (mappedBy = "CentroVeterinario")
    private List<Aseguradora> aseguradoras;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getContrasenia() {return contrasenia;}

    public void setContrasenia(String nombre) {this.contrasenia = contrasenia;}





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CentroVeterinario)) return false;
        CentroVeterinario centroVeterinario = (CentroVeterinario) o;
        return getId().equals(centroVeterinario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
