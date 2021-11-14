package co.edu.uniquindio.software.libreria.gui.beans;

import co.edu.uniquindio.software.libreria.logica.AutorBO;
import co.edu.uniquindio.software.libreria.logica.LibroBO;
import co.edu.uniquindio.software.libreria.persistencia.entidades.Libro;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LibroBean extends PrimeFacesCrudBean<Libro,String, LibroBO>{

    @Inject
    public LibroBean(LibroBO bo) {
        super(bo);
    }
}
