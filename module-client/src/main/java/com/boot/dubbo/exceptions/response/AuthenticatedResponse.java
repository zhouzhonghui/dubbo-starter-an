package com.boot.dubbo.exceptions.response;



import com.boot.dubbo.enums.ExceptionType;
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
 * 未认证
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class AuthenticatedResponse extends ErrorResponse {

    public AuthenticatedResponse() {
    }

    public AuthenticatedResponse(Locale locale) {
        MainError mainError = SubErrors.getMainError(SubErrorType.ISV_NOT_AUTHENTICATED, locale);
        SubError subError = SubErrors.getSubError(ExceptionType.ISV.toString()+"user_not_authenticated",
                SubErrorType.ISV_NOT_AUTHENTICATED.value(),
                locale, "NONE");

        ArrayList<SubError> subErrors = new ArrayList<>();
        subErrors.add(subError);
        setMainError(mainError);
        setSubErrors(subErrors);
    }
}
