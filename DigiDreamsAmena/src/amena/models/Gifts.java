/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digideramers.amena.models;

/**
 *
 * @author Ahlem
 */
public class Gifts {

   
    private int id,idC;
    private String name, description,value;

    public Gifts(int id, String name, String description, String value,int idC) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.description = description;
        this.idC =idC;
    }

    public Gifts(String name, String description, String value,int idC) {
        this.value = value;
        this.name = name;
        this.description = description;
        this.idC=idC;
    }

    

    public Gifts() {
      
    }

    public int getId() {
        return id;
    }
    public int getIdC() {
        return idC;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    @Override
    public String toString() {
        return "Gifts{" + "id=" + id + ", name=" + name + ", description=" + description + ", value=" + value + ", idC=" + idC + '}';
    }

    

 

}
