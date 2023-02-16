/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.workshop.interfaces;

/**
 *
 * @author hp
 */

import java.util.List;


public interface InterfaceCRUD<T> {
    public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(int id) ;
    public List<T> afficher(); 
    public T getByID(int id); 
    
    
}
