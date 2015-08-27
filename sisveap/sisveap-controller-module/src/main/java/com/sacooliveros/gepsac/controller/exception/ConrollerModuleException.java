/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.exception;

import java.text.MessageFormat;

/**
 *
 * @author Ricardo
 */
public class ConrollerModuleException extends RuntimeException {

    private final String codigo;

    public ConrollerModuleException(String codigo) {
        this.codigo = codigo;
    }

    public ConrollerModuleException(String codigo, String message) {
        super(MessageFormat.format(message, codigo));
        this.codigo = codigo;
    }

    public ConrollerModuleException(String codigo, String message, Throwable cause) {
        super(MessageFormat.format(message, codigo), cause);
        this.codigo = codigo;
    }

    public ConrollerModuleException(String codigo, Throwable cause) {
        super(cause);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
