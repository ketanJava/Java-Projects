package com.example.SpringCRUD.dao;

import com.example.SpringCRUD.entity.Parts;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PartsDAOImpl implements PartsDAO{
    private EntityManager entityManager;

    @Autowired
    public PartsDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

   @Override
    public List<Parts> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Parts> query = currentSession.createQuery("from Parts", Parts.class);
        List<Parts> part = query.getResultList();
        return part;
    }

    @Override
    public Parts findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Parts part = currentSession.get(Parts.class, id);
        return part;
    }

    @Override
    public void save(Parts part) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(part);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Parts> query = currentSession.createQuery("delete from Parts where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();

    }



}
