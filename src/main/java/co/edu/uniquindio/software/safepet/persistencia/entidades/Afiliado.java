package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Afiliado extends Usuario {
    @OneToMany(mappedBy = "afiliado")
    private List<Plan> Planes;
    private String telefono;

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

}
