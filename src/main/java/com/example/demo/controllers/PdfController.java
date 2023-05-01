package com.example.demo.controllers;

import com.example.demo.dto.ParamDTO;
import com.example.demo.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class PdfController {
    @Autowired
    private PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/payrollApross")
    public ResponseEntity generatePdfPayrollApross(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollApross(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/payrollGea")
    public ResponseEntity generatePdfPayrollGea(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollGea(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/payrollHielo")
    public ResponseEntity generatePdfPayrollHielo(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollHielo(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/payrolOspecor")
    public ResponseEntity generatePdfPayrollOspecor(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollOspecor(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/payrolMosaistas")
    public ResponseEntity generatePdfPayrollMosaistas(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollMosaistas(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/payrolOspaca")
    public ResponseEntity generatePdfPayrollOspaca(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollOspaca(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/payrolPrevencion")
    public ResponseEntity generatePdfPayrollPrevencion(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollPrevencion(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/payrolOstep")
    public ResponseEntity generatePdfPayrollOstep(@RequestBody String month) throws Exception {
        pdfService.generateAllPayrollOstep(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }




    @PostMapping("/payrollAprossByAfiliado")
    public ResponseEntity generatePdfPayrollAprossByAfiliado(@RequestBody ParamDTO paramDTO) throws Exception {
        pdfService.generatePayrollAprossAfiliado(Long.valueOf(paramDTO.getId()), paramDTO.getMonth());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/s21")
    public ResponseEntity generateS21(@RequestBody ParamDTO paramDTO) throws Exception {
        pdfService.generateS21Hermano(paramDTO.getNombre(),paramDTO.getPublicaciones(),paramDTO.getVideos(),paramDTO.getHoras(),paramDTO.getRevisitas(),paramDTO.getEstudios(),paramDTO.getObservaciones());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}


