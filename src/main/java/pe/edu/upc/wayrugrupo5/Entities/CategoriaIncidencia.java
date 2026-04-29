package pe.edu.upc.wayrugrupo5.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "categoriaIncidencia")
public class CategoriaIncidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;

    @Column(name = "nombreCategoria", length = 50, nullable = false)
    private String nombreCategoria;

    @Column(name = "subCategoria", length = 50, nullable = false)
    private String subCategoria;

    public CategoriaIncidencia() {
    }

    public CategoriaIncidencia(int idCategoria, String nombreCategoria, String subCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.subCategoria = subCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }
}
