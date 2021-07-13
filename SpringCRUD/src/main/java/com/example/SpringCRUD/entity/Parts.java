package com.example.SpringCRUD.entity;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "part_name")
    private String part_name;

    @Column(name = "part_type")
    private String part_type;

    public Parts(){

    }
    public Parts(String part_name, String part_type){
        this.part_name = part_name;
        this.part_type = part_type;
    }
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPart_name() {
        return part_name;
    }
    public void setPart_name(String part_name){
        this.part_name = part_name;
    }
    public String getPart_type() {
        return part_type;
    }
    public void setPart_type(String part_type){
        this.part_type = part_type;
    }

    @Override
    public String toString(){
        return "{Part: id= '"+ id + "', part name = '" + part_name + "', part type= '" + part_type + "'}";
    }
}
