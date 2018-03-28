package com.mmit.integracion.equipos;

import com.mmit.integracion.conexion.Conexion;
import com.mmit.negocio.equipos.EquipoTrans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EquiposDAOImp implements EquiposDAO{

       public ArrayList<EquipoTrans> readAll() {
       
        try {
            Conexion.getInstancia().abrir();
            Connection c = Conexion.getInstancia().getResource();
            
            PreparedStatement ps = c.prepareStatement("SELECT * FROM equipos");
            
            ResultSet rs = ps.executeQuery();
            
            ArrayList<EquipoTrans> equipos = new ArrayList<EquipoTrans>();
            
            while(rs.next()){
                equipos.add(new EquipoTrans(rs.getInt("id"),rs.getString("nombre"),rs.getInt("victorias"),rs.getInt("derrotas"),rs.getInt("entrenador_id")));
            }
            Conexion.getInstancia().cerrar();
            return equipos;

        } catch (SQLException ex) {
            Logger.getLogger(EquiposDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            Conexion.getInstancia().cerrar();
        }
        
        return null;
    }

    @Override
    public EquipoTrans readById(Integer id) {
         try {
            Conexion.getInstancia().abrir();
            Connection c = Conexion.getInstancia().getResource();
            
            PreparedStatement ps = c.prepareStatement("SELECT * FROM equipos WHERE id = " + id);
            
            ResultSet rs = ps.executeQuery();
            
            Conexion.getInstancia().cerrar();
            
            if (rs.next()){
                return new EquipoTrans(rs.getInt("id"),rs.getString("nombre"),rs.getInt("victorias"),rs.getInt("derrotas"),rs.getInt("entrenador_id"));
            }

        } catch (SQLException ex) {
            Conexion.getInstancia().cerrar();
        }
        
        return null;
    }
    
}
