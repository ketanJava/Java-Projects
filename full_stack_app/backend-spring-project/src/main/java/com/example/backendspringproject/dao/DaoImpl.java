package com.example.backendspringproject.dao;

import com.example.backendspringproject.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DaoImpl implements Dao{
    private final EntityManager entityManager;

    @Autowired
    public DaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Student> getAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Student> query = currentSession.createQuery("from Student");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student getById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
       Student s= currentSession.get(Student.class, id);
        return s;
    }

    @Override
    @Transactional
    public void update(Student s) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(s);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Student s = currentSession.get(Student.class, id);
        currentSession.delete(s);

    }

}
