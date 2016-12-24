package info.codingalecr.clonetube.model;

import java.util.Date;

/**
 * Created by Alejandro on 12/23/2016.
 */
public class Comentario {
    /**
     * Nombre del usuario
     */
    private String usuarioEmisor;

    /**
     * Fecha de emision
     */
    private Date fecha;

    /**
     * Cuerpo del comentario
     */
    private String cuerpo;

    public Comentario() {
    }

    public Comentario(String cuerpo, Date fecha, String usuarioEmisor) {
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.usuarioEmisor = usuarioEmisor;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(String usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }
}
