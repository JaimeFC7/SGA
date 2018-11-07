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
public class Asignatura {
    private int id_asignatura;
    private String nombre;
    private int id_profesor;

    public Asignatura(int id_asignatura, String nombre, int id_profesor) {
        this.id_asignatura = id_asignatura;
        this.nombre = nombre;
        this.id_profesor = id_profesor;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
    
    
}
