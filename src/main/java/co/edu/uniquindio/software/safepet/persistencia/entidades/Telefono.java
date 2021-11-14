package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Telefono implements Serializable {
    @Id
    @Column(length = 15)
    private String isbn;
    @Column(length = 50)
    private String titulo;
    @ManyToMany
    private List<Afiliado> afiliados;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliado> autores) {
        this.afiliados= afiliados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefono)) return false;
        Telefono telefono = (Telefono) o;
        return getIsbn().equals(telefono.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn());
    }
}
