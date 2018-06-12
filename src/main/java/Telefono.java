
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


@Entity (name="e01_telefono")
public class Telefono implements Serializable {
    static class Numero implements Serializable {
        private int codigoArea;
        private int nroTelefono;
        
        public Numero () {
        }
        
        public Numero (int codigoArea, int nroTelefono) {
            this.codigoArea = codigoArea;
            this.nroTelefono = nroTelefono;
        }

        public int getNroTelefono() {
            return nroTelefono;
        }

        public void setNroTelefono(int nroTelefono) {
            this.nroTelefono = nroTelefono;
        }
        
        public int getCodigoArea() {
            return codigoArea;
        }
        
        public void setCodigoArea(int codigoArea) {
            this.codigoArea = codigoArea;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Numero other = (Numero) obj;
            if (this.codigoArea != other.codigoArea) {
                return false;
            }
            if (this.nroTelefono != other.nroTelefono) {
                return false;
            }
            return true;
        }
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 29 * hash + this.codigoArea;
            hash = 29 * hash + this.nroTelefono;
            return hash;
        }
        @Override
        public String toString() {
                return "Numero{" + "codigoArea=" + codigoArea + ", nroTelefono=" + nroTelefono + '}';
        }        
        
    }
    
    @Id
    private Numero numero;
    private String tipo;
    @ManyToOne     
    @JoinColumn(name="nro_cliente")    
    private Cliente cliente;
    
    public Telefono () {
    }
    
    public Telefono (Numero numero, String tipo, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.cliente = cliente;
    }
    
    public void setNumero (Numero numero) {
        this.numero = numero;
    }
    
    public Numero getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Telefono{" + "numero=" + numero + ", tipo=" + tipo + ", cliente=" + cliente + '}';
    }
    

}
