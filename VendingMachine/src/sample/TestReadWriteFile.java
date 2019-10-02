package sample;


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class TestReadWriteFile {
    public static void main(String[] args) {
        Map<String, Integer> drinks = new TreeMap<>();
        File newfile = new File("DrinksStock.txt");
        {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(newfile));
                String line = "";
                while((line = reader.readLine()) != null){
                    System.out.println(line);
                    drinks.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(drinks);

            System.out.println(drinks.get("Coke"));
            drinks.put("Coke", 7);
            System.out.println(drinks);

        }
    }
}
