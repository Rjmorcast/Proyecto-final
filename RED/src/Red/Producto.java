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
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
    * Atributo que almacena el numero de identificacion del producto
    */
    public Long id;
    /**
    * Atributo que almacena el codigo del producto
    */
    public int Codigo;
    /**
    * Atributo que almacena el nombre del producto
    */
    public String Nombre;
    /**
    * Atributo que almacena el precio del producto
    */
    public double Precio;
    
    /**
    * Constructor de clase que asigna los valores de los atributos
    *@param Codigo codigo del producto
    *@param Nombre nombre del producto
    *@param Precio precio del producto
    */
     public Producto(int Codigo, String Nombre, double Precio){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Precio = Precio;
    }
     
    public Producto(){}
    
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
    * Metodo equals que compara los id del producto actual y otro
    *@param object objeto tipo Producto que se quiere comparar
    *@return devuelve verdadero si son iguales los  id dos objetos, devuelve falso si no son iguales
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
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
        return "Red.Producto[ id=" + id + " ]";
    }
    
}
