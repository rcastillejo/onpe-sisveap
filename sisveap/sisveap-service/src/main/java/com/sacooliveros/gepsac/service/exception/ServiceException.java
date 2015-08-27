/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.service.exception;

import javax.xml.ws.WebFault;

/**
 *
 * @author Ricardo
 */
@WebFault(name = "ServiceException")
public class ServiceException extends RuntimeException {

    private final ServiceFault fault;

    public ServiceException(String message) {
        super(message);
        this.fault = new ServiceFault();
        this.fault.setFaultString(message);
    }

    public ServiceException(String code, String message) {
        super(message);
        this.fault = new ServiceFault();
        this.fault.setFaultString(message);
        this.fault.setFaultCode(code);
    }

    public ServiceException(ServiceFault fault) {
        this.fault = fault;
    }

    public ServiceException(ServiceFault fault, String message) {
        super(message);
        this.fault = fault;
    }

    public ServiceException(ServiceFault fault, String message, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public ServiceException(ServiceFault fault, Throwable cause) {
        super(cause);
        this.fault = fault;
    }

}
