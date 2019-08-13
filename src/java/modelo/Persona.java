/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DiamondDust
 */
public class Persona {
    

    private String nombre;
    private String apellido;
    private String edad;
    private int id;
    
    public Persona(){
    }
    
    public Persona(String nombre, String apellido, String edad, int id){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
    }
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setEdad(String edad){
        this.edad = edad;
    }

    public String getEdad(){
        return edad;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
