
package p_6_ssccdd;

import java.util.concurrent.*;


public class Tarea extends RecursiveAction {
    
    private static final long serialVersionUID = 1L;
    private int[] secuencia;
    private int valor;
    private int inicio;
    private int fin;
    
    
    
    
    
    public Tarea ( int[] v, int vl, int ini, int f ){
        
        
        this.secuencia = v;
        this.valor = vl;
        this.inicio = ini;
        this.fin = f;
        
    }
    
    @Override
    protected void compute(){
        
        if ( fin - inicio < 10 )
            cambiaElementos();
        
        else{
            
            int mitad = (inicio + fin) / 2;
            
            
            //System.out.printf("Task: Pending tasks:  %s\n",getQueuedTaskCount());
            Tarea t1=new Tarea( secuencia, valor, inicio, mitad + 1 );
            Tarea t2=new Tarea( secuencia, valor, mitad + 1, fin );
            invokeAll(t1, t2);  
        }
    }
    
    
    void cambiaElementos (){
        
        boolean par = false;
        
        if ( valor%2 == 0)
            par = true;
        
       
            
        if( par ){
            
            for( int i = 0; i < secuencia.length; ++i){
                
                if( secuencia[i]%2 == 0)
                    secuencia[i] = valor;
            }
            
        }else{
            
            for( int i = 0; i < secuencia.length; ++i){
                
                if( secuencia[i]%2 != 0)
                    secuencia[i] = valor;
            }
                
       
        }
        
    }
    
   
    
}
