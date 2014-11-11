/*
 * Name: Aryan Ghahremanzadeh 
 * Date: November 10, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This program finds  an exit point when given a starting point in a maze
* (if there is one accessible from the given starting point). It shows the path to the exit once it has been found.
 */
package gwss.edu.ics4u.aryan.recursion;

/**
 *
 * @author 1GHAHREMANZA
 */
public class LetMeOut {

    private static final char WALL = 'W';
    private static final char EXIT = 'X';
    private static final char OPEN = '.';
    private static final char TRIED = '-';
    private static final char GOOD_PATH = '+';

    private char[][] maze = {
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
        {'W', '.', '.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W'},
        {'W', '.', 'W', '.', 'W', '.', 'W', 'W', 'W', '.', 'W', 'W', 'W'},
        {'W', '.', 'W', '.', '.', '.', 'W', 'W', '.', '.', '.', '.', 'W'},
        {'W', '.', 'W', '.', 'W', '.', 'W', 'W', '.', 'W', 'W', 'W', 'W'},
        {'W', '.', 'W', 'W', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'X', 'W', 'W', 'W'}
    };

    /**
     * Display the current maze.
     */
    public boolean findExitFrom(int row, int col) {
        // To keep the result of each call
        boolean successful = false;

        // if on exit, exit
        if (maze[row][col] == EXIT) {
            maze[row][col] = GOOD_PATH;
            return true;
        }
        // Mark point as tried
        maze[row][col] = TRIED;

        // Checks to see if the right cell is Open or an exit, if it is, it moves there and calls findExitFrom at the new point
        if (maze[row][col + 1] == OPEN || maze[row][col + 1] == EXIT) {
            successful = findExitFrom(row, col + 1);
        }
        // Checks to see if the last call is not successful and the left cell is Open or an exit, if so, it moves there and calls findExitFrom at the new point
        if (!successful && maze[row][col - 1] == OPEN || maze[row][col - 1] == EXIT) {
            successful = findExitFrom(row, col - 1);
        }
      // Checks to see if the last call is not successful and the higher cell is Open or an exit, if so, it moves there and calls findExitFrom at the new point
        if (!successful && maze[row -1][col] == OPEN || maze[row -1][col] == EXIT) {
            successful = findExitFrom(row -1 , col);
        }
       // Checks to see if the last call is not successful and the lower cell is Open or an exit, if so, it moves there and calls findExitFrom at the new point
        if (!successful && maze[row + 1][col] == OPEN || maze[row + 1][col] == EXIT) {
            successful = findExitFrom(row + 1, col);
        }
        // if last call is successful, marks the point as good path
        if (successful) {
            maze[row][col] = GOOD_PATH;
        }
        return successful;
    }

    /**
     * Display the current maze.
     */
    public void solve() {

        // FIND RANDOM START LOCATION
        int row;
        int col;
        do {
            row = (int) (Math.random() * maze.length);
            col = (int) (Math.random() * maze[0].length);
        } while (maze[row][col] != OPEN);

        // START!
        System.out.println("START LOCATION: (" + row + "," + col + ")");
        findExitFrom(row, col);
        // SHOW EXIT
        displayMaze();

    }

    /**
     * Display the current maze.
     */
    public void displayMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                System.out.print(maze[row][col]);
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LetMeOut lmo = new LetMeOut();
        lmo.displayMaze();
        lmo.solve();

    }

}
