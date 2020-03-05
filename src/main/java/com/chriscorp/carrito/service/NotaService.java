package com.chriscorp.carrito.service;

import com.chriscorp.carrito.converter.Convertidor;
import com.chriscorp.carrito.entity.Nota;
import com.chriscorp.carrito.model.MNota;
import com.chriscorp.carrito.repository.NotaRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicio")
public class NotaService {

    @Autowired//inyecta en algun lado
    @Qualifier("repositorio")//le da el nombre al bean (copiado de repository)
    private NotaRepository repository;

    @Autowired
    @Qualifier("convertidor")
    private Convertidor convertidor;

    private static final Log logger = LogFactory.getLog(NotaService.class);

    public boolean crear(Nota nota){
        logger.info("CREANDO NOTA");
        try{
            repository.save(nota);
            logger.info("NOTA CREADA");
            return true;
        }catch (Exception e){
            logger.error("HUBO UN ERROR");
            return false;
        }
    }

    public boolean actualizar(Nota nota){
        logger.info("ACTUALIZANDO NOTA");
        try{
            repository.save(nota);
            logger.info("NOTA ACTUALIZADA");
            return true;
        }catch (Exception e){
            logger.info("HUBO UN ERROR");
            return false;
        }
    }

    public boolean borrar(String nombre, Long id){
        logger.warn("BORRANDO NOTA");
        try{
            Nota nota = repository.findByNombreAndId(nombre, id);
            repository.delete(nota);
            logger.info("NOTA BORRADA");
            return true;
        }catch (Exception e){
            logger.info("HUBO UN ERROR");
            return false;
        }
    }

    public List<MNota> obtener(){
        return convertidor.convertirLista(repository.findAll());
    }

    public MNota obtenerPorNombreTitulo(String nombre, String titulo){
        return new MNota(repository.findByNombreAndTitulo(nombre, titulo));
    }

    public List<MNota> obtenerTitulo(String titulo){
        return convertidor.convertirLista(repository.findByTitulo(titulo));
    }


}
