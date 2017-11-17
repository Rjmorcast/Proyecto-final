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
EntityManager em;
ArrayList<Pedido> AllPedidos = new ArrayList<Pedido>();

public Red(){
    emf = javax.persistence.Persistence.createEntityManagerFactory("UserRedAppPU");
    em = emf.createEntityManager();
    GetPedidos();

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
}