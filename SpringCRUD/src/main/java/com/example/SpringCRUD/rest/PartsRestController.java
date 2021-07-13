package com.example.SpringCRUD.rest;

import com.example.SpringCRUD.entity.Parts;
import com.example.SpringCRUD.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PartsRestController {
    private PartsService partsService;

    @Autowired
    public PartsRestController(PartsService thePartsService){
partsService = thePartsService;
    }

    @GetMapping("/parts")
    public List<Parts> findAll(){
      return partsService.findAll();
    }

    @GetMapping("/parts/{id}")
    public Parts getPart(@PathVariable int id){
Parts part = partsService.findById(id);
if(part == null){
    throw new RuntimeException("Part ID not found: " + id);
}
return part;
    }

    @PostMapping("/parts")
    public Parts addPart(@RequestBody Parts part){
        part.setId(0);
        partsService.save(part);
        return part;
    }

    @PutMapping("/parts")
    public Parts updatePart(@RequestBody Parts part){
        partsService.save(part);
        return part;
    }

    @DeleteMapping("/parts/{id}")
    public String deletePart(@PathVariable int id){
        Parts part = partsService.findById(id);
        if(part == null){
            throw new RuntimeException("Part ID not found: " + id);
        }
        partsService.deleteById(id);
        return "Deleted part with ID: " + id;
    }
}
