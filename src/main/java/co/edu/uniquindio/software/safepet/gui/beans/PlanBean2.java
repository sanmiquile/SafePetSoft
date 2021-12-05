package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.MascotaBO;
import co.edu.uniquindio.software.safepet.logica.PlanBO;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Afiliado;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Mascota;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Plan;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Servicio;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named
@ViewScoped
public class PlanBean2 extends PrimeFacesCrudBean<Plan,Integer, PlanBO> {

    @Inject
    private MascotaBO mascotaBO;

    @Inject
    public PlanBean2(PlanBO bo) {
        super(bo);
    }
    private List<Plan>  planes;
    private Mascota mascota;

    private List<Servicio> servicios;

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Plan> getAfiliados() {
        return  planes;
    }

    public void setAfiliados(List<Plan> planes) {
        this.planes = planes;
    }

    @Override
    public void newEntity() {
        super.newEntity();
        servicios = new ArrayList<>();
         planes=new ArrayList<>();
    }

    @Override
    public void setSelectedEntity(Plan selectedEntity) {
        super.setSelectedEntity(selectedEntity);
          planes= new ArrayList<>();
           planes.addAll(selectedEntity.getAfiliado().getPlanes());



        // planes.addAll( selectedEntity.getAfiliado().getPlanes() );
        List<Plan>  misPlanesAfiliado;
        misPlanesAfiliado= new ArrayList<>();
        for (int i=0;i< planes.size();i++) {
            int aux=Integer.parseInt( selectedEntity.getAfiliado().getId());
            if (1 == aux) {
                misPlanesAfiliado.add(planes.get(i));
            }

        }
        misPlanesAfiliado.addAll( selectedEntity.getAfiliado().getPlanes() );
         Afiliado afiliado = selectedEntity.getAfiliado();
    }

    public void save() {
        selectedEntity.getServicios().clear();
        selectedEntity.getServicios().addAll(servicios);
        super.save();
    }





    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}