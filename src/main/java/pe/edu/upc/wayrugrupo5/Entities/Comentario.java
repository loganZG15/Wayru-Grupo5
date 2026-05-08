package pe.edu.upc.wayrugrupo5.Entities;


import jakarta.persistence.*;
import pe.edu.upc.wayrugrupo5.DTOS.IncidenciaDTO;

@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(name = "mensaje", length = 200, nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "idIncidencia")
    private Incidencia incidencia;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(int idComentario, String mensaje, Incidencia incidencia, Usuario usuario) {
        this.idComentario = idComentario;
        this.mensaje = mensaje;
        this.incidencia = incidencia;
        this.usuario = usuario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
