package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class CentroVeterinario extends Usuario {
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
