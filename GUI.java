import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI {
    Kontroll kontroll;
    Slange slange;
    int lengde = 1;

    JFrame vindu;
    JPanel panel;
    JLabel score = new JLabel("Lengde: "+ lengde);
    JPanel knapper;
    JPanel rutenett;
    JPanel slutt;
    JLabel[][] ruter = new JLabel[12][12];
    boolean farge;

    public GUI(Kontroll k,Slange slange){
        this.slange = slange;
        this.kontroll = k;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(1);
        }

        JFrame vindu = new JFrame("Slangespill!");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel knapper = new JPanel();
        JPanel rutenett = new JPanel();
        boolean farge = true;

        vindu.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        knapper.setLayout(new BorderLayout());
        rutenett.setLayout(new GridLayout(12,12));
        
        JButton exitKnapp = new JButton("SLUTT");
        JButton oppKnapp = new JButton("Opp");
        JButton nedKnapp = new JButton("Ned");
        JButton venstreKnapp = new JButton("Venstre");
        JButton hoyreKnapp = new JButton("Hoyre");


        vindu.add(panel, BorderLayout.NORTH);
        vindu.add(rutenett, BorderLayout.CENTER);
        panel.add(score,BorderLayout.WEST);
        panel.add(exitKnapp,BorderLayout.EAST);
        panel.add(knapper,BorderLayout.CENTER);

        knapper.add(oppKnapp,BorderLayout.NORTH);
        knapper.add(nedKnapp,BorderLayout.SOUTH);
        knapper.add(venstreKnapp,BorderLayout.WEST);
        knapper.add(hoyreKnapp,BorderLayout.EAST);

        for(int rx =0; rx<12; rx++){
            if(farge){farge = false;}
            else{farge=true;}
            for (int kx = 0; kx <12; kx++){
                JLabel b = new JLabel("");
                ruter[rx][kx] = b;
                if(farge){
                    b.setBackground(Color.lightGray);
                    farge = false;
                } else{
                    b.setBackground(Color.gray);
                    farge = true;
                }
                b.setMinimumSize(new Dimension(30, 30));
                b.setPreferredSize(new Dimension(30,30));
                b.setMaximumSize(new Dimension(40, 40));
                b.setOpaque(true);
                rutenett.add(b);
            }       
        }
        for(int i = 0; i<10; i++){
           leggTilEple();
        }

        exitKnapp.addActionListener(new StoppKnapp());
        oppKnapp.addActionListener(new OppKnapp());
        nedKnapp.addActionListener(new NedKnapp());
        venstreKnapp.addActionListener(new VenstreKnapp());
        hoyreKnapp.addActionListener(new HoyreKnapp());

        vindu.pack();
        vindu.setVisible(true);
}

    void visLengde(int l){
        lengde = l;
        score.setText("Lengde: "+ lengde);
    }
    public JLabel settHode(int x, int y){
        return ruter[x][y];
    }
    public void flyttHode(JLabel hode){

    }


    void fjernSlange(){
        farge = true;
        for(int i=0; i<12; i++){
            if(farge){farge = false;}
            else{farge=true;}

            for(int ix=0; ix<12; ix++){
                if(!ruter[i][ix].getText().equals("$")){
                    ruter[i][ix].setText("");
                }
                if(farge){
                    ruter[i][ix].setBackground(Color.lightGray);
                    farge = false;
                } else{
                    ruter[i][ix].setBackground(Color.gray);
                    farge = true;
                }
            }  
        }
    }

    public void tegnSlange(Slange slange){
        JLabel hode =slange.hentHode();
        hode.setText("O");
        hode.setBackground(slange.hentFarge());
        hode.setForeground(Color.black);
        hode.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        hode.setHorizontalAlignment(SwingConstants.CENTER);
        hode.setOpaque(true);

        ArrayList<JLabel>kropp = slange.hentKropp();

        if (kropp.size()>0){
            for (JLabel k : kropp){
                k.setFont(new Font("Sans Serif", Font.PLAIN, 18));
                k.setText("-");
                k.setBackground(slange.hentFarge());
                k.setForeground(Color.black);
                k.setHorizontalAlignment(SwingConstants.CENTER);
                k.setOpaque(true);
            }
        }
        }

        
    public void leggTilEple(){
        int x = Kontroll.trekk(0, 11);
        int y = Kontroll.trekk(0, 11);
        while(ruter[x][y].getText().equals("$")){
            x = Kontroll.trekk(0, 11);
            y = Kontroll.trekk(0, 11);
        }
        ruter[x][y].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[x][y].setForeground(Color.red);
        ruter[x][y].setHorizontalAlignment( SwingConstants.CENTER );
        ruter[x][y].setText("$");
    }
    
    public JLabel hentRute(int x, int y){
        return ruter[x][y];
    }
    public String hentRuteTekst(int x, int y){
        return ruter[x][y].getText();
    }

    public void ferdig(){
        System.out.println("asscsa");
        ruter[3][3].setText("G");
        ruter[3][3].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[3][3].setForeground(Color.red);
        ruter[3][4].setText("A");
        ruter[3][4].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[3][4].setForeground(Color.red);
        ruter[3][5].setText("M");
        ruter[3][5].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[3][5].setForeground(Color.red);
        ruter[3][6].setText("E");
        ruter[3][6].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[3][6].setForeground(Color.red);
        ruter[4][3].setText("O");
        ruter[4][3].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[4][3].setForeground(Color.red);
        ruter[4][4].setText("V");
        ruter[4][4].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[4][4].setForeground(Color.red);
        ruter[4][5].setText("E");
        ruter[4][5].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[4][5].setForeground(Color.red);
        ruter[4][6].setText("R");
        ruter[4][6].setFont(new Font("Sans Serif", Font.PLAIN, 18));
        ruter[4][6].setForeground(Color.red);

        ruter[3][3].setBackground(Color.BLACK);
        ruter[3][4].setBackground(Color.BLACK);
        ruter[3][5].setBackground(Color.BLACK);
        ruter[3][6].setBackground(Color.BLACK);
        ruter[4][3].setBackground(Color.BLACK);
        ruter[4][4].setBackground(Color.BLACK);
        ruter[4][5].setBackground(Color.BLACK);
        ruter[4][6].setBackground(Color.BLACK);

        ruter[3][3].setHorizontalAlignment(SwingConstants.CENTER);
        ruter[3][4].setHorizontalAlignment(SwingConstants.CENTER);
        ruter[3][5].setHorizontalAlignment(SwingConstants.CENTER);
        ruter[3][6].setHorizontalAlignment(SwingConstants.CENTER);
        ruter[4][3].setHorizontalAlignment(SwingConstants.CENTER);
        ruter[4][4].setHorizontalAlignment(SwingConstants.CENTER);
        ruter[4][5].setHorizontalAlignment(SwingConstants.CENTER);
        ruter[4][6].setHorizontalAlignment(SwingConstants.CENTER);
    }
    


//Knapper
    class StoppKnapp implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.avslutt();
        }
    }
    class OppKnapp implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.oppKnapp();
        }
    }
    class NedKnapp implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.nedKnapp();
        }
    }
    class VenstreKnapp implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.venstreKnapp();
        }
    }
    class HoyreKnapp implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.hoyreKnapp();
        }
    }
}

