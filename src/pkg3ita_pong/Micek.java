package pkg3ita_pong;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Micek {
    private int[] vlastnosti=new int[3];
    private int[] smerVektor=new int[2]; //urceni smeru letu micku
    
    public Micek(int x, int y, int prumer){
        System.out.println(x+" "+y);
        vlastnosti[0]=x; //sloupce
        vlastnosti[1]=y; //radky//souradnice pro pohyb nahoru a dolu
        vlastnosti[2]=prumer;
        smerVektor[0]=SmerPriStartu()*4; //skaceme po 4 pixelech
    }
    
    public int[] getVlastnosti(){
        return vlastnosti;
    }
    //nastaveni souradnic micku
    public void setSouradnice(int x, int y){
        vlastnosti[0]=x;
        vlastnosti[1]=y;
    }
    
    private int SmerPriStartu(){
        if(new Random().nextBoolean())
            return 1; //pohyb micku doprava
            return -1; //pohyb micku doleba
    }
    
    public void PosunMicku(int vyskaPlatna, Palka pl, Palka pp) {        
        KolizeSeStenou(vyskaPlatna);
        KolizeSPalkou(pl, pp);
        vlastnosti[0] += smerVektor[0];
        vlastnosti[1] += smerVektor[1];

        
        
    }
    
    private void KolizeSeStenou(int vyskaPlatna) {
        
        //pri zjisteni kolize upravit souradnice tak aby v dalsim
        //posunu byl micek primo u steny
        
        if(vlastnosti[1] <= 0) {
            smerVektor[1] *= -1;
            vlastnosti[1]=0;
            
        } else if(vlastnosti[1] >= vyskaPlatna - vlastnosti[2]) {
//            System.out.println(vyskaPlatna - vlastnosti[2]);
//            System.out.println("sad"+vlastnosti[1]);
            vlastnosti[1]=vyskaPlatna-vlastnosti[2];
            smerVektor[1] *= -1;
        }
        
    }
    
    
    private void KolizeSPalkou(Palka pL, Palka pP){
        if(vlastnosti[0] <= pL.getVlastnosti()[0]+pL.getVlastnosti()[2]){
        //leva palka
            if((vlastnosti[1] + vlastnosti[2] >= pL.getVlastnosti()[1])&&(vlastnosti[1] <= pL.getVlastnosti()[1] + pL.getVlastnosti()[3] )){
                smerVektor[0]*=-1;
                if((pL.getVlastnosti()[1]+pL.getVlastnosti()[3]/2) > (vlastnosti[1] + vlastnosti[2]/2)){
                    smerVektor[1]=-(Math.abs((pL.getVlastnosti()[1]+pL.getVlastnosti()[3]/2)-(vlastnosti[1] + vlastnosti[2]/2))/5);
                }else if((pL.getVlastnosti()[1]+pL.getVlastnosti()[3]/2) < (vlastnosti[1] + vlastnosti[2]/2)){
                    smerVektor[1]=(Math.abs((pL.getVlastnosti()[1]+pL.getVlastnosti()[3]/2)-(vlastnosti[1] + vlastnosti[2]/2))/5);
                } else{
                    smerVektor[1]=0;
                }
            }
        }
        else if(vlastnosti[0]+vlastnosti[2] >= pP.getVlastnosti()[0]){
            if((vlastnosti[1] + vlastnosti[2] >= pP.getVlastnosti()[1])&&(vlastnosti[1] <= pP.getVlastnosti()[1] + pP.getVlastnosti()[3] )){
                smerVektor[0]*=-1;
                if((pP.getVlastnosti()[1]+pP.getVlastnosti()[3]/2) > (vlastnosti[1] + vlastnosti[2]/2)){
                    smerVektor[1]=-(Math.abs((pP.getVlastnosti()[1]+pP.getVlastnosti()[3]/2)-(vlastnosti[1] + vlastnosti[2]/2))/5);
                }else if((pP.getVlastnosti()[1]+pP.getVlastnosti()[3]/2) < (vlastnosti[1] + vlastnosti[2]/2)){
                    smerVektor[1]=(Math.abs((pP.getVlastnosti()[1]+pP.getVlastnosti()[3]/2)-(vlastnosti[1] + vlastnosti[2]/2))/5);
                } else{
                    smerVektor[1]=0;
                }
            }
        }
    }
 
    public int setBody(int i){
        return i;
    }
    
    
    
    //odraz od palky, cim dale od stredu micek dopadne
    //tim bude uhle odrazu vetsi
    //odraz od mantynelu uhel odrazu= uhel dopadu
    
    //dodelat zmeny vektoru pri srazkach
    //zde vyresit kolize
}
