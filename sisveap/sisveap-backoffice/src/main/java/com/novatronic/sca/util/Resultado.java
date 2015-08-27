/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.sca.util;

/**
 *
 * @author Marco
 */
public class Resultado {

    private String json;
    private int codigo;
    private String mensaje;

    public Resultado(String json, int codigo, String mensaje) {
        this.json = json;
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public Resultado(String json, int codigo) {
        this.json = json;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.json != null ? this.json.hashCode() : 0);
        hash = 43 * hash + this.codigo;
        hash = 43 * hash + (this.mensaje != null ? this.mensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resultado other = (Resultado) obj;
        if ((this.json == null) ? (other.json != null) : !this.json.equals(other.json)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if ((this.mensaje == null) ? (other.mensaje != null) : !this.mensaje.equals(other.mensaje)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resultado{" + "json='" + json + "', codigo=" + codigo + ", mensaje=" + mensaje + '}';
    }
    
}
