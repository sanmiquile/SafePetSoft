package co.edu.uniquindio.software.libreria.gui.beans;

import co.edu.uniquindio.software.libreria.logica.GenericBO;
import org.primefaces.PrimeFaces;

public class PrimeFacesCrudBean<E,K,T extends GenericBO<E,K>> extends GenericEntityBean<E,K,T>{

    public PrimeFacesCrudBean(T bo) {
        super(bo);
    }

    @Override
    public void save() {
        super.save();
        PrimeFaces.current().executeScript("PF('manageEntityDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-entities");
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void delete() {
        super.delete();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-entities");
    }
}
