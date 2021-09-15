package com.example.demo.dto;

public class FieldDTO {
    private String fieldKey;
    private String fieldValue;

    public FieldDTO(String fieldKey, String fieldValue) {
        this.fieldKey = fieldKey;
        this.fieldValue = fieldValue;
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
}
