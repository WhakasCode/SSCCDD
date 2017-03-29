
package guide_8;

import java.util.Date;
import java.util.concurrent.*;

//Utilizando listas seguras con elementos retardados
public class EventDelay implements Delayed {
    
    private Date date;
    
    public EventDelay( Date date ) {
        
        this.date = date;
    }
    
    @Override
    public int compareTo(Delayed d) {
        
        long result = this.getDelay(TimeUnit.NANOSECONDS) - d.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = date.getTime() - now.getTime();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }
    
}
