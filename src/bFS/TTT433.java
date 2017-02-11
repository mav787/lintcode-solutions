package bFS;

public class TTT433 {
	public int numIslands(boolean[][] grid) {
		// Write your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int res = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == true) {
					helper(grid, i, j, m, n);
					res++;
				}
			}
		}
		return res;
	}

	private void helper(boolean[][] grid, int i, int j, int m, int n) {

		// grid[i][j] != true就return，避免互相调用来调用去，overflow掉
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != true) {
			return;
		}

		grid[i][j] = false;

		helper(grid, i - 1, j, m, n);
		helper(grid, i + 1, j, m, n);
		helper(grid, i, j - 1, m, n);
		helper(grid, i, j + 1, m, n);
	}
}
