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

    public Canal(String identificador, int idImagen, int seguidores, String usuario) {
        this.identificador = identificador;
        this.idImagen = idImagen;
        this.seguidores = seguidores;
        this.nombre = usuario;
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
}
