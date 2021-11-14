package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.AutorBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Autor;

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
