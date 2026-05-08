package pe.edu.upc.wayrugrupo5.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForo;

    @Column(name = "tituloForo", length = 100, nullable = false)
    private String tituloForo;

    @Column(name = "contenido", length = 500, nullable = false)
    private String contenido;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Foro() {
    }

    public Foro(int idForo, String tituloForo, String contenido, LocalDateTime fechaCreacion, Usuario usuario) {
        this.idForo = idForo;
        this.tituloForo = tituloForo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
