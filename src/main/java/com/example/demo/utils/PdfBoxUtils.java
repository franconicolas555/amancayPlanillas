package com.example.demo.utils;

import com.example.demo.dto.FieldDTO;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
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
                if (fieldEditable.isFirm()) {
                    PDImageXObject pdImage = PDImageXObject.createFromFile(fieldEditable.getPathFirm(), pDDocument);
                    PDRectangle rectangle = getFieldArea(field);
                    float sizex = fieldEditable.getSizex();
                    float sizey = fieldEditable.getSizey();
                    float x = rectangle.getLowerLeftX();
                    float y = rectangle.getLowerLeftY() + 2;
                    try (PDPageContentStream contentStream = new PDPageContentStream(pDDocument,
                            pDDocument.getPage(0), PDPageContentStream.AppendMode.APPEND, true)) {
                        contentStream.drawImage(pdImage, x, y, sizex, sizey);
                    }

                }
            }
            pDDocument.save(pathFinal);
            pDDocument.close();
        } catch (IOException e) {
            throw e;
        }
    }


    private static PDRectangle getFieldArea(PDField field) {
        COSDictionary fieldDict = field.getCOSObject();
        COSArray fieldAreaArray = (COSArray) fieldDict.getDictionaryObject(COSName.RECT);
        return new PDRectangle(fieldAreaArray);
    }
}
