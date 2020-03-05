package com.chriscorp.carrito.controller;

import com.chriscorp.carrito.entity.Nota;
import com.chriscorp.carrito.model.MNota;
import com.chriscorp.carrito.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//este controlador va a ser para una api rest
@RequestMapping("/v1")
public class NotaController {

    @Autowired
    @Qualifier("servicio")//para especificar un id de un bean en concreto
    NotaService service;

    @PutMapping("/nota")
    public boolean agregarNota(@RequestBody @Valid Nota nota){//le llega una JSON y con valir se convierte en una clase Nota(confirmar)
        return service.crear(nota);
    }

    @PostMapping("/nota")
    public boolean actualizarNota(@RequestBody @Valid Nota nota){
        return service.actualizar(nota);
    }

    @DeleteMapping("/nota/{id}/{nombre}")
    public boolean borrarNota(
            @PathVariable("id") Long id,
            @PathVariable("nombre") String nombre){
        return service.borrar(nombre, id);
    }

    @GetMapping("/nota")//hace referencia unicamente a la ubicacion
    public List<MNota> obtenerNota(){//obtener es el metodo y nota es solo para que se entienda pero puede ponerle como sea
        return service.obtener();//lo importante es entender que esto se activa con una peticion GET
    }

    @GetMapping("/nota/{titulo}/{nombre}")
    public MNota obtenerPorNombreTitulo(@PathVariable("nombre") String nombre, @PathVariable("titulo") String titulo){
        return service.obtenerPorNombreTitulo(nombre, titulo);
    }

    @GetMapping("/nota/{titulo}")
    public List<MNota> obtenerPorNombreTitulo(@PathVariable("titulo") String titulo){
        return service.obtenerTitulo(titulo);
    }


}
