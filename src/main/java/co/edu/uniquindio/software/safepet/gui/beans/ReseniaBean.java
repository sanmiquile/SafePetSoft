package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.ReseniaBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Resenia;

import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ReseniaBean extends PrimeFacesCrudBean<Resenia,Integer, ReseniaBO> {

    @Inject
    @ManagedProperty("#{libroBean}")
    private LibroBean libroBean;

    @Inject
    public ReseniaBean(ReseniaBO bo) {
        super(bo);
    }

    @Override
    public void save() {
        getSelectedEntity().setLibro( libroBean.getSelectedEntity() );
        super.save();
    }
}
