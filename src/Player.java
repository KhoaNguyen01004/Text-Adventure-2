import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player extends TakePlayerInput{
    private ArrayList<String> inventory = new ArrayList<>();
    private String playerName;

    public Player()
    {
        getUserName();
        FileWriter write;
        try {
            write = new FileWriter(playerName + ".txt");
            write.write(playerName + "\n");
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getUserName()
    {
        System.out.println("Please enter your name (real name is NOT recommended!):");
        playerName = takeInput();
    }

    public List<String> getInventory() {
        return inventory;
    }

    public String getPlayerName() {
        return playerName;
    }


    /**
     * This method will add the item to the inventory
     * @param item - Item to be added to the inventory
     * @return The item that player was taken
     */
    public String take(String item)
    {
        inventory.add(item);
        return item;
    }

    /**
     * This method will remove an item that player use in the inventory.
     * @param item - Item to be remove from the inventory.
     * @return The item that player was used
     */
    public String use(String item)
    {
        inventory.remove(item);
        return item;
    }

    /**
     * This method will take input from keyboard and the character will take action accordingly
     */
    public void inputAction()
    {
        
    }
}