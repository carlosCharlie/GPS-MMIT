/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author Laura
 */
public class FactoriaGUIImp extends FactoriaGUI {

    @Override
    public IGUI crearGUILogin() {
        return new Login();
    }    
    
    @Override
    public IGUI crearGUIMenuPrincipal() {
        return new MenuPrincipal();
    }
}
