package sample;

import java.io.*;
import java.util.Scanner;

public class readAndWriteFileModel{
    static int[] quantityDrinks = {stockModel.spriteStock,stockModel.mountainDewStock,stockModel.fantaStock,stockModel.drPepperStock,stockModel.pepsiStock,stockModel.pepsiMaxStock,stockModel.cokeStock,stockModel.cokeZeroStock};
    static String[] nameDrinks = {"Sprite","MountainDew","Fanta","DrPepper","Pepsi","PepsiMax","Coke","CokeZero"};

    static int[] quantityCash = {stockModel.oneThousandBaht,stockModel.fiveHundredBaht,stockModel.oneHundredBaht,stockModel.fiftyBaht,stockModel.twentyBaht,stockModel.tenBaht,stockModel.fiveBaht,stockModel.oneBaht};
    static String[] nameCash = {"OneThousandBaht","FiveHundredBaht","OneHundredBaht","FiftyBaht","TwentyBaht","TenBaht","FiveBaht","OneBaht"};

    public readAndWriteFileModel() throws IOException {}


    public static void readFileQuantityDrinks() throws IOException {
        Scanner drinksText = new Scanner(new File("DrinksStock.txt"));
        for(int i=0; drinksText.hasNext(); i+=1){
            String line = String.valueOf(drinksText.nextLine().split(" ")[1]);
//            System.out.println(line);
//            System.out.println("int : ");
            int a = Integer.parseInt(line);
            quantityDrinks[i] = a;
            System.out.println(quantityDrinks[i]);

        }

//        System.out.println(quantityDrinks);

        drinksText.close();
    }

    public static void readFileQuantityCash() throws IOException {
        Scanner cashText = new Scanner(new File("CashStock.txt"));
        for(int i=0; cashText.hasNext(); i+=1){
            String[] line = cashText.nextLine().split(" ");
            quantityCash[i] = Integer.parseInt(line[line.length - 1]);
        }
        cashText.close();
    }
    public static void writeFileQuantityDrinks() throws IOException {
        RandomAccessFile writerDrinksText = new RandomAccessFile(new File("DrinksStock.txt"),"rw");
        for(int i=0; i<quantityDrinks.length; i+=1) {
            String line = nameDrinks[i]+" "+quantityDrinks[i]+"\n";
            writerDrinksText.writeUTF(line);
        }
        writerDrinksText.close();
    }
    public static void writeFileQuantityCash()throws IOException {
        RandomAccessFile writerCashText = new RandomAccessFile(new File("CashStock.txt"),"rw");
        for(int i=0; i<quantityDrinks.length; i+=1){
            String line = nameCash[i]+" "+quantityCash[i]+"\n";
            writerCashText.writeUTF(line);
        }
        writerCashText.close();
    }
}
