package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.MascotaBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Mascota;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class MascotaBean extends PrimeFacesCrudBean<Mascota,Integer, MascotaBO> {
    @Inject
    public MascotaBean(MascotaBO bo) {
        super(bo);
    }


}
