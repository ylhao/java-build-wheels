class TreeNode {
	public int val;
	public int height;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class AVLTree {

	// 获取树的高度
	public int height(TreeNode root) {
		if(root != null) {
			return root.height;
		}
		return 0;
	}

	// LL
	public TreeNode leftLeftRotation(TreeNode k1) {
		TreeNode k2 = k1.left;
		k1.left = k2.right;
		k2.right = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.left), k1.height) + 1;
		return k2;
	}

	// RR
	public TreeNode rightRightRotation(TreeNode k1) {
		TreeNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}

	//LR
	public TreeNode leftRightRotation(TreeNode k1) {
		k1.left = rightRightRotation(k1.left);
		return leftLeftRotation(k1);
	}

	// RL
	public TreeNode rightLeftRotation(TreeNode k1) {
		k1.right = leftLeftRotation(k1.right);
		return rightRightRotation(k1);
	}

	public TreeNode insert(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		/*
		 * BST 树，AVL 树一定是在叶子结点上插入的，这里用递归的方法插入结点
		 */
		if(root == null) {
			root = node;
		} else {
			if(val < root.val) {  // 应该将结点插入左子树
				root.left = insert(root.left, val);
				// 判断插入结点后是否失衡了
				if(height(root.left) - height(root.right) == 2) {
					// 判断插入的节点是插在了左子树的左孩子结点上
					if(val < root.left.val) {  // 插在了左子树的左孩子结点上
						root = leftLeftRotation(root);
					} else {  // 插在了左子树的右孩子结点上
						root = leftRightRotation(root);
					}
				}
			} else if(val > root.val) {
				root.right = insert(root.right, val);
				if(height(root.right) - height(root.left) == 2) {
					if(val > root.right.val) {
						root = rightRightRotation(root);
					} else {
						root = rightLeftRotation(root);
					}
				}
			}
		}
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		return root;
	}

	public TreeNode delete(TreeNode root, int val) {
		if(root == null) {
			return null;
		}
		if(val < root.val) {  // 要删除的结点在树的左边
			root.left = delete(root.left, val);
			// 删除以后，右边可能比左边高，如果高度差等于2，那么调整树
			if(height(root.right) - height(root.left) == 2) {
				TreeNode right = root.right;
				// 相当于在右子树的左孩子节点上插入了一个结点
				if(height(right.left) > height(right.right)) {
					root = rightLeftRotation(root);
				} else {
					root = rightRightRotation(root);
				}
			}
		} else if(val > root.val) {  // 要删除的结点在树的右边
			root.right = delete(root.right, val);
			if(height(root.left) - height(root.right) == 2) {
				TreeNode left = root.left;
				// 相当于在左子树的左孩子位置上插入了一个结点
				if(height(left.right) > height(left.left)) {
					root = leftRightRotation(root);
				} else {
					root = leftLeftRotation(root);
				}
			}
		} else {  // root 结点是要删除的结点
			if(root.left != null && root.right != null) {
				if(height(root.left) > height(root.right)) {
					int maxLeft = maxLeft(root.left);
					root.val = maxLeft;
					root.left = delete(root.left, maxLeft);
				} else {
					int minRight = minRight(root.right);
					root.val = minRight;
					root.right = delete(root.right, minRight);
				}
			} else {
				root = (root.left != null) ? root.left : root.right;
			}
		}
		return root;
	}

	public int minRight(TreeNode root) {
		while(root.left != null) {
			root = root.left;
		}
		return root.val;
	}

	public int maxLeft(TreeNode root) {
		while(root.right != null) {
			root = root.right;
		}
		return root.val;
	}


	public static void main(String[] args) {
		int[] vals = new int[] {1, 2, 3, 4, 5};
		TreeNode root = null;
		AVLTree tree = new AVLTree();
		for(int val : vals) {
			root = tree.insert(root, val);
		}
//		TraverseTree.preOrderTraverseR(root);
		root = tree.delete(root, 1);
		TraverseTree.preOrderTraverseR(root);
	}
}

