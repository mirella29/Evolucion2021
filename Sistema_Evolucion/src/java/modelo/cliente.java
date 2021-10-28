/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author VB
 */
public class cliente {
    private int id_cliente;
    private String dni_cli;
    private String nombre_cli;
    private String apellido_cli;
    private String direccion_cli;
    private String telefono_cli;

    public cliente(int id_cliente, String dni_cli, String nombre_cli, String apellido_cli, String direccion_cli, String telefono_cli) {
        this.id_cliente = id_cliente;
        this.dni_cli = dni_cli;
        this.nombre_cli = nombre_cli;
        this.apellido_cli = apellido_cli;
        this.direccion_cli = direccion_cli;
        this.telefono_cli = telefono_cli;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni_cli() {
        return dni_cli;
    }

    public void setDni_cli(String dni_cli) {
        this.dni_cli = dni_cli;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getApellido_cli() {
        return apellido_cli;
    }

    public void setApellido_cli(String apellido_cli) {
        this.apellido_cli = apellido_cli;
    }

    public String getDireccion_cli() {
        return direccion_cli;
    }

    public void setDireccion_cli(String direccion_cli) {
        this.direccion_cli = direccion_cli;
    }

    public String getTelefono_cli() {
        return telefono_cli;
    }

    public void setTelefono_cli(String telefono_cli) {
        this.telefono_cli = telefono_cli;
    }
    
    
}
