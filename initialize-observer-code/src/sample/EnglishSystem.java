package sample;

public class EnglishSystem {
    private double oz;
    public EnglishSystem(){
        this.oz = 0;
    }

    public void setPound(double pound) {
        this.oz = pound * 16;
    }
    public void setFromMetricSystem(double kg){
        this.oz = kg * 35.2739619 ;
    }
//    public void setFromTumlung(double tumlung){
//        this.oz = tumlung / 16.66666667;
//    }
    public double toStone(){
        return this.oz / 224;
    }
    public double toPound(){
        return this.oz / 16;
    }

    public double getOz() {
        return oz;
    }
}
