/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.gepsac.controller.exception;

/**
 *
 * @author Ricardo
 */
public class LimiteHoraLaboralException extends
        RuntimeException {

    public LimiteHoraLaboralException() {
    }

    public LimiteHoraLaboralException(String message) {
        super(message);
    }

    public LimiteHoraLaboralException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimiteHoraLaboralException(Throwable cause) {
        super(cause);
    }

}
