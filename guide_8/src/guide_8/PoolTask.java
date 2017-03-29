
package guide_8;

import java.util.concurrent.ConcurrentLinkedDeque;

//Utilizando listas seguras con hilos sin bloqueo
public class PoolTask implements Runnable {
    
    private ConcurrentLinkedDeque<String> list;
    
    public PoolTask (ConcurrentLinkedDeque<String> list){
        
        this.list = list;
    }
    
    @Override
    public void run(){
        
        String name = Thread.currentThread().getName();
        
        for ( int i = 0; i < 5000; ++i ){
            
            this.list.pollFirst();
            this.list.pollLast();
        }
    }
    
    
    
}
