// 暴力枚举法

public class NQueens1 {
	// queens 表示的是皇后的位置，数组下标表示行，数组存的值表示列
	// 比如 queens[3] = 4，代表第3行第4列有皇后
	public static boolean isMeet(int[] queens) {
		for(int i = 2; i < queens.length; i++) {
			for(int j = 1; j < i; j++) {
				// 判断是不是在同一列上有皇后或对角线上有皇后
				// i, j 代表行，queens[i], queens[j] 代表列
				if(queens[i] == queens[j] || Math.abs(queens[i] - queens[j]) == i - j) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] queens = new int[9];
		int count = 0;
		// 先尝试第一行第一列放一个皇后，然后尝试第一行第二列
		// 首先要明白下面这个循环已经保证了八个皇后肯定不在同一行了，因此我们只要判断是不是在同一列或者在不在对角线上就可以了
		for(queens[1] = 1; queens[1] <= 8; queens[1]++)
			for(queens[2] = 1; queens[2] <= 8; queens[2]++)
				for(queens[3] = 1; queens[3] <= 8; queens[3]++)
					for(queens[4] = 1; queens[4] <= 8; queens[4]++)
						for(queens[5] = 1; queens[5] <= 8; queens[5]++)
							for(queens[6] = 1; queens[6] <= 8; queens[6]++)
								for(queens[7] = 1; queens[7] <= 8; queens[7]++)
									for(queens[8] = 1; queens[8] <= 8; queens[8]++)
									{
										if(isMeet(queens)) {
											continue;
										} else {
											++ count;
										}
									}
		System.out.format("八皇后问题共有 %d 种解法", count);
	}
}
