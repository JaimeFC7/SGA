/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jaime
 */
public class Alumno extends Usuario{
    private String nombre;
    private String genero;
    private int edad;
    private int id_grupo;
    private String username;
    private String password;
    private String tipo;
    
    public Alumno(String username, String password, String tipo) {
        super(username, password, tipo);
    }

    public Alumno(String nombre, String genero, int edad, int id_grupo, String username, String tipo) {
        super(username, tipo);
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.id_grupo = id_grupo;
    }
    
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getTipo() {
        return tipo;
    }
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }
    
    public String getNombre(){return this.nombre;}
    public String getGenero(){return this.genero;}
    public int getEdad(){return this.edad;}
    public int getId_grupo(){return this.id_grupo;}

    
    
}
