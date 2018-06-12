
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


@Entity (name="e01_producto")
public class Producto implements Serializable {
    
    @Id
    private int codigo_producto;
    private transient String marca;
    private transient String nombre;
    private transient String descripcion;
    private transient float precio;
    private transient int stock;
    @OneToMany
    @JoinColumn(name="codigo_producto")       
    private List<DetalleFactura> detalleFactura;    

    public Producto() {
    }

    public Producto(int codigo_producto, String marca, String nombre, String descripcion, float precio, int stock, List<DetalleFactura> detalleFactura) {
        this.codigo_producto = codigo_producto;
        this.marca = marca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.detalleFactura = detalleFactura;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo_producto=" + codigo_producto + ", marca=" + marca + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", detalleFactura=" + detalleFactura + '}';
    }


    
    
}
