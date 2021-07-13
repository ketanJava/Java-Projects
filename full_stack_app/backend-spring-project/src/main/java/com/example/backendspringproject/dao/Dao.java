package com.example.backendspringproject.dao;

import com.example.backendspringproject.entity.Student;

import java.util.List;

public interface Dao {
     List<Student> getAll();
     Student getById(int id);
     void update(Student s);
     void delete(int id);

}
