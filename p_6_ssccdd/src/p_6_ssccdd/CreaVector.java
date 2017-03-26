
package p_6_ssccdd;


public class CreaVector {
    
    public int[] generador(int tama){
        
        int[] vCreado  = new int[tama];
       
        for(int i = 0; i < tama; ++i){
            vCreado[i] = (int) (Math.random()*10);
        }
        return vCreado;
    }
    
}
