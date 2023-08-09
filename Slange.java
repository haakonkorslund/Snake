import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.*;
public class Slange {
    
    private Color farge = Color.GREEN;
    private Kontroll kontroll;
    private Rettning rettning;
    private ArrayList<JLabel> kropp = new ArrayList<>();
    private JLabel hode;

    private int rad = 6;
    private int kollonne =6;

    public Slange(Kontroll kontroll,Rettning rettning){
        this.kontroll = kontroll;
        this.rettning = rettning;
    }

    public int hentRad(){
        return rad;
    }
    public int hentKollonne(){
        return kollonne;
    }
    public void settHode(JLabel hode){
        this.hode = hode;
    }
    public JLabel hentHode(){
        return hode;
    }
    public void settKropp(JLabel k){
        kropp.add(k);
    }
    public ArrayList hentKropp(){
        return kropp;
    }

    public int hentLengde(){
         return kropp.size()+1;
    }
    
    public Color hentFarge(){
        return farge;
    }

    public Rettning hentRettning() {
        return rettning;
    }

    public void settRettning(Rettning rettning){
        this.rettning = rettning;
    }

    public void fjernSiste(){
        kropp.remove(0);
    }
    public void flytt() {
        if(hentRettning()==Rettning.NORD){
            if(rad ==0){
                kontroll.ferdig();
                return;
            }
            rad--;
            kontroll.settHode(rad,kollonne);
        }
        else if(hentRettning()==Rettning.SOR){
            if(rad ==11){
                kontroll.ferdig();
                return;
            }
            rad++;
            kontroll.settHode(rad,kollonne);
        }
        else if(hentRettning()== Rettning.OST){
            if(kollonne ==11){
                kontroll.ferdig();
                return;
            }
            kollonne++;
            kontroll.settHode(rad, kollonne);
        }
        else if(hentRettning() == Rettning.VEST){
            if(kollonne ==0){
                kontroll.ferdig();
                return;
            }
            kollonne--;
            kontroll.settHode(rad, kollonne);
        }
    }

}