package sample;

public class stockModel {
    public static int oneThousandBaht;
    public static int fiveHundredBaht;
    public static int oneHundredBaht;
    public static int fiftyBaht;
    public static int twentyBaht;
    public static int tenBaht;
    public static int fiveBaht;
    public static int oneBaht;
    public static int spriteStock;
    public static int mountainDewStock;
    public static int fantaStock;
    public static int drPepperStock;
    public static int pepsiStock;
    public static int pepsiMaxStock;
    public static int cokeStock;
    public static int cokeZeroStock;

    private int allCash;

    public stockModel(){
    }
    public static void purchaseSprite(int number){spriteStock += number;}
    public static void purchaseMountainDew(int number){mountainDewStock += number;}
    public static void purchaseFanta(int number){fantaStock += number;}
    public static void purchaseDrPepper(int number){drPepperStock += number;}
    public static void purchasePepsi(int number){pepsiStock += number;}
    public static void purchasePepsiMax(int number){pepsiMaxStock += number;}
    public static void purchaseCoke(int number){cokeStock += number;}
    public static void purchaseCokeZero(int number){cokeZeroStock += number;}

    public static void insertCash(int cash){
        while(cash>0){
            if(cash==1000){
                oneThousandBaht += 1;
                cash -= 1000;
            }else if(cash>=500){
                fiveHundredBaht += 1;
                cash -= 500;
            }else if(cash>=100){
                oneHundredBaht += cash/100;
                cash -= (cash/100)*100;
            }else if(cash>=50){
                fiftyBaht += cash/50;
                cash -= (cash/50)*50;
            }else if(cash>=20){
                twentyBaht += cash/20;
                cash -= (cash/20)*20;
            }else if(cash>=10){
                tenBaht += cash/10;
                cash -= (cash/10)*10;
            }else if(cash>=5){
                fiveBaht += cash/5;
                cash -= (cash/5)*5;
            }else{
                oneBaht += cash;
                cash -= cash;
            }
        }
    }
    public static void giveChangeCash(int cash){
        while(cash>0){
            if(cash==1000){
                oneThousandBaht -= 1;
                cash -= 1000;
            }else if(cash>=500){
                fiveHundredBaht -= 1;
                cash -= 500;
            }else if(cash>=100){
                oneHundredBaht -= cash/100;
                cash -= (cash/100)*100;
            }else if(cash>=50){
                fiftyBaht -= cash/50;
                cash -= (cash/50)*50;
            }else if(cash>=20){
                twentyBaht -= cash/20;
                cash -= (cash/20)*20;
            }else if(cash>=10){
                tenBaht -= cash/10;
                cash -= (cash/10)*10;
            }else if(cash>=5){
                fiveBaht -= cash/5;
                cash -= (cash/5)*5;
            }else{
                oneBaht -= cash;
                cash -= cash;
            }
        }
    }
    public static boolean isCashRunOut(){
        if(oneThousandBaht==0 || fiveHundredBaht==0 || oneHundredBaht==0 || fiftyBaht==0 || twentyBaht==0 || tenBaht==0 || fiveBaht==0 || oneBaht==0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isSpriteRunOut(){ if(spriteStock==0){ return true;} return false; }
    public static boolean isMountainDewRunOut(){ if(mountainDewStock==0){ return true;} return false; }
    public static boolean isFantaRunOut(){ if(fantaStock==0){ return true; }return false; }
    public static boolean isDrPepperRunOut(){ if(drPepperStock==0){ return true;}return false; }
    public static boolean isPepsiRunOut(){ if(pepsiStock==0){ return true;}return false; }
    public static boolean isPepsiMaxRunOut(){ if(pepsiMaxStock==0){ return true;}return false; }
    public static boolean isCokeRunOut(){ if(cokeStock==0){ return true; } return false; }
    public static boolean isCokeZeroRunOut(){ if(cokeZeroStock==0){ return true;}return false; }

}
