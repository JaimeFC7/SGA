/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.*;
import model.Usuario;

public class UsuarioJDBC {
    private final String SQL_LOGIN_ALUMNO = 
            "SELECT * FROM sga.alumnos WHERE alumno_user = ? AND alumno_pass = ?";
    private final String SQL_LOGIN_PROFESOR = 
            "SELECT * FROM sga.profesores WHERE profesor_user = ? AND profesor_pass = ?";
    private final String SQL_GET_ALUMNO =
            "SELECT * FROM sga.alumnos WHERE alumno_user = ?";
    private final String SQL_GET_PROFESOR = 
            "SELECT * FROM sga.profesores WHERE profesor_user = ?";
    
    public boolean checkLogin(Usuario user){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try{
            conn = Conexion.getConnection();
            if(conn != null){
                if(user.getTipo().equalsIgnoreCase("profesor")){
                    stmt = conn.prepareStatement(SQL_LOGIN_PROFESOR);
                }else if(user.getTipo().equalsIgnoreCase("alumno")){
                    stmt = conn.prepareStatement(SQL_LOGIN_ALUMNO);
                }else{
                    throw new Exception("El tipo de usuario no existe");
                }
            }
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            
            rs = stmt.executeQuery();
            while(rs.next()){
                flag = true;
            }            
            return flag;
        }catch(SQLException e){
            System.out.println(e.hashCode());
            e.printStackTrace();
            return false;
        }catch(Exception e){
            return false;
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
    
    public Alumno getAlumno(String username, String tipo){
        Alumno alumno = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try{
            conn = Conexion.getConnection();
            if(conn != null){
                if(tipo.equalsIgnoreCase("alumno")){
                    stmt = conn.prepareStatement(SQL_GET_ALUMNO);
                }else{
                    throw new Exception("ERROR: Se intentó coger un usuario Alumno y se encontró " + tipo);
                }
            }
            stmt.setString(1, username);
        
            rs = stmt.executeQuery();
            while(rs.next()){
                alumno = null;
                alumno = new Alumno(rs.getString("nombre"), rs.getString("genero"), 
                rs.getInt("edad"), rs.getInt("id_grupo"), rs.getString("alumno_user"), tipo);
            }             
        }catch(SQLException e){
            System.out.println(e.hashCode());
            e.printStackTrace();
            alumno = null;
        }catch(Exception e){
            alumno = null;
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return alumno;
    }
    
    public Profesor getProfesor(String username, String tipo){
        Profesor profesor = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try{
            conn = Conexion.getConnection();
            if(conn != null){
                if(tipo.equalsIgnoreCase("profesor")){
                    stmt = conn.prepareStatement(SQL_GET_PROFESOR);
                }else{
                    throw new Exception("ERROR: Se intentó coger un usuario Profesor y se encontró " + tipo);
                }
            }
            stmt.setString(1, username);
        
            rs = stmt.executeQuery();
            while(rs.next()){
                profesor = null;
                profesor = new Profesor(rs.getString("nombre"), rs.getString("genero"), 
                rs.getInt("edad"), rs.getString("profesor_user"), tipo);
            }             
        }catch(SQLException e){
            System.out.println(e.hashCode());
            e.printStackTrace();
            profesor = null;
        }catch(Exception e){
            profesor = null;
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return profesor;
    }
    
}
