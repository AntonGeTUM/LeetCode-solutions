import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BlockFill {

    /**
     * The puzzle: the smallest m x n matrix that can fit the given puzzle.
     *  1 for Start
     *  0 for empty field
     *  1 for wall/walked on field
     *  2 for Goal
     *  */
    private int[][] gamefield;
    private Stack<Direction> directions;
    private int startX;
    private int startY;

    public BlockFill(int[][] GAMEFIELD) {
        this.gamefield = GAMEFIELD;
        this.directions = new Stack<>();
    }

    public void solve(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
        if (startX > 0 && gamefield[startX - 1][startY] != 1) {
            directions.push(Direction.UP);
            if (!helper(startX - 1, startY))
                directions.pop();
            else return;
        }
        if (startX < gamefield.length - 1 && gamefield[startX + 1][startY] != 1) {
            directions.push(Direction.DOWN);
            if (!helper(startX + 1, startY))
                directions.pop();
            else return;
        }
        if (startY > 0 && gamefield[startX][startY - 1] != 1) {
            directions.push(Direction.LEFT);
            if (!helper(startX, startY - 1))
                directions.pop();
            else return;
        }
        if (startY < gamefield[0].length - 1 && gamefield[startX][startY + 1] != 1) {
            directions.push(Direction.RIGHT);
            if (!helper(startX, startY + 1))
                directions.pop();
        }
    }

    private boolean helper(int x, int y) {
        if (gamefield[x][y] == 2 && finished()) {
            return true;
        }
        if ((x == 0 || gamefield[x - 1][y] == 1)  && (y == 0 || gamefield[x][y - 1] == 1) &&
                (x == gamefield.length - 1 || gamefield[x + 1][y] == 1) && (y == gamefield[0].length - 1 || gamefield[x][y + 1] == 1)) {
            return false;
        }
        gamefield[x][y] = 1;
        if (x > 0 && gamefield[x - 1][y] != 1) {
            directions.push(Direction.UP);
            if (helper(x - 1, y)) {
                return true;
            } else {
                directions.pop();
            }
        }
        if (x < gamefield.length - 1 && gamefield[x + 1][y] != 1) {
            directions.push(Direction.DOWN);
            if (helper(x + 1, y)) {
                return true;
            } else {
                directions.pop();
            }
        }
        if (y > 0 && gamefield[x][y - 1] != 1) {
            directions.push(Direction.LEFT);
            if (helper(x, y - 1)) {
                return true;
            } else {
                directions.pop();
            }
        }
        if (y < gamefield[0].length - 1 && gamefield[x][y + 1] != 1) {
            directions.push(Direction.RIGHT);
            if (helper(x, y + 1)) {
                return true;
            } else {
                directions.pop();
            }
        }
        gamefield[x][y] = 0;
        return false;
    }

    public boolean finished() {
        for (int[] arr : gamefield) {
            for (int i : arr) {
                if (i == 0) return false;
            }
        }
        return true;
    }

    public String[][] drawSolution() {
        String[][] res = new String[gamefield.length][gamefield[0].length];
        for (int i = 0; i < gamefield.length; i++) {
            for (int j = 0; j < gamefield[0].length; j++) {
                if (gamefield[i][j] == 1) {
                    res[i][j] = " ";
                } else if (gamefield[i][j] == 2) {
                    res[i][j] = "G";
                } else if (gamefield[i][j] == 0) {
                    res[i][j] = "";
                }
            }
        }
        // →, ←, ↑, ↓
        int x = startX;
        int y = startY;
        res[x][y] = "S";
        for (Direction direction : directions) {
            switch (direction) {
                case UP:
                    x -= 1;
                    res[x][y] = "↑";
                    break;
                case DOWN:
                    x += 1;
                    res[x][y] = "↓";
                    break;
                case LEFT:
                    y -= 1;
                    res[x][y] = "←";
                    break;
                case RIGHT:
                    y += 1;
                    res[x][y] = "→";
                    break;
            }
        }
        res[x][y] = "G";
        return res;
    }

    public void prettyPrint() {
        String[][] res = drawSolution();
        for (String[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        /*int[][] gamefield = {
                {1,0,0,1,0,0,0,0},
                {2,0,0,0,0,1,0,0},
                {1,1,0,0,0,0,0,1},
                {1,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,1,0,0,0,1,0,0},
                {0,1,1,0,0,1,1,1},
                {0,0,0,0,0,0,0,0}};*/
        int[][] gamefield = {
                {0,0,1,0,0,0},
                {0,0,0,0,0,0},
                {1,0,0,0,0,0},
                {2,0,0,0,1,0},
                {1,0,0,0,0,0},
                {1,0,0,0,0,0}};
        BlockFill blockFill = new BlockFill(gamefield);
        blockFill.solve(0, 2);
        System.out.println(blockFill.directions);
        blockFill.prettyPrint();
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
