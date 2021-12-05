package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.AfiliadoBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Afiliado;
import lombok.Value;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AfiliadoBean extends PrimeFacesCrudBean<Afiliado,String, AfiliadoBO> {


    @Value("#{seguridadBean.usuario}")
    private Afiliado afiliado;
    @Inject
    public AfiliadoBean(AfiliadoBO bo) {
        super(bo);
    }


}
