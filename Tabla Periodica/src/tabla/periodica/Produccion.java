package tabla.periodica;

/**
 *
 * @author geral
 */
public class Produccion {

    private String metodoObtencion;
    private String lugarDeObtencion;
    private String formaPolimorfica;

    public Produccion() {
    }

    public Produccion(String metodoObtencion, String lugarDeObtencion, String formaPolimorfica) {
        this.metodoObtencion = metodoObtencion;
        this.lugarDeObtencion = lugarDeObtencion;
        this.formaPolimorfica = formaPolimorfica;
    }

    public String getMetodoObtencion() {
        return metodoObtencion;
    }

    public void setMetodoObtencion(String metodoObtencion) {
        this.metodoObtencion = metodoObtencion;
    }

    public String getLugarDeObtencion() {
        return lugarDeObtencion;
    }

    public void setLugarDeObtencion(String lugarDeObtencion) {
        this.lugarDeObtencion = lugarDeObtencion;
    }

    public String getFormaPolimorfica() {
        return formaPolimorfica;
    }

    public void setFormaPolimorfica(String formaPolimorfica) {
        this.formaPolimorfica = formaPolimorfica;
    }

}
