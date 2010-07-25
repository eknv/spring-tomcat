package com.eknv.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
public class MessageServiceImpl {

    @WebMethod
    public String getMessage() {
        return "Some message from server";
    }
}
