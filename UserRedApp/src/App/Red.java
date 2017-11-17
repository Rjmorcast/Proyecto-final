/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.ArrayList;
import java.util.List;
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
    * atributo que se encarga de la parte de persistencia por medio de querys en el programa
  */
ArrayList<Pedido> AllPedidos = new ArrayList<Pedido>();
/**
    * Constructor que se encarga de inicializar los objetos asociados con la persistencia 
    */
public Red(){
    emf = javax.persistence.Persistence.createEntityManagerFactory("UserRedAppPU");
    em = emf.createEntityManager();
    GetPedidos();

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
    *Metodo que obtiene los turnos que faltan para terminar el pedido
    *@param ID codigo del pedido
    *@return cantidad de turnos que faltan
    */
public String GetTurnos(int id){
   Pedido n = new Pedido(); 
   int turnos =0;
   for (int x =0; x<AllPedidos.size();x++){
        n = AllPedidos.get(x);
        if (!(id == n.Codigo)){
            if (!n.Complete){
               turnos++;
              
            }
        } else {return "Le faltan "+turnos+" turnos";} 
    }
   return "";
}

public boolean Existe(int ID){
    Pedido n = new Pedido();
    for (int x =0; x<AllPedidos.size();x++){
        n = AllPedidos.get(x);
        if (ID == n.Codigo){
            return true;
        }
    }
    return false;
}

}
