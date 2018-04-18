import java.util.ArrayList;
import java.util.List;

// ���ݷ�-�ݹ��
// N �ʺ�����
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
	
	// �ص�����������
	public static void helper(List<List<String>> res, List<Integer> cols, int n) {
		// �ж��Ƿ��ҵ���һ���⣬�ҵ��ˣ���ӵ��Ľ�ļ��ϣ�Ȼ��ʲôҲ������ֱ�ӷ���
		if(cols.size() == n) {
			res.add(drawChessBoard(cols));
			return;
		} else {
			// ö�� col ���п��ܵ�·�����½��� 0�� �Ͻ� �� n
			for(int col = 0; col < n; col++) {
				// �ж��ǲ�������Լ������
				// ������������˳�ͻ����ô������Լ������������
				if(isConflict(cols, col)) {
					continue;
				}
				// ���������Ļ����Ĳ���
				cols.add(col);
				// ��չ��һ�����
				helper(res, cols, n);
				// ���ݣ�������ռ�õ�״̬
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
