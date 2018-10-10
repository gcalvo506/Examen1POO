package tabla.periodica;

import java.util.ArrayList;

/**
 *
 * @author geral
 */
public class Datos {
    
    String resenaHistorica;
    boolean isIsotopo;
    Produccion produccion;
    ArrayList<String> listaUsos;

    public Datos() {
    }

    public Datos(String resenaHistorica, boolean isIsotopo, Produccion produccion, ArrayList<String> listaUsos) {
        this.resenaHistorica = resenaHistorica;
        this.isIsotopo = isIsotopo;
        this.produccion = produccion;
        this.listaUsos = listaUsos;
    }
    
    public String getResenaHistorica() {
        return resenaHistorica;
    }

    public void setResenaHistorica(String resenaHistorica) {
        this.resenaHistorica = resenaHistorica;
    }

    public boolean isIsIsotopo() {
        return isIsotopo;
    }

    public void setIsIsotopo(boolean isIsotopo) {
        this.isIsotopo = isIsotopo;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public ArrayList<String> getListaUsos() {
        return listaUsos;
    }

    public void setListaUsos(ArrayList<String> listaUsos) {
        this.listaUsos = listaUsos;
    }


}
