package com.example.retail.domain.error.exceptions;



import com.example.retail.domain.enums.ErrorDefinitionEnum;

import java.util.Map;

public class RetailException extends BaseException {
    public RetailException(ErrorDefinitionEnum error, Map<String, String> messageValues, int httpStatus, Throwable cause) {
        super(error, messageValues, httpStatus, cause);
    }

    public RetailException(ErrorDefinitionEnum error, Map<String, String> messageValues, int httpStatus) {
        super(error, messageValues, httpStatus);
    }

    public RetailException(ErrorDefinitionEnum error, String message, int httpStatus) {
        super(error, message, httpStatus);
    }
}
