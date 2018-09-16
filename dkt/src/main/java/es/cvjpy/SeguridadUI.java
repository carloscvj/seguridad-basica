/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import es.cvjpy.aplicacion.ConfiguracionDialog;
import es.cvjpy.aplicacion.AplicacionMenuUI;
import es.cvjpy.aplicacion.ConfiguracionCli;
import es.cvjpy.seguridad.SeguridadMenuUI;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class SeguridadUI extends PrincipalSeguroAbs implements PrincipalUIPro {

    @Override
    protected void llamaConfiguracionInicial(ConfiguracionCli confCli) {
        ConfiguracionDialog cf = new ConfiguracionDialog();
        cf.setDatos(confCli);
        cf.setVisible(true);
    }

    @Override
    protected JMenuBar crearBarraMenu() {
        JMenuBar root = new JMenuBar();
        JMenu aplic = AplicacionMenuUI.crearAplicacionJM();
        aplic.add(SeguridadMenuUI.crearSeguridadJM());
        root.add(aplic);
        aplic = AplicacionMenuUI.crearUtilidadesJM();
        root.add(aplic);
        return root;
    }

    @Override
    protected void reiniciaTu() {
        try {
            SeguridadZ.reiniciar();
        } catch (Exception ex) {
            Logger.getLogger(SeguridadUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PrincipalPro getServidor() {
        return SeguridadZ.getSeguridadPro();
    }

}
