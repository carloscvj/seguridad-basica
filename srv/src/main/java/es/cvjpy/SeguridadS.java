package es.cvjpy;

import es.cvjpy.cobol.ServidorConfiguracion;
import es.cvjpy.cobol.ServidorConfiguracionDialog;
import es.cvjpy.cobol.servidor.SockCobol;
import es.cvjpy.cobol.servidor.SockJava;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class SeguridadS {

    public SeguridadS() {
    }

    public void inicio(String appBase, String userName) throws Exception {
        ServidorConfiguracion sc = new ServidorConfiguracion(appBase, userName);
        if (sc.getMostrarInicial()) {
            ServidorConfiguracionDialog scd = new ServidorConfiguracionDialog();
            scd.setDatos(sc);
            scd.setVisible(true);
            sc = new ServidorConfiguracion(appBase, userName); //Pa que vuelva a cargar lo modificado en el dialogo.
        }
        sc.grabar();
        SockJava sj = new SockJava(sc);
        SockCobol sp = new SockCobol(sc);
        sp.start();
        sj.start();
    }

    public static void main(String[] args) {
        String appBase = "seguridad";
        String userName = System.getProperty("user.name", "desconocido");
        SeguridadS main = new SeguridadS();
        try {
            main.inicio(appBase, userName);
        } catch (Exception ex) {
            Logger.getLogger(SeguridadS.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }
}
