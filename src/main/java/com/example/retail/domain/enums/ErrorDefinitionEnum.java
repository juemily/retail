package com.example.retail.domain.enums;

public enum ErrorDefinitionEnum {

    GENERIC_ERROR("RETAIL-100000", "ERROR", "Error inesperado ${error:-}"),
    GENERIC_JSON_ERROR("RETAIL-100001", "ERROR", "Error parseando JSON ${error:-}"),
    GENERIC_CREATE_ERROR("RETAIL-100002", "CREATE_ERROR", "Error creando nuevo ${resource:-} ${error:-}"),

    VALIDATION_ERROR("RETAIL-100007", "VALIDATION_ERROR", "Error validando datos de entrada, ${error:-}"),
    VALIDATION_ERROR_AUTO("RETAIL-100007", "VALIDATION_ERROR", "Error validando datos de entrada"),

    AUTHENTICATION_ERROR("RETAIL-100100", "AUTHENTICATION_ERROR", "Error de autenticación. ${error:-}");
    private final String type;

    private final String errorCode;

    private final String defaultMessage;

    ErrorDefinitionEnum(String type, String errorCode, String defaultMessage) {
        this.type = type;
        this.errorCode = errorCode;
        this.defaultMessage = defaultMessage;
    }

    public String getType() {
        return type;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }



}
