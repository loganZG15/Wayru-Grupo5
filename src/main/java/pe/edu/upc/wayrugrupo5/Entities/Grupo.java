package pe.edu.upc.wayrugrupo5.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGrupo;

    @Column(name = "nombreGrupo", length = 50, nullable = false)
    private String nombreGrupo;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;

    @Column(name = "tipoGrupo", length = 250, nullable = false)
    private String tipoGrupo;

    @ManyToMany
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Grupo() {
    }

    public Grupo(int idGrupo, String nombreGrupo, String descripcion, String tipoGrupo, Usuario usuario) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.descripcion = descripcion;
        this.tipoGrupo = tipoGrupo;
        this.usuario = usuario;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
