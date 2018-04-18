import java.util.ArrayList;
import java.util.List;

// 回溯法-递归版
// N 皇后问题
public class NQueens2 {
	public static boolean isConflict(List<Integer> cols, int col) {
		int row = cols.size();
		for(int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
			if(cols.get(rowIndex) == col) {
				return true;
			}
			if(Math.abs(cols.get(rowIndex) - col) == row - rowIndex) {
				return true;
			}
		}
		return false;
	}
	
	// 重点理解这个函数
	public static void helper(List<List<String>> res, List<Integer> cols, int n) {
		// 判断是否找到了一个解，找到了，添加到的解的集合，然后什么也不做，直接返回
		if(cols.size() == n) {
			res.add(drawChessBoard(cols));
			return;
		} else {
			// 枚举 col 所有可能的路径，下届是 0， 上届 是 n
			for(int col = 0; col < n; col++) {
				// 判断是不是满足约束条件
				// 这里如果发生了冲突，那么不满足约束条件，跳过
				if(isConflict(cols, col)) {
					continue;
				}
				// 满足条件的话做的操作
				cols.add(col);
				// 扩展下一个结点
				helper(res, cols, n);
				// 回溯，清理所占用的状态
				cols.remove(cols.size() - 1);
			}
		}
	}
	
	public static List<String> drawChessBoard(List<Integer> cols) {
		List<String> chessboard = new ArrayList<>();
		for(int i = 0; i < cols.size(); i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < cols.size(); j++) {
				sb.append(j == cols.get(i) ? 'Q' : '.');
			}
			chessboard.add(sb.toString());
		}
		return chessboard;
	}
	
	public static void main(String[] args) {
		int n = 8;
		List<Integer> cols = new ArrayList<>();
		List<List<String>> res = new ArrayList<>();
		helper(res, cols, n);
		System.out.println(res.size());
	}
}
