package co.edu.uniquindio.software.safepet.logica;

import co.edu.uniquindio.software.safepet.persistencia.entidades.Plan;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.FetchType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class PlanBO extends GenericBO<Plan,Integer>{
}
