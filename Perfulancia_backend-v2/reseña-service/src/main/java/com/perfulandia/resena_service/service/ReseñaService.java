package com.perfulandia.resena_service.service;

import com.perfulandia.resena_service.model.Reseña;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReseñaService {

    // TEMPORAL: Lista en memoria
    private final List<Reseña> lista = new ArrayList<>();

    public List<Reseña> obtenerTodas() {
        return lista;
    }

    public Reseña guardar(Reseña reseña) {
        lista.add(reseña);
        return reseña;
    }

    public void eliminar(Long id) {
        lista.removeIf(r -> r.getId().equals(id));
    }

    public Reseña actualizar(Long id, Reseña nuevaReseña) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                lista.set(i, nuevaReseña);
                return nuevaReseña;
            }
        }
        throw new RuntimeException("Reseña no encontrada");
    }
}

