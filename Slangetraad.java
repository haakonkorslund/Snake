public class Slangetraad implements Runnable{
    Slange slange;
    Kontroll kontroll;
    public int sov =500;
    Boolean spill = false;

    public Slangetraad(Slange slange, Kontroll kontroll){
    this.slange = slange;
    this.kontroll = kontroll;
    }

    @Override
    public void run(){
        try {
            while(spill){
                Thread.sleep(sov);
                kontroll.oppdaterBrett();
            }
            
        } catch (Exception e) {
        }

    }
}
