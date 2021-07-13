package com.example.SpringCRUD.service;

import com.example.SpringCRUD.dao.PartsDAO;
import com.example.SpringCRUD.entity.Parts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService{
    private PartsDAO partsDAO;

    @Autowired
    public PartsServiceImpl(PartsDAO thePartsDAO){
        partsDAO = thePartsDAO;
    }

    @Override
    @Transactional
    public List<Parts> findAll() {
        return partsDAO.findAll();
    }

    @Override
    @Transactional
    public Parts findById(int id) {
        return partsDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Parts part) {
    partsDAO.save(part);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
    partsDAO.deleteById(id);
    }
}
