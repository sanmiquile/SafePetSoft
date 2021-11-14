package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class EmpleadoSafePet implements Serializable {
    @Id
    @Column(length = 15)
    private String id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String contrasenia;




    @ManyToOne
    @JoinColumn (name="id_Aseguradora")// Para designar el nombre de la llave foránea
    private Aseguradora aseguradora;


    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getContrasenia() {return contrasenia;}

    public void setContrasenia(String nombre) {this.contrasenia = contrasenia;}




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpleadoSafePet)) return false;
        EmpleadoSafePet empleadoSafePet = (EmpleadoSafePet) o;
        return getId().equals(empleadoSafePet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
