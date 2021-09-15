package com.example.demo.service;

import com.example.demo.entity.Recorrido;
import com.example.demo.repository.RecorridoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecorridoService {

    @Autowired
    private RecorridoRepository recorridoRepository;

    public RecorridoService(RecorridoRepository recorridoRepository) {
        this.recorridoRepository = recorridoRepository;
    }

    public List<Recorrido> getRecorridos() {
        return recorridoRepository.findAll();
    }

    public List<Recorrido> getRecorridosByAfiliado(Long idAfiliado) {
        return recorridoRepository.getRecorridosByAfiliado(idAfiliado);
    }
}
