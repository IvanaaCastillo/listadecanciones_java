package com.ivana.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artistas")
public class Artista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "El nombre debe tener al menos 2 caracteres.")
    private String nombre;

    @Size(min = 2, message = "El apellido debe tener al menos 2 caracteres.")
    private String apellido;

    @Size(min = 10, message = "La biografia debe tener al menos 10 caracteres.")
    private String biografia;

    @CreationTimestamp
    @Column(updatable = false)
    private Date fechaCreacion;

    @UpdateTimestamp
    private Date fechaActualizacion;

    @OneToMany(mappedBy = "artista")
    private List<Cancion> canciones;

    //CONSTRUCTOR VACIO
    public Artista() {
    }

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Artista [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", biografia=" + biografia
                + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
    }

    

}
