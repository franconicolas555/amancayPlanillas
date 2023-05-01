package com.example.demo.service;

import com.example.demo.dto.FieldDTO;
import com.example.demo.dto.RowDTO;
import com.example.demo.entity.Afiliado;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.PayrollUtils;
import com.example.demo.utils.PdfBoxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PdfService {

    private Logger Log = LoggerFactory.getLogger(AfiliadoService.class);
    @Autowired
    private RecorridoService recorridoService;

    @Autowired
    private AfiliadoService afiliadoService;

    @Autowired
    private FeriadoService feriadoService;


    public PdfService(RecorridoService recorridoService, AfiliadoService afiliadoService, FeriadoService feriadoService) {
        this.recorridoService = recorridoService;
        this.afiliadoService = afiliadoService;
        this.feriadoService = feriadoService;
    }

    private List<FieldDTO> generateFieldsApross(Afiliado afiliado, String month, List<Integer> daysValids) {
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("razon-social", afiliado.getTransportista().getApellido().toUpperCase() + " " + afiliado.getTransportista().getNombre().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("domicilio", afiliado.getDireccion().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nombre-afiliado", afiliado.getApellido() + " " + afiliado.getNombre(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nro_prestador", afiliado.getTransportista().getNroPrestador(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nro_afiliado", afiliado.getNroAfiliado(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("mes", month.toUpperCase() + " " + cal.get(Calendar.YEAR), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("profesional", afiliado.getProfesional(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("domicilio-traslado", afiliado.getDireccionHasta(), false);
        fieldDTOS.add(fieldDTO);
        //fieldDTO = new FieldDTO("firma_transportista", "", true, "C:/pdfbox/firmaclaudiabordolli2.png", 130F, 38F);
        //fieldDTOS.add(fieldDTO);
        daysValids.forEach(dayValid -> {
            FieldDTO fieldDTODay = new FieldDTO(dayValid.toString(), "presencial", false);
            fieldDTOS.add(fieldDTODay);
        });
        return fieldDTOS;
    }


    private List<FieldDTO> generateFieldsGea(Afiliado afiliado, String month, List<RowDTO> rows) {
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("name", afiliado.getApellido().toUpperCase() + " " + afiliado.getNombre().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("direccion_desde", afiliado.getDireccion().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("direccion_hasta", afiliado.getApellido() + " " + afiliado.getNombre(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("month_year", month.toUpperCase() + " " + cal.get(Calendar.YEAR), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("description", "TRANSPORTE A " + afiliado.getProfesional(), false);
        fieldDTOS.add(fieldDTO);
        for (int i = 0; i < rows.size(); i++) {
            FieldDTO fieldDTODay = new FieldDTO(Integer.toString(i + 1), rows.get(i).getFecha(), false);
            fieldDTOS.add(fieldDTODay);
            fieldDTODay = new FieldDTO(i + 1 + "I", rows.get(i).getIngreso(), false);
            fieldDTOS.add(fieldDTODay);
            fieldDTODay = new FieldDTO(i + 1 + "E", rows.get(i).getEgreso(), false);
            fieldDTOS.add(fieldDTODay);

        }
        return fieldDTOS;
    }

    private List<FieldDTO> generateFieldsAmancay(Afiliado afiliado, String month, List<RowDTO> rows) {
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("name", afiliado.getApellido().toUpperCase() + " " + afiliado.getNombre().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("dni", "DNI " + afiliado.getNroDocumento().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("month_year", "PERIODO MES " + month.toUpperCase() + " DE " + cal.get(Calendar.YEAR), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("description", "PRESTACION TRANSPORTE A " + afiliado.getProfesional() + " " + afiliado.getDireccionHasta(), false);
        fieldDTOS.add(fieldDTO);
        for (int i = 0; i < rows.size(); i++) {
            FieldDTO fieldDTODay = new FieldDTO(Integer.toString(i + 1), rows.get(i).getFecha() + " " + DateUtils.getDayOfWeek(rows.get(i).getDay()), false);
            fieldDTOS.add(fieldDTODay);

        }
        return fieldDTOS;
    }

    private List<FieldDTO> generateFieldsOspecor(Afiliado afiliado, String month, List<RowDTO> rows) {
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("name", afiliado.getApellido().toUpperCase() + " " + afiliado.getNombre().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nro_afiliado", afiliado.getNroAfiliado().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("month_year", month.toUpperCase() + " " + cal.get(Calendar.YEAR), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("transportista", afiliado.getTransportista().getNombre().toUpperCase() + " " + afiliado.getTransportista().getApellido().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("direccion_desde", afiliado.getDireccion().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("direccion_hasta", afiliado.getDireccionHasta().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("total", Integer.toString(rows.size()), false);
        fieldDTOS.add(fieldDTO);
        if (afiliado.getProfesional().equalsIgnoreCase("ESCUELA")) {
            fieldDTO = new FieldDTO("E", "X", false);
            fieldDTOS.add(fieldDTO);
        }
        if (afiliado.getProfesional().equalsIgnoreCase("TERAPIA")) {
            fieldDTO = new FieldDTO("T", "X", false);
            fieldDTOS.add(fieldDTO);
        }
        for (int i = 0; i < rows.size(); i++) {
            FieldDTO fieldDTODay = new FieldDTO("FechaRow" + (i + 1), rows.get(i).getFecha(), false);
            fieldDTOS.add(fieldDTODay);
            fieldDTODay = new FieldDTO("Horario de IngresoRow" + (i + 1), rows.get(i).getIngreso(), false);
            fieldDTOS.add(fieldDTODay);
            fieldDTODay = new FieldDTO("Horario de SalidaRow" + (i + 1), rows.get(i).getEgreso(), false);
            fieldDTOS.add(fieldDTODay);

        }
        return fieldDTOS;
    }


    private List<FieldDTO> generateFieldsOstep(Afiliado afiliado, String month, List<RowDTO> rows) {
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("description", "TRANSPORTE A " + afiliado.getProfesional().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("transportista", afiliado.getTransportista().getNombre().toUpperCase() + " " + afiliado.getTransportista().getApellido().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("cuit_transportista", afiliado.getTransportista().getCuit().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("month_year", month.toUpperCase() + " " + cal.get(Calendar.YEAR), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("name", afiliado.getApellido().toUpperCase() + " " + afiliado.getNombre().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nro_documento", afiliado.getNroDocumento().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        for (int i = 0; i < rows.size(); i++) {
            FieldDTO fieldDTODay = new FieldDTO("FECHARow" + (i + 1), rows.get(i).getFecha(), false);
            fieldDTOS.add(fieldDTODay);
            fieldDTODay = new FieldDTO("HORARow" + (i + 1), rows.get(i).getIngreso() + " a " + rows.get(i).getEgreso(), false);
            fieldDTOS.add(fieldDTODay);

        }
        return fieldDTOS;
    }

    private List<FieldDTO> generateFieldsPrevencion(Afiliado afiliado, String month, List<RowDTO> rows) {
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("description", "TRANSPORTE A " + afiliado.getProfesional().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("nro_afiliado", afiliado.getNroAfiliado(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("name", afiliado.getApellido().toUpperCase() + " " + afiliado.getNombre().toUpperCase(), false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("month_year", month.toUpperCase() + " " + cal.get(Calendar.YEAR), false);
        fieldDTOS.add(fieldDTO);
        for (int i = 0; i < rows.size(); i++) {
            FieldDTO fieldDTODay = new FieldDTO("FechaRow" + (i + 1), rows.get(i).getFecha(), false);
            fieldDTOS.add(fieldDTODay);
            fieldDTODay = new FieldDTO("HorarioRow" + (i + 1), rows.get(i).getIngreso() + " a " + rows.get(i).getEgreso(), false);
            fieldDTOS.add(fieldDTODay);

        }
        return fieldDTOS;
    }


    private List<FieldDTO> generateFieldsS21(String publicaciones, String videos, String horas, String revisitas, String cursos, String observaciones, String nombre) {
        Calendar cal = Calendar.getInstance();
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        FieldDTO fieldDTO = new FieldDTO("2-Place_8", publicaciones, false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("2-Video_8", videos, false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("2-Hours_8", horas, false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("2-RV_8", revisitas, false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("2-Studies_8", cursos, false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("RemarksApril_2", observaciones, false);
        fieldDTOS.add(fieldDTO);
        fieldDTO = new FieldDTO("Service Year_2", "2022", false);
        fieldDTOS.add(fieldDTO);
        return fieldDTOS;
    }

    public void generatePayrollAprossAfiliado(Long id, String month) throws Exception {
        try {
            Afiliado afiliado = afiliadoService.getAfiliado(id);
            List<Integer> holidays = feriadoService.getCountHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsApross(afiliado, month, PayrollUtils.getFieldsValidsPayroll(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/planillas/" + afiliado.getApellido().toUpperCase() + " " + afiliado.getNombre().toUpperCase() + " " + month + " " + afiliado.getProfesional() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/apross1.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }


    public void generateS21Hermano(String nombre, String publicaciones, String videos, String horas, String revisitas, String cursos, String observaciones) throws Exception {
        try {
            List<FieldDTO> fieldDTOS = generateFieldsS21(publicaciones, videos, horas, revisitas, cursos, observaciones, nombre);
            String pathInitial = "C:/pdfbox/informesconmarzo/S-21-S - " + nombre.trim() + ".pdf";
            String pathFinal = "C:/pdfbox/informesconabril/S-21-S - " + nombre.trim() + ".pdf";
            PdfBoxUtils.generateFile(pathInitial, fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in generateS21Hermano ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in generateS21Hermano ex {}", ex);
            throw ex;
        }
    }

    public void generateAllPayrollApross(String month) throws Exception {
        afiliadoService.getAfiliados().forEach(afiliado -> {
            try {
                generatePayrollAprossAfiliado(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }

    public void generateAllPayrollGea(String month) throws Exception {
        List<Afiliado> afiliadoList = afiliadoService.findAll();
        afiliadoList.removeIf(afiliado -> !afiliado.getObraSocial().equalsIgnoreCase("GEA"));
        afiliadoList.forEach(afiliado -> {
            try {
                generatePayrollGeaAfiliado(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }

    public void generatePayrollGeaAfiliado(Afiliado afiliado, String month) throws Exception {
        try {
            Afiliado afiliadoGea = afiliadoService.getAfiliado(afiliado.getIdAfiliado());
            List<String> holidays = feriadoService.getHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsGea(afiliadoGea, month, PayrollUtils.getDatesValid(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/afiliados/" + afiliadoGea.getApellido().toUpperCase() + " " + afiliadoGea.getNombre().toUpperCase()
                    + " " + month + " " + afiliadoGea.getDireccionHasta() + " " + afiliadoGea.getProfesional() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/afiliados/gea.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }

    public void generateAllPayrollHielo(String month) throws Exception {
        List<Afiliado> afiliadoList = afiliadoService.findAll();
        afiliadoList.removeIf(afiliado -> !afiliado.getObraSocial().equalsIgnoreCase("HIELO"));
        afiliadoList.forEach(afiliado -> {
            try {
                generatePayrollHieloAfiliado(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }

    public void generatePayrollHieloAfiliado(Afiliado afiliado, String month) throws Exception {
        try {
            Afiliado afiliadoHielo = afiliadoService.getAfiliado(afiliado.getIdAfiliado());
            List<String> holidays = feriadoService.getHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsAmancay(afiliadoHielo, month, PayrollUtils.getDatesValid(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/afiliados/" + afiliadoHielo.getApellido().toUpperCase() + " " + afiliadoHielo.getNombre().toUpperCase()
                    + " " + month + " " + afiliadoHielo.getProfesional() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/afiliados/hielo.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }

    public void generateAllPayrollOspecor(String month) throws Exception {
        List<Afiliado> afiliadoList = afiliadoService.findAll();
        afiliadoList.removeIf(afiliado -> !afiliado.getObraSocial().equalsIgnoreCase("OSPECOR"));
        afiliadoList.forEach(afiliado -> {
            try {
                generatePayrollOspecorAfiliado(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }


    public void generatePayrollOspecorAfiliado(Afiliado afiliado, String month) throws Exception {
        try {
            Afiliado afiliadoHielo = afiliadoService.getAfiliado(afiliado.getIdAfiliado());
            List<String> holidays = feriadoService.getHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsOspecor(afiliadoHielo, month, PayrollUtils.getDatesValid(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/afiliados/" + afiliadoHielo.getApellido().toUpperCase() + " " + afiliadoHielo.getNombre().toUpperCase()
                    + " " + month + " " + afiliadoHielo.getProfesional() + " " + afiliado.getDireccionHasta() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/afiliados/ospecor.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }

    public void generateAllPayrollMosaistas(String month) throws Exception {
        List<Afiliado> afiliadoList = afiliadoService.findAll();
        afiliadoList.removeIf(afiliado -> !afiliado.getObraSocial().equalsIgnoreCase("MOSAISTAS"));
        afiliadoList.forEach(afiliado -> {
            try {
                generatePayrollHieloMosaistas(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }

    public void generatePayrollHieloMosaistas(Afiliado afiliado, String month) throws Exception {
        try {
            Afiliado afiliadoHielo = afiliadoService.getAfiliado(afiliado.getIdAfiliado());
            List<String> holidays = feriadoService.getHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsAmancay(afiliadoHielo, month, PayrollUtils.getDatesValid(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/afiliados/" + afiliadoHielo.getApellido().toUpperCase() + " " + afiliadoHielo.getNombre().toUpperCase()
                    + " " + month + " " + afiliadoHielo.getProfesional() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/afiliados/mosaistas.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }

    public void generateAllPayrollOstep(String month) throws Exception {
        List<Afiliado> afiliadoList = afiliadoService.findAll();
        afiliadoList.removeIf(afiliado -> !afiliado.getObraSocial().equalsIgnoreCase("OSTEP"));
        afiliadoList.forEach(afiliado -> {
            try {
                generatePayrollOstep(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }

    public void generatePayrollOstep(Afiliado afiliado, String month) throws Exception {
        try {
            Afiliado afiliadoHielo = afiliadoService.getAfiliado(afiliado.getIdAfiliado());
            List<String> holidays = feriadoService.getHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsOstep(afiliadoHielo, month, PayrollUtils.getDatesValid(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/afiliados/" + afiliadoHielo.getApellido().toUpperCase() + " " + afiliadoHielo.getNombre().toUpperCase()
                    + " " + month + " " + afiliadoHielo.getProfesional() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/afiliados/ostep.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }


    public void generateAllPayrollOspaca(String month) throws Exception {
        List<Afiliado> afiliadoList = afiliadoService.findAll();
        afiliadoList.removeIf(afiliado -> !afiliado.getObraSocial().equalsIgnoreCase("OSPACA"));
        afiliadoList.forEach(afiliado -> {
            try {
                generatePayrollOspaca(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }

    public void generatePayrollOspaca(Afiliado afiliado, String month) throws Exception {
        try {
            Afiliado afiliadoHielo = afiliadoService.getAfiliado(afiliado.getIdAfiliado());
            List<String> holidays = feriadoService.getHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsAmancay(afiliadoHielo, month, PayrollUtils.getDatesValid(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/afiliados/" + afiliadoHielo.getApellido().toUpperCase() + " " + afiliadoHielo.getNombre().toUpperCase()
                    + " " + month + " " + afiliadoHielo.getProfesional() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/afiliados/ospaca.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }

    public void generateAllPayrollPrevencion(String month) throws Exception {
        List<Afiliado> afiliadoList = afiliadoService.findAll();
        afiliadoList.removeIf(afiliado -> !afiliado.getObraSocial().equalsIgnoreCase("PREVENCION"));
        afiliadoList.forEach(afiliado -> {
            try {
                generatePayrollPrevencion(afiliado, month);
            } catch (Exception e) {
                Log.error("error in generatePayrollAprossAfiliado ex {}  afiliado {}", e, afiliado);
            }
        });
    }

    public void generatePayrollPrevencion(Afiliado afiliado, String month) throws Exception {
        try {
            Afiliado afiliadoHielo = afiliadoService.getAfiliado(afiliado.getIdAfiliado());
            List<String> holidays = feriadoService.getHolidaysMonth(DateUtils.getMonth(month));
            List<FieldDTO> fieldDTOS = generateFieldsPrevencion(afiliadoHielo, month, PayrollUtils.getDatesValid(recorridoService.getRecorridosByAfiliado(afiliado.getIdAfiliado()),
                    month.toUpperCase(), holidays));
            String pathFinal = "C:/pdfbox/afiliados/" + afiliadoHielo.getApellido().toUpperCase() + " " + afiliadoHielo.getNombre().toUpperCase()
                    + " " + month + " " + afiliadoHielo.getProfesional() + ".pdf";
            PdfBoxUtils.generateFile("C:/pdfbox/afiliados/prevencion.pdf", fieldDTOS, pathFinal);
        } catch (IOException io) {
            Log.error("error in getAfiliadosService ex {}", io);
            throw io;
        } catch (Exception ex) {
            Log.error("error in getAfiliadosService ex {}", ex);
            throw ex;
        }
    }
}
