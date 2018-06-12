
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillermo.islas
 */
@Entity (name="e01_detalle_factura")
public class DetalleFactura implements Serializable {

    static class Detalle implements Serializable {
        private int nro_factura;
        private int codigo_producto;

        public Detalle() {
        }

        public Detalle(int nro_factura, int codigo_producto) {
            this.nro_factura = nro_factura;
            this.codigo_producto = codigo_producto;
        }

        
        public int getNro_factura() {
            return nro_factura;
        }

        public void setNro_factura(int nro_factura) {
            this.nro_factura = nro_factura;
        }

        public int getCodigo_producto() {
            return codigo_producto;
        }

        public void setCodigo_producto(int codigo_producto) {
            this.codigo_producto = codigo_producto;
        }

        @Override
        public String toString() {
            return "Detalle{" + "nro_factura=" + nro_factura + ", codigo_producto=" + codigo_producto + '}';
        }
        
        
    }

    @Id
    private Detalle detalle;
    private transient int nro_item;
    private transient int cantidad;
    @ManyToOne     
    @JoinColumn(name="nro_factura")    
    private Factura factura;
    @ManyToOne     
    @JoinColumn(name="codigo_producto")        
    private Producto producto;
    
    public DetalleFactura() {
    }

    public DetalleFactura(Detalle detalle, int nro_item, int cantidad, Factura factura, Producto producto) {
        this.detalle = detalle;
        this.nro_item = nro_item;
        this.cantidad = cantidad;
        this.factura = factura;
        this.producto = producto;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public int getNro_item() {
        return nro_item;
    }

    public void setNro_item(int nro_item) {
        this.nro_item = nro_item;
    }



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "detalle=" + detalle + ", nro_item=" + nro_item + ", cantidad=" + cantidad + '}';
    }



    
}
