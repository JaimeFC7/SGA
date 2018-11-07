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
import java.util.ArrayList;

/**
 *
 * @author jaime
 */
public class AsignaturaJDBC {
    private final String SQL_SELECT_ASIGNATURA =
            "SELECT * FROM sga.asignaturas WHERE id_asignatura IN(" +
            "SELECT id_asignatura FROM sga.enseñan WHERE id_grupo = ?)";
    
    public ArrayList<Asignatura> getArrayAsignaturas(int id_grupo){
        ArrayList<Asignatura> arrAsignaturas = null;
        Asignatura as = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            if(conn != null){
                stmt = conn.prepareStatement(SQL_SELECT_ASIGNATURA);
            }
            stmt.setInt(1, id_grupo);
            rs = stmt.executeQuery();
            arrAsignaturas = new ArrayList<Asignatura>();
            while(rs.next()){
                as = null;
                as = new Asignatura(rs.getInt("id_asignatura"), rs.getString("nombre"), rs.getInt("id_profesor"));
                arrAsignaturas.add(as);
            }             
            for(int x=0;x<arrAsignaturas.size();x++) {
                System.out.println(arrAsignaturas.get(x).getNombre());
            }
        }catch(SQLException e){
            System.out.println(e.hashCode());
            e.printStackTrace();
            as = null;
        }catch(Exception e){
            as = null;
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return arrAsignaturas;  
    }
}
