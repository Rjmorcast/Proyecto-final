/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Red;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class Red {
EntityManagerFactory emf;
    /**
    * atributo que se encarga de la parte de persistencia por medio de querys en el programa
    */
EntityManager em;
    /**
    * Lista de pedido que se han realizado en el programa
    */
ArrayList<Pedido> AllPedidos = new ArrayList<Pedido>();
    /**
    * Lista de pedidos extendidos que se han realizado en el programa
    */
ArrayList<PedidoExtendido> AllPedidosExtendido = new ArrayList<PedidoExtendido>();
    /**
    * Lista de productos 
    */
ArrayList<Producto> AllProducto = new ArrayList<Producto>();

    /**
    * Constructor que se encarga de inicializar los objetos asociados con la persistencia 
    */
public Red(){
    emf = javax.persistence.Persistence.createEntityManagerFactory("REDPU");
    em = emf.createEntityManager();
    GetPedidos();
    GetPedidosExtendidos();
    GetProductos();
}
    /**
    * Metodo que se encarga de obtener los pedidos almacenados y 
    *agregarlos a la lista de pedidos usando querys
    */
public  void GetPedidos(){
    AllPedidos.clear();
   Query q1 = em.createQuery("select p from Pedido p");
      List<Pedido> pedidos = q1.getResultList();
        for (Pedido p: pedidos){ 
            System.out.println(p);
            AllPedidos.add(p);
        }
}
    /**
    * Metodo que se encarga de obtener los pedidosextendidos almacenados
    *y agregarlos a la lista de pedidos usando querys
    */
public  void GetPedidosExtendidos(){
    AllPedidosExtendido.clear();
   Query q1 = em.createQuery("select p from PedidoExtendido p");
      List<PedidoExtendido> pedidos = q1.getResultList();
        for (PedidoExtendido p: pedidos){ 
            AllPedidosExtendido.add(p);
        }
}
     /**
    * Metodo que se encarga de obtener los productos almacenados
    *y agregarlos a la lista de productos usando querys
    */
public  void GetProductos(){
   Query q1 = em.createQuery("select p from Producto p");
      List<Producto> producto = q1.getResultList();
        for (Producto p: producto){ 
            AllProducto.add(p);
        }
}
 /**
    *Metodo que se encarga de obtener el precio por comprar cierta cantidad de un producto
    *@param cantidad cantidad de producto
    *@param ProductoD nombre del producto
    *@return si encuentra un producto, devuleve la cantidad por el precio del producto
    */
public double GetSubtotal(int cantidad, String ProductoD){
    Producto p = new Producto();
    for (int x=0; x<AllProducto.size();x++){
        p = AllProducto.get(x);
        if (ProductoD.equals(p.Nombre)){
            return cantidad * p.Precio;
        }
    }
    return 0;
}

    /**
    *Metodo que se encarga de obtener el precio por comprar cierta cantidad de un producto
    *@param cantidad cantidad de producto
    *@param ProductoD id del producto
    *@return si encuentra un producto, devuleve la cantidad por el precio del producto
    */
public double GetSubtotal(int cantidad, int ProductoD){
    Producto p = new Producto();
    for (int x=0; x<AllProducto.size();x++){
        p = AllProducto.get(x);
        if (ProductoD == (p.id)){
            return cantidad * p.Precio;
        }
    }
    return 0;
}

    /**
    *Metodo que se encarga de obtener el precio de un producto
    *@param ProductoD nombre del producto
    *@return si encuentra un producto, devuleve el precio del producto
    */
public double GetPrecio(String ProductoD){
    Producto p = new Producto();
    for (int x=0; x<AllProducto.size();x++){
        p = AllProducto.get(x);
        if (ProductoD.equals(p.Nombre)){
            return p.Precio;
        }
    }
    return 0;
}

 /**
    *Metodo que se encarga de obtener el precio de un producto
    *@param ProductoD id del producto
    *@return si encuentra un producto, devuleve el precio del producto
    */
public double GetPrecio(int ProductoD){
    Producto p = new Producto();
    for (int x=0; x<AllProducto.size();x++){
        p = AllProducto.get(x);
        if (ProductoD == (p.id)){
            return p.Precio;
        }
    }
    return 0;
}

/**
    *Metodo que se encarga de obtener el codigo de un producto
    *@param ProductoD nombre del producto
    *@return si encuentra un producto, devuleve el codigo del producto
    */
public int GetCode(String ProductoD){
    Producto p = new Producto();
    for (int x=0; x<AllProducto.size();x++){
        p = AllProducto.get(x);
        if (ProductoD.equals(p.Nombre)){
            return p.Codigo;
        }
    }
    return 0;
}

    /**
    *Metodo que agrega un pedido a la base de datos
    *@param x Pedido que se guarda
    */
public void nuevoPedido(Pedido x){
      em.getTransaction().begin();// grabar el pedido en la base de datos
      em.persist(x);
      em.getTransaction().commit();
}
 /**
    *Metodo que agrega un pedidoextendido a la base de datos
    *@param x PedidoExtendido que se guarda
    */
public void nuevoPedidoextendido(PedidoExtendido x){
    //System.out.println(x);
      em.getTransaction().begin();// grabar el pedido en la base de datos
      em.persist(x);
      em.getTransaction().commit();
}
/**
    *Metodo que obtiene el estado de un pedido
    *@param ID codigo del pedido
    *@return si encuentra el pedido, devuelve el estado del pedido
    */
public boolean GetPedidoStatus(int ID){
    Pedido n = new Pedido();
    for (int x =0; x<AllPedidos.size();x++){
        n = AllPedidos.get(x);
        if (ID == n.Codigo){
            return n.Complete;
        }
    }
    return false;
}

    /**
    *Metodo que obtiene un pedido
    *@param ID codigo del pedido
    *@return si encuentra el pedido, lo devuelve
    */
public Pedido GetPedido(int ID){
    Pedido n = new Pedido();
    GetPedidos();
    for (int x =0; x<AllPedidos.size();x++){
        n = AllPedidos.get(x);
        if (ID == n.Codigo){
            return n;
        }
    }
    return null;
}
/**
    *Metodo que completa un pedido 
    *@param p pedido que se quiere completar
    */
public void CompletarPedido (Pedido p){
//    Query q = em.createQuery("select d from Pedido d where d.Codigo = :code");
//        q.setParameter("name", p.Codigo);
//        Pedido pedido = (Pedido) q.getSingleResult();
        if (p != null){
            em.getTransaction().begin();// grabar el docente en la base de datos
            em.persist(p);
            em.getTransaction().commit();
        }
}

}

