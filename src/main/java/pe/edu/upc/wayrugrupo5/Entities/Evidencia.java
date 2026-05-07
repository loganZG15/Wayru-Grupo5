package pe.edu.upc.wayrugrupo5.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Evidencia")
public class Evidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvidencia;

    @Column(name = "enlaceEvidencia", length = 100, nullable = false)
    private String enlaceEvidencia;

    @ManyToOne
    @JoinColumn(name = "idIncidencia")
    private Incidencia incidencia;

    public Evidencia() {
    }

    public Evidencia(int idEvidencia, String enlaceEvidencia, Incidencia incidencia) {
        this.idEvidencia = idEvidencia;
        this.enlaceEvidencia = enlaceEvidencia;
        this.incidencia = incidencia;
    }

    public int getIdEvidencia() {
        return idEvidencia;
    }

    public void setIdEvidencia(int idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public String getEnlaceEvidencia() {
        return enlaceEvidencia;
    }

    public void setEnlaceEvidencia(String enlaceEvidencia) {
        this.enlaceEvidencia = enlaceEvidencia;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }
}
