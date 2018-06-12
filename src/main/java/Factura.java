
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Column;
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
@Entity (name="e01_factura")
public class Factura implements Serializable {
    
    @Id
    //@Column(name="nro_factura")
    private int nro_factura;
    private GregorianCalendar fecha;
    private double total_sin_iva;
    private double iva;
    private double total_con_iva;
        
    @ManyToOne     
    @JoinColumn(name="nro_cliente")
    private transient Cliente cliente;
    @OneToMany
    @JoinColumn(name="nro_Factura")    
    private List<DetalleFactura> detalleFactura;

    public Factura() {
    }

    public Factura(int nro_factura, GregorianCalendar fecha, double total_sin_iva, double iva, double total_con_iva, Cliente cliente, List<DetalleFactura> detalleFactura) {
        this.nro_factura = nro_factura;
        this.fecha = fecha;
        this.total_sin_iva = total_sin_iva;
        this.iva = iva;
        this.total_con_iva = total_con_iva;
        this.cliente = cliente;
        this.detalleFactura = detalleFactura;
    }
    
    public int getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(int nro_factura) {
        this.nro_factura = nro_factura;
    }


    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public double getTotal_sin_iva() {
        return total_sin_iva;
    }

    public void setTotal_sin_iva(double total_sin_iva) {
        this.total_sin_iva = total_sin_iva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal_con_iva() {
        return total_con_iva;
    }

    public void setTotal_con_iva(double total_con_iva) {
        this.total_con_iva = total_con_iva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "nro_factura=" + nro_factura + ", fecha=" + fecha + ", total_sin_iva=" + total_sin_iva + ", iva=" + iva + ", total_con_iva=" + total_con_iva + '}';
    }
    
    
    
}


