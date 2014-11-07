/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    boolean found = false;

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
        // if on exit, exit
        if (maze[row][col] == EXIT) {
            maze[row][col] = GOOD_PATH;
            found = true;
            return true;
        }
        // if exit is beside it, it goes there
        if (maze[row][col + 1] == EXIT) {
            maze[row][col] = GOOD_PATH;
            maze[row][col + 1] = GOOD_PATH;
            found = true;
            return true;
        }
        if (maze[row][col - 1] == EXIT) {
            maze[row][col] = GOOD_PATH;
            maze[row][col - 1] = GOOD_PATH;
            found = true;
            return true;
        }
        if (maze[row - 1][col] == EXIT) {
            maze[row][col] = GOOD_PATH;
            maze[row - 1][col] = GOOD_PATH;
            found = true;
            return true;
        }
        if (maze[row + 1][col] == EXIT) {
            maze[row][col] = GOOD_PATH;
            maze[row + 1][col] = GOOD_PATH;
            found = true;
            return true;
        }
        // looks for exit
        if (maze[row][col + 1] == OPEN) {
            maze[row][col] = TRIED;
            findExitFrom(row, col + 1);
            if (found) {
                maze[row][col] = GOOD_PATH;
                return true;
            }
        }
        if (maze[row][col - 1] == OPEN) {
            maze[row][col] = TRIED;
            findExitFrom(row, col - 1);
            if (found) {
                maze[row][col] = GOOD_PATH;
                return true;
            }
        }
        if (maze[row - 1][col] == OPEN) {
            maze[row][col] = TRIED;
            findExitFrom(row - 1, col);
            if (found) {
                maze[row][col] = GOOD_PATH;
                return true;
            }
        }
        if (maze[row + 1][col] == OPEN) {
            maze[row][col] = TRIED;
            findExitFrom(row + 1, col);
            if (found) {
                maze[row][col] = GOOD_PATH;
                return true;
            }
        }
        maze[row][col] = TRIED;
        return found;   
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

//    public boolean findExit(int row, int col) {
//        boolean success = true;
//
//            return false;
//        }
}
