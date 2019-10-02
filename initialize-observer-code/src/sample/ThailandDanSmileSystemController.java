package sample;

public class ThailandDanSmileSystemController {
    private double slang;

    public ThailandDanSmileSystemController() {
        this.slang = 0;
    }

    public double getSlang(){
        return this.slang;
    }

    public void setFromKg(double kg){
        this.slang = kg * 1000 * 3.75;
    }
    public void setFromEnglishSystem(double lb){
        this.slang = lb * 453592.37 / 1000 * 3.75;
    }
    public void setFromTumlung(double tumlung){
        this.slang = tumlung * 16;
    }
    public double toBaht(){
        return this.slang / 4;
    }
    public void toChang(){

    }
}
