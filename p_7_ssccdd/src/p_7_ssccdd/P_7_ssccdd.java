
package p_7_ssccdd;

import java.util.concurrent.*;


public class P_7_ssccdd {

    public static void main(String[] args) {
        
        
        
        int potencia = 7 + (int) (Math.random() * 4);
        int tama = (int) Math.pow(2, potencia);
        int matriz[][] = new int[tama][tama];
        
        for( int i = 0; i < tama; ++i){
            for( int j = 0; j < tama; ++j ){
                matriz[i][j] = 1 + (int) (Math.random()*9);
            }
        }
        
        Tarea tMain=new Tarea(matriz,0,tama,0,tama);
        
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(tMain);
        
        
        do{
            try {
                
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {}
        }while(!tMain.isDone());
                
        float media = tMain.join();
        pool.shutdown();
        
        System.out.println("La media es: " + media );
    }
}
    
