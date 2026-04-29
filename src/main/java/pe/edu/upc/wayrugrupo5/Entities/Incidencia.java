package pe.edu.upc.wayrugrupo5.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "incidencia")
public class Incidencia {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int idIncidencia;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "fechaIncidencia", nullable = false)
    private LocalDate fechaIncidencia;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaIncidencia categoriaIncidencia;

    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito distrito;

    public Incidencia() {
    }

    public Incidencia(int idIncidencia, String descripcion, boolean estado, LocalDate fechaIncidencia, Usuario usuario, CategoriaIncidencia categoriaIncidencia, Distrito distrito) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaIncidencia = fechaIncidencia;
        this.usuario = usuario;
        this.categoriaIncidencia = categoriaIncidencia;
        this.distrito = distrito;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CategoriaIncidencia getCategoriaIncidencia() {
        return categoriaIncidencia;
    }

    public void setCategoriaIncidencia(CategoriaIncidencia categoriaIncidencia) {
        this.categoriaIncidencia = categoriaIncidencia;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
