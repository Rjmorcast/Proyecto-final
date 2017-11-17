/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Red;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rodrigo
 */
@Entity
public class PedidoExtendido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     /**
    * numero de identificacion del pedido extendido
    */
    private Long id;
     /**
    * codigo del pedido extendido
    */
    public int Codigo;
     /**
    * cantidad de producto que se comprara en el pedido extendido
    */
    public int Cantidad;
     /**
    * numero del producto que se compra en el pedido extendido
    */
    public int Producto;
    
     public PedidoExtendido(){}
     /**
    * Constructor de clase que se encarga de asignar los valores de Codigo, Cantidad y Producto.
    *@param Codigo codigo del pedido extendido
    *@param Cantidad cantidad de producto que se compra
    *@para Producto numero del producto que se compra
    */
    public PedidoExtendido(int Codigo, int Cantidad, int Producto){
        this.Codigo = Codigo;
        this.Cantidad = Cantidad;
        this.Producto = Producto;
    }

    /**
    * Get id
    *@return devuelve el atributo id
    */
    public Long getId() {
        return id;
    }
    
    /**
    * Set id
    *@param id valor que se le asignara a id
    */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
    * Metodo que obtiene el hashCode
    *@return hash
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
     /**
    * Metodo equals que compara los id de el pedidoextendido actual y otro
    *@param object objeto tipo PedidoExtendido que se quiere comparar
    *@return devuelve verdadero si son iguales los  id dos objetos, devuelve falso si no son iguales
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoExtendido)) {
            return false;
        }
        PedidoExtendido other = (PedidoExtendido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    /**
    * Metodo que devuelve en forma de texto el valor de id
    *@return devuelve el valor de id en forma de texto
    */
    @Override
    public String toString() {
        return "Red.PedidoExtendido[ id=" + id + " ]";
    }
    
}
