package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.AfiliadoBO;
import co.edu.uniquindio.software.safepet.logica.PlanBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Afiliado;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Mascota;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Plan;
import lombok.Value;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class AfiliadoBean extends PrimeFacesCrudBean<Afiliado,String, AfiliadoBO> {

    @Inject
    public AfiliadoBean(AfiliadoBO bo) {
        super(bo);
    }

    private List<Plan> planes;

    public List<Plan> getPlanes() {
        return planes;
    }







}




