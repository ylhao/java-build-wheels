package tree;
/*
 * ���������������������ֵС�ڸ���㣬����������ֵ���ڸ����
 * ��������������BST �в�����ֵ��ͬ�Ľ��
 * 
 * ��ӽ��
 * ���ҽ��
 * ɾ�����
 */
class TreeNode {
	public int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class BinarySearchTree {
	TreeNode root;
	
	public void addNode(int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) {
			root = node;
			return;
		}
		TreeNode focusNode = root;
		TreeNode parent = root;
		while(true) {
			parent = focusNode;
			if(node.val > focusNode.val) { // ���Ҫ�������ֵ���ڵ�ǰ����ֵ
				focusNode = focusNode.right;
				if(focusNode == null) {
					parent.right = node;
					return;
				}
			} else if(node.val < focusNode.val) {
				focusNode = focusNode.left;
				if(focusNode == null) {
					parent.left = node;
					return;
				}
			}
		}
	}
	
	public TreeNode findNode(int val) {
		if(root == null) {
			return root;
		}
		TreeNode focusNode = root;
		while(focusNode != null) {
			if(focusNode.val == val) {
				return focusNode;
			} else if(val < focusNode.val) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}
		}
		return focusNode;
	}
	
	public void deleteNode(int val) {
		if(root == null) {  // ��Ϊ��
			return;
		}
		// �ҵ�Ҫɾ�Ľ����丸���
		TreeNode focusNode = root;
		TreeNode parent = root;
		while(focusNode != null) {
			if(focusNode.val == val) {
				break;
			} else if(val < focusNode.val) {
				parent = focusNode;
				focusNode = focusNode.left;
			} else {
				parent = focusNode;
				focusNode = focusNode.right;
			}
		}
		if(focusNode == null) {  // û���ҵ����ֱ�ӷ���
			System.out.println("û���ҵ����");
			return;
		} else if(focusNode.left == null && focusNode.right == null) {  // ��ɾ�����Ҷ�ӽ��
			if(focusNode == root) {
				root = null;
			} else {
				if(parent.left == focusNode) {
					parent.left = null;
				} else if(parent.right == focusNode) {
					parent.right = null;
				}
			}
		} else if(focusNode.right == null) {  // �����ɾ���û����������ֱ�����������������汻ɾ���
			focusNode.val = focusNode.left.val;
			focusNode.left = focusNode.left.left;
		} else if(focusNode.right.left == null) {  // �����ɾ�����������������ɾ����������û��������
			focusNode.val = focusNode.right.val;
			focusNode.right = focusNode.right.right; 
		} else if(focusNode.right.left != null) {  // �����ɾ��������������ұ�ɾ������������������
			TreeNode temp = focusNode.right.left;
			TreeNode tempParent = focusNode.right;
			while(temp.left != null) {
				tempParent = temp;
				temp = temp.left;
			}
			focusNode.val = temp.val;
			tempParent.left = null;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst1 = new BinarySearchTree();
		int[] vals = new int[]{50};
		for(int val : vals) {
			bst1.addNode(val);
		}
		bst1.deleteNode(50);
		TraverseTree.preOrderTraverseR(bst1.root);
		System.out.println("---------------------------");
		
		BinarySearchTree bst2 = new BinarySearchTree();
		vals = new int[]{50, 25, 15};
		for(int val : vals) {
			bst2.addNode(val);
		}
		bst2.deleteNode(15);
		TraverseTree.preOrderTraverseR(bst2.root);
		System.out.println("---------------------------");
		
		BinarySearchTree bst3 = new BinarySearchTree();
		vals = new int[]{50, 25, 15, 75, 80};
		for(int val : vals) {
			bst3.addNode(val);
		}
		bst3.deleteNode(50);
		TraverseTree.preOrderTraverseR(bst3.root);
		System.out.println("---------------------------");
		
		BinarySearchTree bst4 = new BinarySearchTree();
		vals = new int[]{50, 25, 15, 75, 80, 90};
		for(int val : vals) {
			bst4.addNode(val);
		}
		bst4.deleteNode(75);
		TraverseTree.preOrderTraverseR(bst4.root);
		System.out.println("---------------------------");
		
		BinarySearchTree bst5 = new BinarySearchTree();
		vals = new int[]{50, 25, 15, 75, 60, 80};
		for(int val : vals) {
			bst5.addNode(val);
		}
		bst5.deleteNode(50);
		TraverseTree.preOrderTraverseR(bst5.root);
		System.out.println("---------------------------");
		
		BinarySearchTree bst6 = new BinarySearchTree();
		vals = new int[]{50, 25, 15, 75, 60, 80, 76};
		for(int val : vals) {
			bst6.addNode(val);
		}
		bst6.deleteNode(75);
		TraverseTree.preOrderTraverseR(bst6.root);
		System.out.println("---------------------------");
	}
}
