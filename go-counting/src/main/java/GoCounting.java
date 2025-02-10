import java.awt.Point;
import java.util.*;

class GoCounting {
    private final char[][] board;
    private final int rows;
    private final int cols;

    public GoCounting(String boardString) {
        String[] lines = boardString.split("\n");
        this.rows = lines.length;
        this.cols = lines[0].length();
        this.board = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            this.board[i] = lines[i].toCharArray();
        }
    }

    public Player getTerritoryOwner(int x, int y) {
        if (!isValidPoint(x, y)) {
            throw new IllegalArgumentException("Invalid coordinate");
        }
        if (board[y][x] != ' ') {
            return Player.NONE;
        }
        return floodFill(x, y).owner;
    }

    public Set<Point> getTerritory(int x, int y) {
        if (!isValidPoint(x, y)) {
            throw new IllegalArgumentException("Invalid coordinate");
        }
        if (board[y][x] != ' ') {
            return Collections.emptySet();
        }
        return floodFill(x, y).territory;
    }

    public Map<Player, Set<Point>> getTerritories() {
        Map<Player, Set<Point>> territories = new HashMap<>();
        territories.put(Player.BLACK, new HashSet<>());
        territories.put(Player.WHITE, new HashSet<>());
        territories.put(Player.NONE, new HashSet<>());

        boolean[][] visited = new boolean[rows][cols];
        
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (board[y][x] == ' ' && !visited[y][x]) {
                    TerritoryInfo info = floodFill(x, y);
                    territories.get(info.owner).addAll(info.territory);
                    for (Point p : info.territory) {
                        visited[p.y][p.x] = true;
                    }
                }
            }
        }
        return territories;
    }

    private boolean isValidPoint(int x, int y) {
        return x >= 0 && x < cols && y >= 0 && y < rows;
    }

    private TerritoryInfo floodFill(int x, int y) {
        Set<Point> territory = new HashSet<>();
        Set<Character> borderingStones = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        boolean[][] visited = new boolean[rows][cols];
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            territory.add(p);

            for (int[] d : new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}}) {
                int nx = p.x + d[0];
                int ny = p.y + d[1];

                if (isValidPoint(nx, ny)) {
                    char cell = board[ny][nx];
                    if (cell == ' ' && !visited[ny][nx]) {
                        queue.add(new Point(nx, ny));
                        visited[ny][nx] = true;
                    } else if (cell == 'B' || cell == 'W') {
                        borderingStones.add(cell);
                    }
                }
            }
        }
        
        Player owner;
        if (borderingStones.isEmpty() || borderingStones.size() > 1) {
            owner = Player.NONE;
        } else {
            owner = borderingStones.contains('B') ? Player.BLACK : Player.WHITE;
        }
        
        return new TerritoryInfo(owner, territory);
    }

    private static class TerritoryInfo {
        final Player owner;
        final Set<Point> territory;

        TerritoryInfo(Player owner, Set<Point> territory) {
            this.owner = owner;
            this.territory = territory;
        }
    }
}