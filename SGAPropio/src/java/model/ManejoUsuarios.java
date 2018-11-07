/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.Conexion;
import model.Usuario;
import model.Alumno;
import model.Profesor;
import model.UsuarioJDBC;

public class ManejoUsuarios {
    public boolean loginUser(String username, String password){
        Usuario userLogin = null;
        if(!tipoUser(username).equalsIgnoreCase("desconocido")){
            userLogin = new Usuario(username, password, tipoUser(username));
            UsuarioJDBC ujdbc = new UsuarioJDBC();
            if(ujdbc.checkLogin(userLogin)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public Grupo returnGrupo(Alumno userobj){
        GrupoJDBC gjdbc = new GrupoJDBC();
        return gjdbc.getGrupo(userobj.getId_grupo());
    }
    
    public ArrayList<Asignatura> returnAsignaturas(int id_grupo){
        AsignaturaJDBC ajdbc = new AsignaturaJDBC();
        return ajdbc.getArrayAsignaturas(id_grupo);
    }
    
    public String tipoUser(String username){
         if(username.startsWith("U",0)){
             return "Alumno";
         }else if(username.startsWith("P", 0)){
             return "Profesor";
         }else{
             return "Desconocido";
         }
    }
    
    public Alumno setAlumno(String username){
        Alumno alumno = null;
        if(!this.tipoUser(username).equalsIgnoreCase("Desconocido")){
            UsuarioJDBC ujdbc = new UsuarioJDBC();
            alumno = ujdbc.getAlumno(username, this.tipoUser(username));
        }
        return alumno;
    }
    
    public Profesor setProfesor(String username){
        Profesor profesor = null;
        if(!this.tipoUser(username).equalsIgnoreCase("Desconocido")){
            UsuarioJDBC ujdbc = new UsuarioJDBC();
            profesor = ujdbc.getProfesor(username, this.tipoUser(username));
        }
        return profesor;
    }
}
