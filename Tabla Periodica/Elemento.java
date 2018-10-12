package tabla.periodica;

/**
 *
 * @author geral
 */
public class Elemento {
   private PropiedadesQuimicas propiedadesQuimicas;
   private Datos datos;
   private Multimedia multimedia;

    public Elemento() {
    }

    public Elemento(PropiedadesQuimicas propiedadesQuimicas, Datos datos, Multimedia multimedia) {
        this.propiedadesQuimicas = propiedadesQuimicas;
        this.datos = datos;
        this.multimedia = multimedia;
    }

    public PropiedadesQuimicas getPropiedadesQuimicas() {
        return propiedadesQuimicas;
    }

    public void setPropiedadesQuimicas(PropiedadesQuimicas propiedadesQuimicas) {
        this.propiedadesQuimicas = propiedadesQuimicas;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }


}
