package info.codingalecr.clonetube.model;

/**
 * Created by Alejandro on 12/23/2016.
 */
public class Video {

    /**
     * Identificador del video
     */
    private int idVideo;

    /**
     * Nombre del video
     */
    private String nombre;

    /**
     * Descripcion del video
     */
    private String descripcion;

    /**
     * Usuario que sube el video
     */
    private String usuario;

    /**
     * Imagen enlazada de thumbnail
     */
    private String imagen;

    /**
     * Comentarios sobre el video
     */
    private Comentario[] comentarios;
}
