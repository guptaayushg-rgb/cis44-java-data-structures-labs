public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public boolean solve() {
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }
        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }

    private boolean solve(int row, int col) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        }
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }
        if (maze[row][col] == 'F') {
            return true;
        }
        if (maze[row][col] != 'S') {
            maze[row][col] = '.';
        }
        if (solve(row - 1, col)) return true;
        if (solve(row, col + 1)) return true;
        if (solve(row + 1, col)) return true;
        if (solve(row, col - 1)) return true;
        if (maze[row][col] != 'S') {
            maze[row][col] = ' ';
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] maze1 = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver1 = new MazeSolver(maze1);
        System.out.println("Original Maze 1:");
        solver1.printMaze();
        if (solver1.solve()) {
            System.out.println("Solution Found for Maze 1:");
        } else {
            System.out.println("No Solution Found for Maze 1:");
        }
        solver1.printMaze();

        char[][] maze2 = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', '#', ' ', '#'},
                {'#', ' ', '#', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', ' ', '#', '#'},
                {'#', '#', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver2 = new MazeSolver(maze2);
        System.out.println("Original Maze 2:");
        solver2.printMaze();
        if (solver2.solve()) {
            System.out.println("Solution Found for Maze 2:");
        } else {
            System.out.println("No Solution Found for Maze 2:");
        }
        solver2.printMaze();
    }
}
