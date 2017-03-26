
package p_7_ssccdd;

import java.util.concurrent.*;


public class Tarea extends RecursiveTask<Float>{
    
     private static final long serialVersionUID = 1L;
     
     private int pFila;
     private int fFila;
     private int pColumna;
     private int fColumna;
     
     private int[][] matriz;
     
     
     public Tarea( int[][] m, int pF, int fF, int pC, int fC ){
         
         this.matriz = m;
         this.pFila = pF;
         this.fFila = fF;
         this.pColumna = pC;
         this.fColumna = fC;
     }
     
     @Override
     protected Float compute(){
         
         float media = 0;
         
         int mF = (pFila + fFila)/2;
         int mC = (pColumna + fColumna)/2;
         
         if( this.fFila - this.pFila == 2){
             
             for (int i = this.pFila; i < this.fFila; ++i) {
                for (int j = this.pColumna; j < this.fColumna; ++j) {
                    media = media + matriz[i][j];
                }
            }
            media = media / 4;
             
             
         }else{
             
             
             
             Tarea t1 = new Tarea(this.matriz, this.pFila, mF, this.pColumna, mC );
             Tarea t2 = new Tarea(this.matriz, this.pFila, mF, mC, this.fColumna );
             Tarea t3 = new Tarea(this.matriz, mF, this.fFila, this.pColumna, mC );
             Tarea t4 = new Tarea(this.matriz, mF, this.fFila, mC, this.fColumna );
             
             t1.fork();
             t2.fork();
             t3.fork();
             t4.fork();
             
             media = media + t1.join();
             media = media + t2.join();
             media = media + t3.join();
             media = media + t4.join();
             
             
             
         }
         
         return media/4;
     }
     
     
     
     
        
        
    
}
