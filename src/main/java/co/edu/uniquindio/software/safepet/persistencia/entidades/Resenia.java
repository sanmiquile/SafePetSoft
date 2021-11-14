package co.edu.uniquindio.software.safepet.persistencia.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Resenia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private String texto;
    @Column(length = 15)
    private String username;
    @ManyToOne
    private Libro libro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resenia)) return false;
        Resenia resenia = (Resenia) o;
        return getId().equals(resenia.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
