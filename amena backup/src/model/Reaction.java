/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nour Saidi
 */
public class Reaction {

    private int id,id_a;
    private String description;

    public Reaction() {
    }
    

    public Reaction(int id_a, String description) {
        this.id_a = id_a;
        this.description = description;
    }

    public Reaction(int id_a) {
        this.id_a = id_a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
      
}
