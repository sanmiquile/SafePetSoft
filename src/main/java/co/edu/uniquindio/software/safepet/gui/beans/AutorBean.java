package co.edu.uniquindio.software.libreria.gui.beans;

import co.edu.uniquindio.software.libreria.logica.AutorBO;
import co.edu.uniquindio.software.libreria.persistencia.entidades.Autor;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AutorBean extends PrimeFacesCrudBean<Autor,String, AutorBO> {
    @Inject
    public AutorBean(AutorBO bo) {
        super(bo);
    }


}
