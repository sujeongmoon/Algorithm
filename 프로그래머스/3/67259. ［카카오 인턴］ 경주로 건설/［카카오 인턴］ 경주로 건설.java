import java.util.*;

class Solution {
    
    static int[] rx = {1, -1, 0, 0};
    static int[] ry = {0, 0, 1, -1};

    
    static class Node {
        int x;
        int y;
        int isX;
        int cost;
        
        Node(int x, int y, int isX, int cost) {
            this.x = x;
            this.y = y;
            this.isX = isX;
            this.cost = cost;
        }
        
    }
    
    static int bfs(int[][] board) {
        int answer = Integer.MAX_VALUE;
 
        
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.add(new Node(0, 0, 0, 0));
        queue.add(new Node(0, 0, 1, 0));
        
        
        ////////////// cost 배열로 만들어보기
        int[][][] cost = new int[board.length][board[0].length][2];
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                for (int k = 0; k < 2; k++) {
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;
        ///////////////
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if (now.x == board.length - 1 && now.y == board.length - 1 && answer > now.cost) {
                answer = now.cost;
            }
            
            if (cost[now.x][now.y][now.isX] < now.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + rx[i];
                int nextY = now.y + ry[i];
                
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                    continue;
                }
                
                if (board[nextX][nextY] == 1) {
                    continue;
                }
                
                int nextIsX = (i <= 1) ? 0 : 1;
                int nextCost = (now.isX == nextIsX) ? now.cost + 100 : now.cost + 600;
                
                if (nextCost < cost[nextX][nextY][nextIsX]) {
                    Node next = new Node(nextX, nextY, nextIsX, nextCost);
                    queue.offer(next);
                    cost[nextX][nextY][nextIsX] = nextCost;
                }
                
            }
       }
        return answer;
    }
    
    
    public int solution(int[][] board) {
        int answer = bfs(board);
        return answer;
    }
}