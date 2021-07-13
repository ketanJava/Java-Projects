package com.example.backendspringproject.controller;

import com.example.backendspringproject.dao.Dao;
import com.example.backendspringproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class StudentController {
    private final Dao dao;

    @Autowired
    public StudentController(@Qualifier("daoImpl") Dao dao){
        this.dao = dao;
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return dao.getAll();
    }

    @PostMapping("/add")
    public Student add(@RequestBody Student s){
        s.setId(0);
        dao.update(s);
        return s;
    }

    @PutMapping("/update")
    public Student update(@RequestBody Student s){
        dao.update(s);
        return s;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "Deleted Student with Student ID:" + id;

    }
}
