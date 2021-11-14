package co.edu.uniquindio.software.safepet.logica;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericBO<T,E> implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> type;

    public GenericBO(){
        type = findGenericType(0);
    }

    private Class<T> findGenericType(int index) {
        Class<?> klass = getClass();
        while (klass.getSuperclass() != null && (!(klass.getGenericSuperclass() instanceof ParameterizedType) || !( ((ParameterizedType)klass
                .getGenericSuperclass()).getActualTypeArguments()[index] instanceof Class ) ) ) {
            klass = klass.getSuperclass();
        }
        return (Class<T>) ((ParameterizedType)klass.getGenericSuperclass()).getActualTypeArguments()[index];
    }

    public T create(T entity){
        entityManager.persist(entity);
        return entity;
    }

    public void delete(final T entity){
        entityManager.remove(entityManager.merge(entity));
    }

    public T find(final E id){
        return entityManager.find(type,id);
    }

    public T update(final T entity){
        return entityManager.merge(entity);
    }

    public List<T> findAll(){
        return entityManager.createQuery(listCriteriaQuery()).getResultList();
    }

    protected CriteriaQuery<T> listCriteriaQuery(){
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        return criteriaQuery.select(root);
    }
}
