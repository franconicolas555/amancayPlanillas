package com.example.demo.controllers;

import com.example.demo.service.AprossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api")
public class PdfController {
    @Autowired
    private AprossService pdfService;

    public PdfController(AprossService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/payrollApross")
    public ResponseEntity generatePdfPayrollApross(@RequestBody String month) throws IOException {
        pdfService.generateAllPayrollApross(month);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}


