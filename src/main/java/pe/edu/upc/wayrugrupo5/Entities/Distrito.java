package pe.edu.upc.wayrugrupo5.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDistrito;

    @Column(name = "nombreDistrito", length = 50, nullable = false)
    private String nombreDistrito;

    @Column(name = "latitud", nullable = false)
    private double latitud;

    @Column(name = "longitud", nullable = false)
    private double longitud;

    public Distrito() {
    }

    public Distrito(int idDistrito, String nombreDistrito, double latitud, double longitud) {
        this.idDistrito = idDistrito;
        this.nombreDistrito = nombreDistrito;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
