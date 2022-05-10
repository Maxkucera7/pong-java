package pkg3ita_pong;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelPongu extends JPanel{
    
    private int[] pL;
    private int[] pP;
    private int[] micek;
    public int bodyPravy;
    public int bodyLevy;
    
    public PanelPongu(){
        this.setVisible(true);
        this.setSize(300, 300);
        this.setBackground(Color.blue);
    }
    
    public void NahazVeci(Palka pL, Palka pP, Micek micek){
        this.pL=pL.getVlastnosti();
        this.pP=pP.getVlastnosti();
        this.micek=micek.getVlastnosti();
    }
    
    @Override
    public void paint(Graphics g){
        try{
        g.fillRect(pL[0], pL[1], pL[2], pL[3]);
        g.fillRect(pP[0], pP[1], pP[2], pP[3]);
        g.fillOval(micek[0], micek[1], micek[2], micek[2]);
        g.drawString(String.valueOf(bodyLevy),this.getWidth()/2-50,25);
        g.drawString(String.valueOf(bodyPravy),this.getWidth()/2+50,25);
        }
        catch(Exception e){
            
        }
    }
    
}
