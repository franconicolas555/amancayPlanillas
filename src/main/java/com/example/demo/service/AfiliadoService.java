package com.example.demo.service;

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

import java.util.Arrays;
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

    public List<Afiliado> findAll() {
        try {
            return (List<Afiliado>) afiliadoRepository.findAll();
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
            afiliado.setProfesional(afiliadoDTO.getDescription());
            afiliado.setDireccionHasta(afiliadoDTO.getDireccion_hasta());
            afiliado.setDireccion(afiliadoDTO.getDireccion_desde());
            afiliado.setObraSocial(afiliadoDTO.getObra_social());
            afiliado.setTransportista(new Transportista(1L));
            afiliado.setNroDocumento(afiliadoDTO.getNro_documento());
            afiliado.setNroAfiliado(afiliadoDTO.getNro_afiliado());
            Afiliado idAfiliado = afiliadoRepository.save(afiliado);
            Log.info("afiliado cargado correctamente afiliado {}", afiliado.getIdAfiliado());
            Arrays.asList(afiliadoDTO.getHorario().split(",")).stream().forEach(string -> {
                String[] fields = string.split("-");
                Recorrido recorrido = new Recorrido();
                recorrido.setDiaRecorrido(Long.parseLong(fields[0]));
                recorrido.setAfiliado(idAfiliado);
                recorrido.setHoraDesde(fields.length > 1 ? fields[1] : null);
                recorrido.setHoraHasta(fields.length > 2 ? fields[2] : null);
                recorridoRepository.save(recorrido);
                Log.info("recorrido cargado correctamente afiliado {} recorrido {}", afiliado.getIdAfiliado(), recorrido.getDiaRecorrido());
            });
        } catch (Exception ex) {
            Log.error("error insertAfiliado ex {}", ex.getStackTrace());
            throw ex;
        }

    }

}
