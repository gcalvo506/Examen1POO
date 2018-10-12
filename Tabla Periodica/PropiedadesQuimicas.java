package tabla.periodica;

/**
 *
 * @author geral
 */
public class PropiedadesQuimicas {

    String nombre;
    String simbolo;
    double numeroMasico;
    int numeroAtomico;
    String familia;
    int grupo;
    int periodo;
    int bloque;
    double puntoFusion;
    double puntoEbullicion;

    public PropiedadesQuimicas() {
    }

    public PropiedadesQuimicas(String nombre, String simbolo, double numeroMasico, int numeroAtomico, String familia, int grupo, int periodo, int bloque, double puntoFusion, double puntoEbullicion) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.numeroMasico = numeroMasico;
        this.numeroAtomico = numeroAtomico;
        this.familia = familia;
        this.grupo = grupo;
        this.periodo = periodo;
        this.bloque = bloque;
        this.puntoFusion = puntoFusion;
        this.puntoEbullicion = puntoEbullicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getNumeroMasico() {
        return numeroMasico;
    }

    public void setNumeroMasico(double numeroMasico) {
        this.numeroMasico = numeroMasico;
    }

    public int getNumeroAtomico() {
        return numeroAtomico;
    }

    public void setNumeroAtomico(int numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public double getPuntoFusion() {
        return puntoFusion;
    }

    public void setPuntoFusion(double puntoFusion) {
        this.puntoFusion = puntoFusion;
    }

    public double getPuntoEbullicion() {
        return puntoEbullicion;
    }

    public void setPuntoEbullicion(double puntoEbullicion) {
        this.puntoEbullicion = puntoEbullicion;
    }



}
