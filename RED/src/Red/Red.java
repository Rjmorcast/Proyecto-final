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
EntityManager em;
ArrayList<Pedido> AllPedidos = new ArrayList<Pedido>();
ArrayList<PedidoExtendido> AllPedidosExtendido = new ArrayList<PedidoExtendido>();
ArrayList<Producto> AllProducto = new ArrayList<Producto>();

public Red(){
    emf = javax.persistence.Persistence.createEntityManagerFactory("REDPU");
    em = emf.createEntityManager();
    GetPedidos();
    GetPedidosExtendidos();
    GetProductos();
}

public  void GetPedidos(){
    AllPedidos.clear();
   Query q1 = em.createQuery("select p from Pedido p");
      List<Pedido> pedidos = q1.getResultList();
        for (Pedido p: pedidos){ 
            System.out.println(p);
            AllPedidos.add(p);
        }
}
public  void GetPedidosExtendidos(){
    AllPedidosExtendido.clear();
   Query q1 = em.createQuery("select p from PedidoExtendido p");
      List<PedidoExtendido> pedidos = q1.getResultList();
        for (PedidoExtendido p: pedidos){ 
            AllPedidosExtendido.add(p);
        }
}

public  void GetProductos(){
   Query q1 = em.createQuery("select p from Producto p");
      List<Producto> producto = q1.getResultList();
        for (Producto p: producto){ 
            AllProducto.add(p);
        }
}

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

public void nuevoPedido(Pedido x){
      em.getTransaction().begin();// grabar el pedido en la base de datos
      em.persist(x);
      em.getTransaction().commit();
}

public void nuevoPedidoextendido(PedidoExtendido x){
    //System.out.println(x);
      em.getTransaction().begin();// grabar el pedido en la base de datos
      em.persist(x);
      em.getTransaction().commit();
}

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

