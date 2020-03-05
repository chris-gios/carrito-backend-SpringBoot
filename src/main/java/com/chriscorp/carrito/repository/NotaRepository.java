package com.chriscorp.carrito.repository;

import com.chriscorp.carrito.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("repositorio")
public interface NotaRepository extends JpaRepository<Nota, Serializable> {

    public abstract Nota findByNombre(String nombre); //el "Nombre" hace referencia a el modelo en la columna "nombre"

    public abstract List<Nota> findByTitulo(String titulo);

    public abstract Nota findByNombreAndTitulo(String nombre, String titulo);

    public abstract  Nota findByNombreAndId(String nombre, Long id);

}
