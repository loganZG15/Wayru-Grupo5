package pe.edu.upc.wayrugrupo5.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombreUsuario", length = 50, nullable = false)
    private String nombreUsuario;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String email, String password) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
