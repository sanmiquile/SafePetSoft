package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Plan implements Serializable {
    @Id
    @Column(length = 15)
    private String id;
    @Column(length = 50)
    private Integer mensualidad;
    @Column(length = 50)
    private Integer copago;
    @ManyToOne
    @JoinColumn (name="id_Afiliado")// Para designar el nombre de la llave foránea
    private Afiliado afiliado;
    @OneToMany (mappedBy = "plan")
    private List<Servicio> Servicios;
    @OneToMany (mappedBy = "plan")
    private List<Mascota> mascotas;

    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMensualidad() {
        return mensualidad;
    }
    public void setMensualidad(Integer mensualidad){this.mensualidad=mensualidad;}
    public Integer getCopago() {
        return copago;
    }
    public void setCopago(Integer copago){this.copago=copago;}

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public List<Servicio> getServicios() {
        return Servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        Servicios = servicios;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plan)) return false;
        Plan plan = (Plan) o;
        return getId().equals(plan.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
