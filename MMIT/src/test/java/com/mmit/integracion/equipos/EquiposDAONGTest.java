package com.mmit.integracion.equipos;

import com.mmit.negocio.equipos.EquipoTrans;
import java.util.ArrayList;
import org.junit.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class EquiposDAONGTest {
    
    public EquiposDAONGTest() {
    }

    /**
     * Prueba que el primer equipo de prueba se lea bien
     */
    @Test
    public void testReadAll() {
        try{
            System.out.println("Listar equipos");
            EquiposDAO instance = new EquiposDAOImp();
            ArrayList<EquipoTrans> result = instance.readAll();
            assertNotNull(result);
        }catch(Exception e){
            Assert.fail();
        }
    }
    
    @Test
    public void testReadById(){
        try{
            System.out.println("Listar un equipo");
            EquiposDAO instance = new EquiposDAOImp();
            EquipoTrans result = instance.readById(0);
            assertNotNull(result);
        }catch(Exception e){
            Assert.fail();
        }
    }
    
}
