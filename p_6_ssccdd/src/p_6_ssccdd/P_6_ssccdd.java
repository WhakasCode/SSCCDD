
package p_6_ssccdd;

import java.util.concurrent.*;


public class P_6_ssccdd {

    
    public static void main(String[] args) {
        
        System.out.println("Comienza el programa: \n");
        
        CreaVector w = new CreaVector();
        int[] n = w.generador(10000);
        MuestraVector mv = new MuestraVector();
        int vl = (int) (Math.random()*10);
        
        System.out.println("El valor es: " + vl);
        System.out.println("");
        
        System.out.println("El array inicial es: ");
        mv.mostrar(n);
        System.out.println("");
        
        
        Tarea tarea = new Tarea( n, vl, 0, n.length );
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(tarea);
        
        do {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
             }
        } while (!tarea.isDone());
       
        
        
        pool.shutdown();
        
        System.out.println("El array final es: ");
        mv.mostrar(n);
        System.out.println("");
        
         
         if ( tarea.isCompletedNormally() ){
             
             System.out.println("Info: La tarea se ha completado correctamente \n");
         }
         
        
        
         
        System.out.println("El programa ha finalizado");
    }
    
}
