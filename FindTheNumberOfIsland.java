package programs;

public class FindTheNumberOfIsland {

	public static void main(String[] args) {
		char[][] grid = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
		int ans = numIslands(grid);
		System.out.println(ans);
	}

	public static int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0 ;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1' && visited[i][j]==false){
                    count++;
                    visitFullIsland(visited,i,j,grid);
                }
            }
        }
        return count;
    }
    public static void visitFullIsland(boolean[][] visited,int i,int j,char[][] grid){
        if (!isSafe(i,j,grid,visited))return;
        
        visited[i][j] = true;
        grid[i][j] = '0';
        visitFullIsland(visited,i-1,j,grid);
        visitFullIsland(visited,i+1,j,grid);
        visitFullIsland(visited,i,j-1,grid);
        visitFullIsland(visited,i,j+1,grid);
        visitFullIsland(visited,i-1,j-1,grid);
        visitFullIsland(visited,i-1,j+1,grid);
        visitFullIsland(visited,i+1,j-1,grid);
        visitFullIsland(visited,i+1,j+1,grid);
    }
    
    public static  boolean isSafe(int i,int j,char[][] grid,boolean[][] visited){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==true || grid[i][j]=='0')
            return false;
        return true;
    }
}
