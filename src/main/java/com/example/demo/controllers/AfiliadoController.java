package com.example.demo.controllers;

import com.example.demo.dto.AfiliadoDTO;
import com.example.demo.service.AfiliadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/afiliados")
public class AfiliadoController {


    @Autowired
    private AfiliadoService afiliadoService;

    private Logger Log = LoggerFactory.getLogger(AfiliadoController.class);

    public AfiliadoController(AfiliadoService afiliadoService) {
        this.afiliadoService = afiliadoService;
    }

    @PostMapping(path = "/post")
    public ResponseEntity insertAfiliado(@RequestBody AfiliadoDTO afiliado) {
        try {
            afiliadoService.insertAfiliado(afiliado);
            Log.info("afiliado agregado correctamente");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Log.error("error al agregar afiliado {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Long> getAfiliados() {
        try {
            List<Long> afiliadoList = afiliadoService.getAfiliados();
            return afiliadoList;
        } catch (Exception ex) {
            Log.error("error al consultar afiliados {}", ex.getMessage());
            throw ex;
        }
    }
}
