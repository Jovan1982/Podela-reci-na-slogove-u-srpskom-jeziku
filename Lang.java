/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lang;

import javax.swing.JOptionPane;

/**
 *
 * @author jkrneta
 */
public class Lang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rec = "";
        while (!rec.equalsIgnoreCase("x")) {
            rec = JOptionPane.showInputDialog("Unesite rec za analizu ili X za prekid rada aplikacije");
            if (rec == null) {
                JOptionPane.showMessageDialog(null, "Prijatan dan!");
                return;
            }
//testiranje prevodjenja iz pisma u pismo
            /*
            PrevodiocPisma pp=new PrevodiocPisma();
            JOptionPane.showMessageDialog(null, pp.prevediIzPismaUPismo(rec, Pismo.Cyr, Pismo.Lat));
            JOptionPane.showMessageDialog(null, pp.prevediIzPismaUPismo(rec, Pismo.Lat, Pismo.Cyr));
            */


//testiranje podele reci na slogove
            String podeljeno = "";

            Slog w = new Slog();
            w.setRec(rec);
            podeljeno = w.podeliNaSlogove();

            if (!podeljeno.equalsIgnoreCase("x")) {
                JOptionPane.showMessageDialog(null, podeljeno);

            } else {
                JOptionPane.showMessageDialog(null, "Prijatan dan!");
            }
        }
//System.out.println(podeljeno);

// TODO code application logic here
    }

}
