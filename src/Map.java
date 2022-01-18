public class Map {
    String[][] rooms;

    /**
     * Create a map based on level selected
     * @param level - level that player selected
     */
    public void createMap(Level level)
    {
        if (level == Level.EASY)
        {
            rooms = new String[3][3];
        }
        if (level == Level.MEDIUM)
        {
            rooms = new String[4][4];
        }
        if (level == Level.HARD)
        {
            rooms = new String[5][5];
        }
    }
}
