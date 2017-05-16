/**
 *
 */

public class BattleShip {
    // Field: 0 = empty, 1 = ship's cell isn't hit, 2 = ship's cell is hit
    private int[][] field;

    private int numHitShips;
    private int numDeadShips;


    /*
     * Mark a field in the matrix with "1" = means the cell is occupied with a ship
     * String hitCoord: e.g. "1B 2C"
     */
    private void addShipToField(String shipCoord) {
        int coord[] = getCoord(shipCoord);

        for (int x = coord[0]; x <= coord[1]; x++) {
            for (int y = coord[2]; y <= coord[3]; y++) {
                field[y][x] = 1;
            }
        }
    }

    /*
     * Mark a field in the matrix with "2" = means the cell is hit
     * String hitCoord: e.g. "1B 2C"
     */
    private void hitShip(String hitCoord) {
        int y = Integer.parseInt(hitCoord.substring(0,1)) - 1;
        int x = ((int) hitCoord.charAt(1)) - 65;
        field[y][x] = 2;
    }

    /*
     * Get cordinates from String like "1B 2C"
     * Returns an array with X and Y coordinates of the ship
     */
    private int[] getCoord(String coord) {
        // Get int values from letters (index in the alphabet minus 1)
        int x1 = ((int) coord.charAt(1)) - 65;
        int x2 = ((int) coord.charAt(4)) - 65;

        // Minus 1 because array with ships indexed from 0
        int y1 = Integer.parseInt(coord.substring(0,1)) - 1;
        int y2 = Integer.parseInt(coord.substring(3,4)) - 1;

        return new int[] {x1, x2, y1, y2};
    }

    /*
     * Print field matrix to see it visually
     * int N: size of the field
     */
    private void printField(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Calculate hit & dead ships according to the cells' values (1 or 2)
     * String[] ships: array with ship coordinates, e.g. ["1B 2C", "2D 4D"]
     */
    private void calculateHitDeadShips(String[] ships) {
        for (String ship : ships) {
            int coord[] = getCoord(ship.trim());

            int totalShipCells = 0;
            int hitShipCells = 0;

            for (int x = coord[0]; x <= coord[1]; x++) {
                for (int y = coord[2]; y <= coord[3]; y++) {
                    totalShipCells++;
                    if(field[y][x] == 2)
                        hitShipCells++;
                }
            }

            if(hitShipCells == totalShipCells)
                numDeadShips++;
            else if(hitShipCells > 0)
                numHitShips++;
        }
    }


    /*
     * Play the game
     */
    private String solution(int N, String S, String H) {

        if(N > 26)
            throw new IllegalArgumentException("Number of columns cannot be more than 26");

        if(N == 0)
            return "0,0";

        // Prepare field of the given size
        field = new int[N][N];

        numHitShips = 0;
        numDeadShips = 0;

        // Get separated values from input strings
        String[] ships = S.split(",");
        String[] hits = H.split(" ");

        // Fill the field with ships
        for (String ship : ships) {
            addShipToField(ship.trim());
        }

        // Start battle
        for (String hit : hits) {
            hitShip(hit);
        }

        // Print field to test
        //printField(N);

        // Get number of hit and dead ships
        calculateHitDeadShips(ships);

        return numHitShips + "," + numDeadShips;
    }

    public static void main (String[] args) {
        BattleShip battleShip = new BattleShip();

        // Answer: 0,0
        System.out.println(battleShip.solution(0, "",""));

        // Answer: 1,1
        System.out.println(battleShip.solution(5, "1B 2C, 2D 4D","2B 2D 3D 4D 4A"));

        // Answer: 0,1
        System.out.println(battleShip.solution(10, "1A 2B, 5D 7D","1A 2A 2B 4D 1B"));

        // Answer: 0,0
        System.out.println(battleShip.solution(10, "3A 7C 2E 4D 8C","1A 2B, 5D 7D"));
    }
}