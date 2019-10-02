package code;

public class Player {

    private int number;
    private DF df;
    private GK gk;
    private FW fw;
    private MF mf;

    public Player(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setDFAbility(DF df) {
        this.df = df;
    }

    public void setFWAbility(FW fw) {
        this.fw = fw;
    }

    public void setMFAbility(MF mf) {
        this.mf = mf;
    }

    public void setGKAbility(GK gk) {
        this.gk = gk;
    }

    public boolean canPlayDF() {
        return df.playDF();
    }

    public boolean canPlayFW() {
        return fw.playFW();
    }

    public boolean canPlayMF() {
        return mf.playMF();
    }

    public boolean canPlayGK() {
        return gk.playGK();
    }
}