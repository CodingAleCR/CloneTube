package info.codingalecr.clonetube.model;

/**
 * Created by Alejandro on 12/23/2016.
 */
public class Canal {
    /**
     * Identificador del canal
     */
    private String identificador;

    /**
     * Nombre del actor
     */
    private String actor;

    /**
     * Nombre del canal
     */
    private String nombre;

    /**
     * Seguidores del canal
     */
    private int seguidores;

    /**
     * Ímagen del canal
     */
    private int idImagen;

    public Canal() {
    }

    public Canal(String actor, String identificador, int idImagen, int seguidores, String nombre) {
        this.actor = actor;
        this.identificador = identificador;
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.seguidores = seguidores;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
