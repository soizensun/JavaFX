package sample;

public class vendingMachineModel {
    private static int totalValue, insertMoney;

    public vendingMachineModel(){
        totalValue = 0;
        insertMoney = 0;
    }
    public static void purchase(int price){
        totalValue += price;
    }
    public static void cancelPurchase(int price){
        totalValue -= price;
    }
    public static void setInsertMoney(int money){
        insertMoney = money;
    }
    public static int getInsertMoney(){
        return insertMoney;
    }
    public static int getTotalValue(){
        return totalValue;
    }
    public static String getChange(){
        int change;
        change = insertMoney - totalValue;
        insertMoney = 0;
        totalValue = 0;
        stockModel.giveChangeCash(change);
        return Integer.toString(change);
    }
}
