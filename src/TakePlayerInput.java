import java.util.Scanner;
import java.util.regex.Pattern;

public class TakePlayerInput {
    private Scanner keyboard = new Scanner(System.in);

    public String takeInput() {
        System.out.print("> ");
        return keyboard.nextLine();
    }

    public boolean validInput(String input)
    {
        if (Pattern.matches("up", input) || Pattern.matches("down", input) ||
            Pattern.matches("left", input) || Pattern.matches("right", input)) return true;
        if (Pattern.matches("[take]", input)) return true;
    }
}
