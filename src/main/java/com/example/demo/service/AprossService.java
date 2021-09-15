package com.example.demo.service;

import com.example.demo.dto.FieldDTO;
import com.example.demo.entity.Afiliado;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.PayrollUtils;
import com.example.demo.utils.PdfBoxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AprossService {

    @Autowired
    private RecorridoService recorridoService;

    @Autowired
    private AfiliadoService afiliadoService;

    @Autowired
    private FeriadoService feriadoService;


    public AprossService(RecorridoService recorridoService, AfiliadoService afiliadoService, FeriadoService feriadoService) {
        this.recorridoService = recorridoService;
        this.afiliadoService = afiliadoService;
        this.feriadoService = feriadoService;
    }

    private List<FieldDTO> generateFieldsApross(Afiliado afiliado,String month, List<Integer> daysValids){
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("razon-social",afiliado.getTransportista().getApellido().toUpperCase() + " " + afiliado.getTransportista().getNombre().toUpperCase());
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("domicilio",afiliado.getDireccion().toUpperCase());
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nombre-afiliado",afiliado.getApellido() + " " + afiliado.getNombre());
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nro_prestador",afiliado.getTransportista().getNroPrestador());
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nro_afiliado",afiliado.getNroAfiliado());
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("mes",month.toUpperCase() + " " + cal.get(Calendar.YEAR));
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("profesional",afiliado.getProfesional());
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("domicilio-traslado",afiliado.getDireccionHasta());
        fieldDTOS.add(fieldDTO);
        daysValids.forEach(dayValid->{
            FieldDTO fieldDTODay = new FieldDTO(dayValid.toString(),"presencial");
            fieldDTOS.add(fieldDTODay);
        });
        return fieldDTOS;
    }

    public void generatePayrollAprossAfiliado(Long id,String month){
        Afiliado afiliado = afiliadoService.getAfiliado(id);
        Integer holidays = feriadoService.getCountHolidaysMonth(DateUtils.getMonth(month));
        List<FieldDTO> fieldDTOS = generateFieldsApross(afiliado,month,PayrollUtils.getFieldsValidsPayroll(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                month.toUpperCase(), holidays));
        String pathFinal = "C:/pdfbox/" + afiliado.getApellido().toUpperCase() + " " + afiliado.getNombre().toUpperCase() + " " + month + " " + afiliado.getProfesional() + ".pdf";
        try {
            PdfBoxUtils.generateFile("C:/pdfbox/apross1.pdf",fieldDTOS,pathFinal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateAllPayrollApross(String month) {
        afiliadoService.getAfiliados().forEach(afiliado -> {
            generatePayrollAprossAfiliado(afiliado,month);
        });
    }
}
