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
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
    * Atributo que almacena el numero de identificacion del Pedido
    */
    private Long id;
    /**
    * Atributo que almacena el codigo del pedido
    */
    public int Codigo;
    /**
    * Atributo que almacena el carne del usuario que ha realizado el pedido
    */
    public int Carne;
    /**
    * Atributo que almacena el nombre del usuario que realiza el pedido
    */
    public String Nombre;
    /**
    * Atributo que almacena el estado del pedido, si ha sido completado o no
    */
    public boolean Complete;

    public Pedido(){}
    /**
    * Constructor de objeto Pedido asignando el valor de Codigo, Carne, Nombre y Complete.
    */
      public Pedido(int Codigo, int Carne, String Nombre, boolean Status){
        this.Codigo = Codigo;
        this.Carne = Carne;
        this.Nombre = Nombre;
        this.Complete = Status;
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
    * Metodo equals que compara los id de el pedido actual y otro
    *@param object objeto tipo Pedido que se quiere comparar
    *@return devuelve verdadero si son iguales los dos objetos, devuelve falso si no son iguales
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
     /**
    * Metodo que devuelve en forma de texto los valores de los atributos del pedido
    *@return devuelve los vlaores de los atributos en forma de texto.
    */
    @Override
    public String toString() {
        return "Red.Pedido[ Codigo=" + Codigo + "Nombre=" + Nombre + "Carne=" + Carne + "Estado=" + Complete + " ]";
    }
    
}
