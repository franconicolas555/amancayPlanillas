package com.example.demo.service;

import com.example.demo.controllers.AfiliadoController;
import com.example.demo.dto.AfiliadoDTO;
import com.example.demo.entity.Afiliado;
import com.example.demo.entity.Recorrido;
import com.example.demo.entity.Transportista;
import com.example.demo.repository.AfiliadoRepository;
import com.example.demo.repository.RecorridoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfiliadoService {
    @Autowired
    private AfiliadoRepository afiliadoRepository;
    @Autowired
    private RecorridoRepository recorridoRepository;
    private Logger Log = LoggerFactory.getLogger(AfiliadoService.class);

    public AfiliadoService(AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    public List<Long> getAfiliados() {
        try {
            return afiliadoRepository.getAfiliados();
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }

    public Afiliado getAfiliado(Long id) {
        try {
            return afiliadoRepository.findById(id).get();
        } catch (Exception ex) {
            Log.error("error in getAfiliadoService ex {}", ex);
            throw ex;
        }

    }

    public void insertAfiliado(AfiliadoDTO afiliadoDTO) {
        try {
            Afiliado afiliado = new Afiliado();
            afiliado.setApellido(afiliadoDTO.getApellido());
            afiliado.setNombre(afiliadoDTO.getNombre());
            afiliado.setDireccion(afiliadoDTO.getDireccion());
            afiliado.setEstado(afiliadoDTO.getEstado());
            afiliado.setNroAfiliado(afiliadoDTO.getNroAfiliado());
            afiliado.setTransportista(new Transportista(Long.parseLong(afiliadoDTO.getTransportista())));
            afiliado.setDireccionHasta(afiliadoDTO.getDireccionhasta());
            afiliado.setProfesional(afiliadoDTO.getProfesional());
            Afiliado idAfiliado = afiliadoRepository.save(afiliado);
            Log.info("afiliado cargado correctamente afiliado {}", afiliado.getIdAfiliado());
            afiliadoDTO.getParseRecorridos(afiliadoDTO.getRecorridos()).stream().forEach(diaRecorrido -> {
                Recorrido recorrido = new Recorrido();
                recorrido.setDiaRecorrido(diaRecorrido);
                recorrido.setAfiliado(idAfiliado);
                recorridoRepository.save(recorrido);
                Log.info("recorrido cargado correctamente afiliado {} recorrido {}", afiliado.getIdAfiliado(), recorrido.getDiaRecorrido());
            });
        } catch (Exception ex) {
            Log.error("error insertAfiliado ex {}", ex.getStackTrace());
            throw ex;
        }

    }

}
