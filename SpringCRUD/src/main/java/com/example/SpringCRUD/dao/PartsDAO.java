package com.example.SpringCRUD.dao;

import com.example.SpringCRUD.entity.Parts;

import java.util.List;

public interface PartsDAO {
    public List<Parts> findAll();
    public Parts findById(int id);
    public void save(Parts part);
    public void deleteById(int id);
}
