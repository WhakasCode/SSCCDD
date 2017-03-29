
package guide_8;

import java.util.concurrent.*;
import java.util.Date;


public class Guide_8 {

    
    public static void main(String[] args) {
        
        /*
        //Utilizando listas seguras con hilos sin bloqueo
        
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        
        Thread threads[] = new Thread[100];
        
        for ( int i = 0; i < threads.length; ++i ){
            
            AddTask task = new AddTask( list );
            threads[i] = new Thread( task );
            threads[i].start();
        }
        
       System.out.println(threads.length);
       
       for ( int i = 0; i < threads.length; ++i ){
           
           try {
               
                threads[i].join();
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
       }
       
       System.out.println(list.size());
       
       for ( int i = 0; i < threads.length; ++i ){
            
            PoolTask task = new PoolTask( list );
            threads[i] = new Thread( task );
            threads[i].start();
        }
       
       System.out.println(threads.length);
       
       for ( int i = 0; i < threads.length; ++i ){
           
           try {
               
                threads[i].join();
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
       }
       
       System.out.println(list.size());
       
        
        //Utilizando lista seguras con hilos con bloqueo
        LinkedBlockingDeque<String> listBlocking = new LinkedBlockingDeque<>();
        
        Client taskB = new Client( listBlocking );
        
        Thread threadB = new Thread( taskB );
        
        threadB.start();
        
        try {
            for ( int i = 0; i < 5; i++ ) {
                for ( int j = 0; j < 3; j++ ) {
                    String request = listBlocking.take();
                    System.out.printf("Main: Request: %s at %s. Size:%d\n", request, new Date(), listBlocking.size());
                }
                TimeUnit.MILLISECONDS.sleep(300);
            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }


        //Utilizando listas seguras ordenadas por prioridad con hilos con bloqueo
        PriorityBlockingQueue<Event> pbq = new PriorityBlockingQueue<>();
        
        Thread threadsPBQ[] = new Thread[5];
        
        for ( int i = 0; i < threadsPBQ.length; ++i ) {
            
            Task task = new Task( i, pbq );
            threadsPBQ[i] = new Thread( task );
        }
        
        for ( int i = 0; i < threadsPBQ.length; ++i ) {
            
            threadsPBQ[i].start();
        }
        
        try {
            for (int i = 0; i < threadsPBQ.length; ++i) {

                threadsPBQ[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.printf("Main: Queue Size: %d\n", pbq.size());
        for (int i = 0; i < threadsPBQ.length * 1000; i++) {
            Event event = pbq.poll();
            System.out.printf("Thread %s: Priority %d\n", event.
                    getThread(), event.getPriority());
        }
        System.out.printf("Main: Queue Size: %d\n", pbq.size());
        System.out.printf("Main: End of the program\n");
*/
        
        
        //Utilizando listas seguras con elementos retardados
        DelayQueue<EventDelay> listDQ = new DelayQueue<>();
        
        Thread threadsDQ[] = new Thread[5];
        
        for ( int i = 0; i < threadsDQ.length; ++i ) {
            
            TaskDelay taskD = new TaskDelay( i + 1, listDQ );
            threadsDQ[i] = new Thread( taskD );
        }
        
        for ( int i = 0; i < threadsDQ.length; ++i ) {
            
            threadsDQ[i].start();
        }
        
        try {
            for (int i = 0; i < threadsDQ.length; ++i) {

                threadsDQ[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        try {
        do {
            int counter = 0;
            EventDelay event;
            do {
                event = listDQ.poll();
                if (event != null) {
                    counter++;
                }
            } while (event != null);
            System.out.printf("At %s you have read %d events\n", new Date(), counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while (listDQ.size() > 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
