

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillermo.islas
 */
@Entity(name="e01_cliente")
public class Cliente{
    @Id
    private int nro_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    @OneToMany
    @JoinColumn(name="nro_cliente")       
    private List<Telefono> telefono = new ArrayList<>();
    @OneToMany
    @JoinColumn(name="nro_cliente")       
    private List<Factura> factura = new ArrayList<>();
    private int activo;

    public Cliente() {
        super();
    }

    public Cliente(int nro_cliente, String nombre, String apellido, String direccion, int activo) {
        this.nro_cliente = nro_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.activo = activo;
    }



    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }

    public List<Telefono> getTelefono() {
        return telefono;
    }

    public void setTelefono(List<Telefono> telefono) {
        this.telefono = telefono;
    }

    public int getNro_cliente() {
        return nro_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getActivo() {
        return activo;
    }

    public void setNro_cliente(int nro_cliente) {
        this.nro_cliente = nro_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nro_cliente=" + nro_cliente + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", activo=" + activo + '}';
    }

    
    
}
