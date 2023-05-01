package com.example.demo.dto;

public class FieldDTO {
    private String fieldKey;
    private String fieldValue;
    private boolean firm;
    private String pathFirm;
    private Float sizex;
    private Float sizey;

    public FieldDTO(String fieldKey, String fieldValue, Boolean firm) {
        this.fieldKey = fieldKey;
        this.fieldValue = fieldValue;
        this.firm = firm;
    }

    public FieldDTO(String fieldKey, String fieldValue, Boolean firm, String pathFirm,Float sizex,Float sizey) {
        this.fieldKey = fieldKey;
        this.fieldValue = fieldValue;
        this.firm = firm;
        this.pathFirm = pathFirm;
        this.sizex = sizex;
        this.sizey = sizey;
    }

    public boolean isFirm() {
        return firm;
    }

    public void setFirm(boolean firm) {
        this.firm = firm;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getPathFirm() {
        return pathFirm;
    }

    public void setPathFirm(String pathFirm) {
        this.pathFirm = pathFirm;
    }

    public Float getSizex() {
        return sizex;
    }

    public void setSizex(Float sizex) {
        this.sizex = sizex;
    }

    public Float getSizey() {
        return sizey;
    }

    public void setSizey(Float sizey) {
        this.sizey = sizey;
    }
}
