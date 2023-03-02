/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.model;

/**
 *
 * @author Nour Saidi
 */
public class Reaction {

    private int id,id_a,id_u,id_c;


    public Reaction() {
    }

    public Reaction(int id, int id_a, int id_u, int id_c) {
        this.id = id;
        this.id_a = id_a;
        this.id_u = id_u;
        this.id_c = id_c;
    }

    public Reaction(int id_a, int id_u, int id_c) {
        this.id_a = id_a;
        this.id_u = id_u;
        this.id_c = id_c;
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

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    @Override
    public String toString() {
        return "Reaction{" + "id=" + id + ", id_a=" + id_a + ", id_u=" + id_u + ", id_c=" + id_c + '}';
    }
    
    
      
}
