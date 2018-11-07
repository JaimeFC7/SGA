/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jaime
 */
public class GrupoJDBC {
    private final String SQL_SELECT_CLASES = 
            "SELECT * FROM sga.grupos WHERE id_grupo = ?";
    
    public Grupo getGrupo(int id_grupo){
        Grupo gr = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            if(conn != null){
                stmt = conn.prepareStatement(SQL_SELECT_CLASES);
            }
            stmt.setInt(1, id_grupo);
        
            rs = stmt.executeQuery();
            while(rs.next()){
                gr = null;
                gr = new Grupo(rs.getInt("id_grupo"), rs.getString("grupo"));
            }             
        }catch(SQLException e){
            System.out.println(e.hashCode());
            e.printStackTrace();
            gr = null;
        }catch(Exception e){
            gr = null;
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return gr;
    }
}
