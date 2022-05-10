package pkg3ita_pong;

public class Palka {
    private int[] vlastnosti=new int[4];
    
    public Palka(int x, int y, int delka, int sirka){
        vlastnosti[0]=x; //souradnice pro pohyb nahoru a dolu
        vlastnosti[1]=y; 
        vlastnosti[2]=delka;
        vlastnosti[3]=sirka;
    }
    
    public int[] getVlastnosti(){
        return vlastnosti;
    }
    
    //pro upravu pozice palky
    public void setPoziciY(int y){
        vlastnosti[1]=y;
    }
    
    public void PosunPalky(boolean smer, int vyskaPlatna) {
        
        if(smer) { //dolu
            
            if(vlastnosti[1] + vlastnosti[3] + 4 >= vyskaPlatna) {
                vlastnosti[1] = vyskaPlatna - vlastnosti[3] ;
            } else {
                vlastnosti[1] += 4;
            }
            
        } else { //nahoru
            
            if(vlastnosti[1] - 4 <= 0) {
                vlastnosti[1] = 0;
            } else {
                vlastnosti[1] -= 4;
            }
            
        }
            
        
    }
    
}
