
package guide_8;

import java.util.concurrent.*;
import java.util.Date;

//Utilizando listas seguras con elementos retardados
public class TaskDelay implements Runnable {
    
    private int id;
    
    private DelayQueue<EventDelay> list;
    
    public TaskDelay( int id, DelayQueue<EventDelay> list ) {
        
        this.id = id;
        this.list = list;
    }
    
    
    @Override
    public void run() {
        Date now = new Date();
        Date delay = new Date();
        delay.setTime(now.getTime() + (id * 1000));
        System.out.printf("Thread %s: %s\n", id, delay);
        for (int i = 0; i < 100; i++) {
            EventDelay event = new EventDelay(delay);
            list.add(event);
        }
    }

}
    

