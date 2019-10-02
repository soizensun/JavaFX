package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayerManager {

    private ArrayList<Player> playerArrayList = new ArrayList<>();
    private ArrayList<String> selectedPlayer = new ArrayList<>();
    private ArrayList<Integer> allPlayerNumber = new ArrayList<>();

    public PlayerManager() throws Exception {
        readFileToPlayer();
    }

    private File getFile() throws Exception {
        String jarDir = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        return new File(jarDir + "/team.csv");
        // return new File("team.csv");
    }

    private void readFileToPlayer() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile()));
        String line = bufferedReader.readLine();
        while (line != null) {
            if (!line.equals("NAME,SHIRT,POSITION")) {
                String[] s = line.split(",");
                Player player = new Player(Integer.parseInt(s[1]));
                allPlayerNumber.add(Integer.parseInt(s[1]));

                if (s[2].contains("MF"))
                    player.setMFAbility(new AbleToPlayMF());
                else
                    player.setMFAbility(new UnableToPlayMF());

                if (s[2].contains("DF"))
                    player.setDFAbility(new AbleToPlayDF());
                else
                    player.setDFAbility(new UnableToPlayDF());

                if (s[2].contains("FW"))
                    player.setFWAbility(new AbleToPlayFW());
                else
                    player.setFWAbility(new UnableToPlayFW());

                if (s[2].contains("GK"))
                    player.setGKAbility(new AbleToPlayGK());
                else
                    player.setGKAbility(new UnableToPlayGK());

                playerArrayList.add(player);
            }
            line = bufferedReader.readLine();
        }
    }

    private int random() {
        Random random = new Random();

        int index = random.nextInt(allPlayerNumber.size());
        for (int playerNumber : allPlayerNumber) {
            if (index == 0)
                return playerNumber;
            index--;
        }
        return 0;
    }

    public void clearSelectedPlayer() {
        selectedPlayer.clear();
    }

    public String plan(String mode, int amount) {
        StringBuilder result = new StringBuilder();
        result.append(mode + " :  ");

        for (int i = 0; i < amount; i++) {
            while (true) {
                int n = random();
                for (Player player : playerArrayList) {
                    boolean canPlay = false;
                    if (mode.equals("DF"))
                        canPlay = player.canPlayDF();
                    else if (mode.equals("MF"))
                        canPlay = player.canPlayMF();
                    else if (mode.equals("FW"))
                        canPlay = player.canPlayFW();
                    else if (mode.equals("GK"))
                        canPlay = player.canPlayGK();

                    boolean isAlreadyPlay = false;
                    for (String playerNumber : selectedPlayer) {
                        if (playerNumber.equals(String.valueOf(player.getNumber())))
                            isAlreadyPlay = true;
                    }

                    if (canPlay && n == player.getNumber() && !isAlreadyPlay) {
                        result.append(player.getNumber() + "  ");
                        selectedPlayer.add(String.valueOf(player.getNumber()));

                        n = -1;
                        break;
                    }
                }

                if (n == -1) {
                    Collections.shuffle(allPlayerNumber);
                    break;
                }
            }
        }

        return result.toString();
    }
}