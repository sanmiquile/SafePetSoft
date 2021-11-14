package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.PlanBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Plan;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PlanBean extends PrimeFacesCrudBean<Plan,String, PlanBO> {
    @Inject
    public PlanBean(PlanBO bo) {
        super(bo);
    }


}
