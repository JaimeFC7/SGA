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
public class Grupo {
    private int id_grupo;
    private String grupo;

    public Grupo(int id_grupo, String grupo) {
        this.id_grupo = id_grupo;
        this.grupo = grupo;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
}
