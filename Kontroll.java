public class Kontroll {
    private GUI gui;
    private Slange slange;
    private Slangetraad traad;
    private int forrigeRad;
    private int forrigeKollonne;
    private boolean varEple;

    Kontroll () {
        slange = new Slange(this,Rettning.OST);
        gui = new GUI(this,slange);
        settHode(slange.hentRad(),slange.hentKollonne());
        gui.tegnSlange(slange);
        Slangetraad traad = new Slangetraad(slange, this);
        traad.spill =true;
        traad.run();
    }

    void settHode(int rad, int kollonne){
        slange.settHode(gui.settHode(rad,kollonne));
    }

    static int trekk(int a, int b){
        return (int)(Math.random()*(b-a+1))+a;
    }

    void visLengde(){
        slange.hentLengde();
    }

    void oppdaterBrett(){

        slange.flytt();
        slange.settKropp(gui.hentRute(forrigeRad, forrigeKollonne));
        if(varEple){
            varEple = false;
        }else{
            slange.fjernSiste();
        }

        int rad =slange.hentRad();
        int kollonne = slange.hentKollonne();
        forrigeRad = rad;
        forrigeKollonne = kollonne;

        if(gui.hentRuteTekst(rad,kollonne).equals("$")){
            varEple = true;
            gui.leggTilEple();
        }
        if(gui.hentRuteTekst(rad,kollonne).equals("-")){
            gui.ferdig();
            traad.spill = false;
        }
        gui.fjernSlange();
        gui.tegnSlange(slange);
        gui.visLengde(slange.hentLengde());
    }
    public void ferdig(){
        gui.ferdig();
        traad.spill = false;

    }




    //Knapper
    void oppKnapp(){
        slange.settRettning(Rettning.NORD);
    }
    void nedKnapp(){
        slange.settRettning(Rettning.SOR);
    }
    void venstreKnapp(){
        slange.settRettning(Rettning.VEST);
    }
    void hoyreKnapp(){
        slange.settRettning(Rettning.OST);
    }
    void avslutt () {
        System.exit(0);
    }
}