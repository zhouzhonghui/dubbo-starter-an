package com.boot.dubbo.exceptions.response;

import com.boot.dubbo.exceptions.Oauth2Exception;
import com.boot.dubbo.exceptions.errors.MainError;
import com.boot.dubbo.exceptions.errors.SubError;
import com.boot.dubbo.exceptions.errors.SubErrorType;
import com.boot.dubbo.exceptions.errors.SubErrors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Locale;

/**
 * oauth2验证
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class Oauth2ErrorResponse extends ErrorResponse {
    public Oauth2ErrorResponse() {
    }

    public Oauth2ErrorResponse(Locale locale, Throwable throwable) {
        MainError mainError = SubErrors.getMainError(SubErrorType.ISV_OAUTH2_INVALID, locale);

        Oauth2Exception oauth2Exception = (Oauth2Exception) throwable;
        SubError subError = SubErrors.getSubError(oauth2Exception.getCode(),
                oauth2Exception.getMessage(),
                locale, oauth2Exception.getValues());

        ArrayList<SubError> subErrors = new ArrayList<>();
        subErrors.add(subError);
        setMainError(mainError);
        setSubErrors(subErrors);
    }
}