package es.cvjpy;

/**
 * Hello world!
 *
 */
public class SeguridadZ {

    private static SeguridadPro seguridadEjb;

    public static SeguridadPro getSeguridadPro() {
        if (seguridadEjb == null) {
            seguridadEjb = new SeguridadEjb();
        }
        return seguridadEjb;
    }

    public static void reiniciar() throws Exception {
        seguridadEjb = null;
        System.gc();
        String base = "seguridad";
        String userName = System.getProperty("user.name", "desconocido");
        SeguridadZ main = new SeguridadZ();
        main.inicio(base, userName);
        //System.out.println("gc----------------------------------------------------");
        System.gc();
    }
    private final SeguridadUI principalUI;

    private SeguridadZ() {
        this.principalUI = new SeguridadUI();
    }

    private SeguridadUI getPrincipalUI() {
        return principalUI;
    }

    private void inicio(String base, String userName) throws Exception {
        getPrincipalUI().setBase(base);
        getPrincipalUI().setUsuarioRemoto(userName);
        getPrincipalUI().inicio();
    }

    public static void main(String[] args) throws Exception {
        String base = "seguridad";
        String userName = System.getProperty("user.name", "desconocido");
        SeguridadZ main = new SeguridadZ();
        main.inicio(base, userName);
    }


}
