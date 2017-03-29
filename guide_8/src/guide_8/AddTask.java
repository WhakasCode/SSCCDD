
package guide_8;

import java.util.concurrent.ConcurrentLinkedDeque;

//Utilizando listas seguras con hilos sin bloqueo
public class AddTask implements Runnable{
    
    private ConcurrentLinkedDeque<String> list;
    
    public AddTask (ConcurrentLinkedDeque<String> list){
        
        this.list = list;
    }
    
    @Override
    public void run(){
        
        String name = Thread.currentThread().getName();
        
        for ( int i = 0; i < 10000; ++i ){
            
            this.list.add(name + ": Element " + i);
        }
    }
    
}
