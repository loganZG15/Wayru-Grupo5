package pe.edu.upc.wayrugrupo5.DTOS;

import java.time.LocalDate;

public class IncidenciaDTO {

    private int idIncidencia;
    private String descripcion;
    private boolean estado;
    private LocalDate fechaIncidencia;
    private int idUsuario;
    private int idCategoria;
    private int idDistrito;

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaIncidencia() {
        return fechaIncidencia;
    }

    public void setFechaIncidencia(LocalDate fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }
}
