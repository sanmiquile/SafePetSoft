package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.AseguradoraBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Aseguradora;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AseguradoraBean extends PrimeFacesCrudBean<Aseguradora,String, AseguradoraBO> {
    @Inject
    public AseguradoraBean(AseguradoraBO bo) {
        super(bo);
    }


}
