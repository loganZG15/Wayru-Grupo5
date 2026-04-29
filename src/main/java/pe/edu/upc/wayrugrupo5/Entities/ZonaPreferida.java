package pe.edu.upc.wayrugrupo5.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "zonaPreferida")
public class ZonaPreferida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZona;

    @Column(name = "nombreDistrito", length = 50, nullable = false)
    private String nombreDistrito;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "distrito")
    private Distrito distrito;

    public ZonaPreferida() {
    }

    public ZonaPreferida(int idZona, String nombreDistrito, Usuario usuario, Distrito distrito) {
        this.idZona = idZona;
        this.nombreDistrito = nombreDistrito;
        this.usuario = usuario;
        this.distrito = distrito;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
