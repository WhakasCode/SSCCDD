
package guide_8;

//Utilizando listas seguras ordenadas por prioridad con hilos con bloqueo
public class Event implements Comparable<Event> {
    
    private int thread;
    
    private int priority;
    
    public Event( int thread, int priority ) {
        
        this.thread = thread;
        this.priority = priority;
    }
    
    public int getThread() {
        return this.thread;
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    @Override
    public int compareTo( Event e ) {
  
        if (this.priority > e.getPriority()) {
            
            return -1;
        } else if (this.priority < e.getPriority()) {
            
            return 1;
        } else {
            return 0;
        }
      }
    
    
}
