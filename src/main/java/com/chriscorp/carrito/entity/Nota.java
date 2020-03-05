package com.chriscorp.carrito.entity;

//import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@Data
@Table(name = "NOTA")
@Entity
public class Nota implements Serializable {

    public Nota() {
    }

    @GeneratedValue
    @Id
    @Column(name = "ID_NOTA")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "CONTENIDO")
    private String contenido;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
