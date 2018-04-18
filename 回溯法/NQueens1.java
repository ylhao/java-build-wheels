// ����ö�ٷ�

public class NQueens1 {
	// queens ��ʾ���ǻʺ��λ�ã������±��ʾ�У�������ֵ��ʾ��
	// ���� queens[3] = 4�������3�е�4���лʺ�
	public static boolean isMeet(int[] queens) {
		for(int i = 2; i < queens.length; i++) {
			for(int j = 1; j < i; j++) {
				// �ж��ǲ�����ͬһ�����лʺ��Խ������лʺ�
				// i, j �����У�queens[i], queens[j] ������
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
		// �ȳ��Ե�һ�е�һ�з�һ���ʺ�Ȼ���Ե�һ�еڶ���
		// ����Ҫ�����������ѭ���Ѿ���֤�˰˸��ʺ�϶�����ͬһ���ˣ��������ֻҪ�ж��ǲ�����ͬһ�л����ڲ��ڶԽ����ϾͿ�����
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
		System.out.format("�˻ʺ����⹲�� %d �ֽⷨ", count);
	}
}
