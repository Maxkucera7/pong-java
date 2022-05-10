package pkg3ita_pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;



public class OknoPongu extends javax.swing.JFrame {

    private Palka pL, pP;
    private Micek micek;
    private boolean hrac1Nahoru = false;
    private boolean hrac2Nahoru = false;
    private boolean hrac1Dolu = false;
    private boolean hrac2Dolu = false;
    
    
    public OknoPongu() {
        initComponents();
        InicializaceVseho();
        this.repaint();
        panelPongu1.repaint();        
    }

    private void InicializaceVseho(){
        pL=new Palka(5, panelPongu1.getHeight()/2-25 , 10, 50);
        pP=new Palka(panelPongu1.getWidth()-15, panelPongu1.getHeight()/2-25 , 10, 50);
        micek=new Micek(panelPongu1.getWidth()/2-5, panelPongu1.getWidth()/2-5, 10);
        panelPongu1.NahazVeci(pL, pP, micek);
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_UP) {
                    hrac1Nahoru = true;
                } else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    hrac1Dolu = true;
                } else if(ke.getKeyCode() == KeyEvent.VK_W) {
                    hrac2Nahoru = true;
                } else if(ke.getKeyCode() == KeyEvent.VK_S) {
                    hrac2Dolu = true;
                }
            }
            
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_UP) {
                    hrac1Nahoru = false;
                  
                } else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    hrac1Dolu = false;
                } else if(ke.getKeyCode() == KeyEvent.VK_W) {
                    hrac2Nahoru = false;
                } else if(ke.getKeyCode() == KeyEvent.VK_S) {
                    hrac2Dolu = false;
                }
            }
        });
        
        ActionListener taskPerformer = new ActionListener() {
               public void actionPerformed(ActionEvent evt) {
                        Update();
               }
        };
        new Timer(40, taskPerformer).start();
        
    }
    
    private void Update() {
        
        micek.PosunMicku(panelPongu1.getHeight(),pL,pP);
        
        if(hrac1Nahoru) {
            pP.PosunPalky(false, panelPongu1.getHeight());
        }
        
        if(hrac1Dolu) {
            pP.PosunPalky(true, panelPongu1.getHeight());
        }
        
        if(hrac2Nahoru) {
            pL.PosunPalky(false, panelPongu1.getHeight());
        }
        
        if(hrac2Dolu) {
            pL.PosunPalky(true, panelPongu1.getHeight());
        }
        
        this.repaint();
        panelPongu1.repaint();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPongu1 = new pkg3ita_pong.PanelPongu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout panelPongu1Layout = new javax.swing.GroupLayout(panelPongu1);
        panelPongu1.setLayout(panelPongu1Layout);
        panelPongu1Layout.setHorizontalGroup(
            panelPongu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelPongu1Layout.setVerticalGroup(
            panelPongu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelPongu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelPongu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OknoPongu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoPongu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoPongu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoPongu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoPongu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pkg3ita_pong.PanelPongu panelPongu1;
    // End of variables declaration//GEN-END:variables
}