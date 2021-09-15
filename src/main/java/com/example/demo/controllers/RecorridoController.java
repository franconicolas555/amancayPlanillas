package com.example.demo.controllers;

import com.example.demo.entity.Recorrido;
import com.example.demo.service.RecorridoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/recorridos")
public class RecorridoController {

    @Autowired
    private RecorridoService recorridoService;
    private Logger Log = LoggerFactory.getLogger(AfiliadoController.class);

    public RecorridoController(RecorridoService recorridoService) {
        this.recorridoService = recorridoService;
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recorrido> getRecorridos() {
        try {
            List<Recorrido> recorridoList = recorridoService.getRecorridos();
            ObjectMapper mapper = new ObjectMapper();
            return recorridoList.stream().map(object -> mapper.convertValue(object, Recorrido.class)).collect(Collectors.toList());
        } catch (Exception ex) {
            Log.error("error al agregar afiliado {}", ex.getMessage());
            throw ex;
        }
    }
}



