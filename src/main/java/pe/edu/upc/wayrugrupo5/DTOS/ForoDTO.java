package pe.edu.upc.wayrugrupo5.DTOS;

import java.time.LocalDateTime;

public class ForoDTO {
    private int idForo;
    private String tituloForo;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private int idUsuario;

    public ForoDTO() {
    }

    public ForoDTO(int idForo, String tituloForo, String contenido,
                   LocalDateTime fechaCreacion, int idUsuario) {
        this.idForo = idForo;
        this.tituloForo = tituloForo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public String getTituloForo() {
        return tituloForo;
    }

    public void setTituloForo(String tituloForo) {
        this.tituloForo = tituloForo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
