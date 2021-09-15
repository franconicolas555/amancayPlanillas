package com.example.demo.utils;

import com.example.demo.dto.FieldDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfBoxUtils {


    public static void generateFile(String pathInitial, List<FieldDTO> fieldsEditable, String pathFinal) throws IOException {
        try {
            File file = new File(pathInitial);
            PDDocument pDDocument = PDDocument.load(file);
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            for (FieldDTO fieldEditable : fieldsEditable) {
                PDField field = pDAcroForm.getField(fieldEditable.getFieldKey());
                field.setValue(fieldEditable.getFieldValue());
            }
            pDDocument.save(pathFinal);
            pDDocument.close();
        } catch (IOException e) {
            throw e;
        }
    }
}
