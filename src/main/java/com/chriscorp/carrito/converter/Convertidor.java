package com.chriscorp.carrito.converter;

import com.chriscorp.carrito.entity.Nota;
import com.chriscorp.carrito.model.MNota;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("convertidor")
public class Convertidor {
    public List<MNota> convertirLista(List<Nota> notas){
            List<MNota> mNotas = new ArrayList<>();

        for (Nota nota: notas) {
            mNotas.add(new MNota(nota));
        }
            return mNotas;
    }
}
