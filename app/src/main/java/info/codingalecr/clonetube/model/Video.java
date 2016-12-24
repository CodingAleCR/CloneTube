package info.codingalecr.clonetube.model;

import java.util.Date;

/**
 * Created by Alejandro on 12/23/2016.
 */
public class Video {

    /**
     * Identificador del video
     */
    private String idVideo;

    /**
     * Titulo del video
     */
    private String titulo;

    /**
     * Descripcion del video
     */
    private String descripcion;

    /**
     * Canal que sube el video
     */
    private Canal canal;

    /**
     * Imagen enlazada de thumbnail
     */
    private int imagen;

    /**
     * Categoria del video
     */
    private String categoria;

    /**
     * Tipo de licencia del video
     */
    private String licencia;

    /**
     * Comentarios sobre el video
     */
    private Comentario[] comentarios;

    /**
     * Cantidad de visualizaciones
     */
    private int vistas;

    /**
     * Votos favorables del video
     */
    private int votosFavorables;

    /**
     * Votos desfavorables del video
     */
    private int votosDesfavorables;

    /**
     * Fecha de subida
     */
    private Date fechaSubida;

    public Video() {
        fechaSubida = new Date();
    }

    public Video(Canal canal, String categoria, Comentario[] comentarios, String descripcion, Date fechaSubida, String idVideo, int imagen, String licencia, String titulo, int vistas, int votosDesfavorables, int votosFavorables) {
        this.canal = canal;
        this.categoria = categoria;
        this.comentarios = comentarios;
        this.descripcion = descripcion;
        this.fechaSubida = fechaSubida;
        this.idVideo = idVideo;
        this.imagen = imagen;
        this.licencia = licencia;
        this.titulo = titulo;
        this.vistas = vistas;
        this.votosDesfavorables = votosDesfavorables;
        this.votosFavorables = votosFavorables;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Comentario[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentario[] comentarios) {
        this.comentarios = comentarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public int getVotosDesfavorables() {
        return votosDesfavorables;
    }

    public void setVotosDesfavorables(int votosDesfavorables) {
        this.votosDesfavorables = votosDesfavorables;
    }

    public int getVotosFavorables() {
        return votosFavorables;
    }

    public void setVotosFavorables(int votosFavorables) {
        this.votosFavorables = votosFavorables;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }
}
