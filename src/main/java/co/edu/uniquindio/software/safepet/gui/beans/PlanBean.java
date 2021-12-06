package co.edu.uniquindio.software.safepet.gui.beans;

import co.edu.uniquindio.software.safepet.logica.MascotaBO;
import co.edu.uniquindio.software.safepet.logica.PlanBO;
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
public class PlanBean extends PrimeFacesCrudBean<Plan,Integer, PlanBO> {
    @Inject
    private MascotaBO mascotaBO;

    @Inject
    public PlanBean(PlanBO bo) {
        super(bo);
    }

    private Mascota mascota;
    private List<Mascota> mascotas;

    public void setMascotas(List<Mascota> mascotas) {
       this.mascotas = mascotas;
    }

    private List<Servicio> servicios;

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }


    @Override
    public void newEntity() {
        super.newEntity();
        servicios = new ArrayList<>();
    }

    @Override
    public void setSelectedEntity(Plan selectedEntity) {
        super.setSelectedEntity(selectedEntity);
        servicios = new ArrayList<>();
        servicios.addAll( selectedEntity.getServicios() );
    }

    public void save(){
        selectedEntity.getServicios().addAll(servicios);
        selectedEntity.getServicios().clear();
       // selectedEntity.getMascotas().clear();
       // selectedEntity.getMascotas().addAll(mascotas);
        super.save();
    }

    public void subjectSelectionChanged(final AjaxBehaviorEvent event)  {
        // double vr = calcularMensualidadPlan();
        //    selectedEntity.setMensualidad(vr);
        //calcularCopago();
        double valor = 0;
        double cont = 0;

        for (Servicio a:servicios) {
            valor += a.getValor();

        }
        for(Mascota a: selectedEntity.getMascotas()){
            if(a.getNombre() != null){
                cont +=1;
            }
        }
        if( cont == 1 ){
            selectedEntity.setMensualidad(valor);
        } else if( cont == 2 ){
            selectedEntity.setMensualidad(valor * 1.25);
        } else {
            if(cont == 3){
                selectedEntity.setMensualidad(valor * 1.35);
            }
        }
        if( servicios.size() <= 2 ){
            selectedEntity.setCopago(10000);
        } else if( servicios.size() <= 6 ){
            selectedEntity.setCopago(5000);
        } else {
            selectedEntity.setCopago(2000);
        }
    }
        public double calcularMensualidadPlan(){
            double valor = 0.0d;
            int cont = 0;
            Mascota mascota;
            for (Servicio a:servicios) {
                valor += a.getValor();
            }
           for(Mascota a: selectedEntity.getMascotas()){
               if(a.getNombre() != null){
                   cont +=1;
               }
           }
            if( cont <= 1 ){
                selectedEntity.setMensualidad(valor);
            } else if( cont == 2 ){
                selectedEntity.setMensualidad(valor * 1.25);
            } else {
                if(cont == 3){
                    selectedEntity.setMensualidad(valor * 1.35);
                }
            }
            return valor;
        }
    public void crearMascota(){
        mascota.setPlan(selectedEntity);
        selectedEntity.getMascotas().add(
                mascotaBO.create(mascota)
        );
    }
    public void eliminarMascota() {
        mascotaBO.delete(mascota);
//        mostrarMensajeGeneral(getMessage(MessageConstants.OPERACION_FINALIZADA));
        selectedEntity.getMascotas().remove(mascota);
    }

    public void newMascota(){
        mascota = new Mascota();
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
