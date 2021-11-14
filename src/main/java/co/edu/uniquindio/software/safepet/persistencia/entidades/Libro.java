package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Libro implements Serializable {
    @Id
    @Column(length = 15)
    private String isbn;
    @Column(length = 50)
    private String titulo;
    @ManyToMany
    private List<Autor> autores;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return getIsbn().equals(libro.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn());
    }
}
