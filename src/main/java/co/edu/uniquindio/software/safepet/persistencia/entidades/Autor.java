package co.edu.uniquindio.software.safepet.persistencia.entidades;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Autor implements Serializable {
    @Id
    @Column(length = 15)
    private String id;
    @Column(length = 40)
    private String nombre;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return getId().equals(autor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
