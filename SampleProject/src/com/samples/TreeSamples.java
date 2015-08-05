package com.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeSamples {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode childLeft1 = new TreeNode(2);
		TreeNode childRight1 = new TreeNode(7);

		root.left = childLeft1;
		root.right = childRight1;
		childLeft1.left = new TreeNode(1);
		childLeft1.right = new TreeNode(3);

		childRight1.left = new TreeNode(6);
		childRight1.right = new TreeNode(9);

		printTreeLevelOrder(root);
		// printTree(root);
		// System.out.println("After Inverting...");
		// printTree(invertRecursive(root));
		// createAndCheckIsSameTree();
		// checkLCAinBST();
		// createAndCheckBottomUpTreeLevelOrderTraversal();
		// checkPathSum();
		// createAndCheckIsSymmetric();
		// checkIsBalanced();
		// createAndCheckMaxDepth();
		// createAndCheckMinDepth();
		// createAndCheckLevelOrderTraversal();
	}

	public static void createAndCheckLevelOrderTraversal() {
		// {3,9,20,#,#,15,7}
		TreeNode root = new TreeNode(3);
		TreeNode node20 = new TreeNode(20);

		root.left = new TreeNode(9);
		root.right = node20;

		node20.left = new TreeNode(15);
		node20.right = new TreeNode(7);
		printTree(root);

		List<List<Integer>> result = TreeSamples.levelOrder(root);
		System.out.println("[");
		for (List<Integer> temp : result) {
			System.out.print("[");
			for (int i : temp) {
				System.out.print(" " + i + " ");
			}
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static void createAndCheckMinDepth() {
		TreeNode root = new TreeNode(4);
		TreeNode childLeft1 = new TreeNode(2);
		TreeNode childRight1 = new TreeNode(7);
		TreeNode childLeft1left = new TreeNode(1);
		TreeNode childLeft1right = new TreeNode(3);
		root.left = childLeft1;
		root.right = childRight1;
		childLeft1.left = childLeft1left;
		childLeft1.right = childLeft1right;

		childRight1.left = new TreeNode(6);
		childRight1.right = new TreeNode(9);
		printTree(root);
		System.out.println("Min Depth: " + minDepth(root) + "\n----------------------------------");
		childRight1.left = null;
		childRight1.right = null;
		printTree(root);
		System.out.println("Min Depth: " + minDepth(root) + "\n----------------------------------");
		childLeft1left.left = new TreeNode(5);
		childLeft1right.right = new TreeNode(8);
		printTree(root);
		System.out.println("Min Depth: " + minDepth(root) + "\n----------------------------------");
	}

	public static void createAndCheckMaxDepth() {
		TreeNode root = new TreeNode(4);
		TreeNode childLeft1 = new TreeNode(2);
		TreeNode childRight1 = new TreeNode(7);
		TreeNode childLeft1left = new TreeNode(1);
		TreeNode childLeft1right = new TreeNode(3);
		root.left = childLeft1;
		root.right = childRight1;
		childLeft1.left = childLeft1left;
		childLeft1.right = childLeft1right;

		childRight1.left = new TreeNode(6);
		childRight1.right = new TreeNode(9);
		printTree(root);
		System.out.println("Max Depth: " + maxDepth(root) + "\n----------------------------------");
		childRight1.left = null;
		childRight1.right = null;
		printTree(root);
		System.out.println("Max Depth: " + maxDepth(root) + "\n----------------------------------");
		childLeft1left.left = new TreeNode(5);
		childLeft1right.right = new TreeNode(8);
		printTree(root);
		System.out.println("Max Depth: " + maxDepth(root) + "\n----------------------------------");
	}

	public static void checkIsBalanced() {
		TreeNode root = new TreeNode(4);
		TreeNode childLeft1 = new TreeNode(2);
		TreeNode childRight1 = new TreeNode(7);
		TreeNode childLeft1left = new TreeNode(1);
		TreeNode childLeft1right = new TreeNode(3);
		root.left = childLeft1;
		root.right = childRight1;
		childLeft1.left = childLeft1left;
		childLeft1.right = childLeft1right;

		childRight1.left = new TreeNode(6);
		childRight1.right = new TreeNode(9);
		printTree(root);
		System.out.println("Is Balanced: " + isBalanced(root) + "\n----------------------------------");
		childRight1.left = null;
		childRight1.right = null;
		printTree(root);
		System.out.println("Is Balanced: " + isBalanced(root) + "\n----------------------------------");
		childLeft1left.left = new TreeNode(5);
		childLeft1right.right = new TreeNode(8);
		printTree(root);
		System.out.println("Is Balanced: " + isBalanced(root) + "\n----------------------------------");

	}

	/*
	 * 1 / \ 2 2 / \ / \ 3 4 4 3
	 */
	public static void createAndCheckIsSymmetric() {
		final TreeNode root = new TreeNode(1);
		final TreeNode nodel = new TreeNode(2);
		final TreeNode noder = new TreeNode(2);

		root.left = nodel;
		root.right = noder;

		nodel.left = new TreeNode(3);
		nodel.right = new TreeNode(4);

		noder.left = new TreeNode(4);
		noder.right = new TreeNode(3);

		printTree(root);
		System.out.println("Is Symmetric: " + isSymmetric(root) + "\n-----------------------------");

		TreeNode root2 = new TreeNode(3);
		TreeNode node20 = new TreeNode(20);

		root2.left = new TreeNode(9);
		root2.right = node20;

		node20.left = new TreeNode(15);
		node20.right = new TreeNode(7);
		printTree(root2);
		System.out
				.println("Is Symmetric: " + isSymmetric(root2) + "\n-------------------------------------------------");
		System.out.println("Recursively: ");
		System.out.println("Is Symmetric: " + isSymmetricRecursive(root) + "\n-----------------------------");
		System.out.println("Is Symmetric: " + isSymmetricRecursive(root2) + "\n-----------------------------");

	}

	public static void checkPathSum() {
		TreeNode root = new TreeNode(3);
		TreeNode node20 = new TreeNode(20);

		root.left = new TreeNode(9);
		root.right = node20;

		node20.left = new TreeNode(15);
		node20.right = new TreeNode(7);
		printTree(root);

		System.out.println("has 12: " + hasPathSumRecursive(root, 12));
		System.out.println("has 24: " + hasPathSumRecursive(root, 24));
		System.out.println("has 30: " + hasPathSum(root, 30));
		System.out.println("has 15: " + hasPathSum(root, 15));
		System.out.println("has 38: " + hasPathSum(root, 38));
	}

	public static void createAndCheckBottomUpTreeLevelOrderTraversal() {
		// {3,9,20,#,#,15,7}
		TreeNode root = new TreeNode(3);
		TreeNode node20 = new TreeNode(20);

		root.left = new TreeNode(9);
		root.right = node20;

		node20.left = new TreeNode(15);
		node20.right = new TreeNode(7);
		printTree(root);

		List<List<Integer>> result = TreeSamples.levelOrderBottom(root);
		System.out.println("[");
		for (List<Integer> temp : result) {
			System.out.print("[");
			for (int i : temp) {
				System.out.print(" " + i + " ");
			}
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static void checkLCAinBST() {
		TreeNode root = new TreeNode(6);
		TreeNode child6Left = new TreeNode(2);
		TreeNode child6Right = new TreeNode(8);
		TreeNode child2Left = new TreeNode(0);
		TreeNode child2Right = new TreeNode(4);
		TreeNode child4Left = new TreeNode(3);
		TreeNode child4Right = new TreeNode(5);
		TreeNode child8Left = new TreeNode(7);
		TreeNode child8Right = new TreeNode(9);

		root.left = child6Left;
		root.right = child6Right;
		child6Left.left = child2Left;
		child6Left.right = child2Right;
		child2Right.left = child4Left;
		child2Right.right = child4Right;
		child6Right.left = child8Left;
		child6Right.right = child8Right;
		printTree(root);
		System.out.println("6: LCA for 2 and 6: " + TreeSamples.lowestCommonAncestorInBST(root, child6Left, root).val);
		System.out.println(
				"2: LCA for 0 and 5: " + TreeSamples.lowestCommonAncestorInBST(root, child2Left, child4Right).val);
		System.out.println(
				"6: LCA for 4 and 7: " + TreeSamples.lowestCommonAncestorInBST(root, child2Right, child8Left).val);
		System.out.println(
				"2: LCA for 2 and 3: " + TreeSamples.lowestCommonAncestorInBST(root, child6Left, child4Left).val);
		System.out.println(
				"6: LCA for 3 and 8: " + TreeSamples.lowestCommonAncestorInBST(root, child4Left, child6Right).val);

	}

	public static void createAndCheckIsSameTree() {
		TreeNode root = new TreeNode(4);
		TreeNode childLeft1 = new TreeNode(2);
		TreeNode childRight1 = new TreeNode(7);

		root.left = childLeft1;
		root.right = childRight1;
		childLeft1.left = new TreeNode(1);
		childLeft1.right = new TreeNode(3);

		childRight1.left = new TreeNode(6);
		childRight1.right = new TreeNode(9);
		printTree(root);

		TreeNode root2 = new TreeNode(4);
		TreeNode childLeft2 = new TreeNode(2);
		TreeNode childRight2 = new TreeNode(7);

		root2.left = childLeft2;
		root2.right = childRight2;
		childLeft2.left = new TreeNode(1);
		childLeft2.right = new TreeNode(3);

		childRight2.left = new TreeNode(6);
		childRight2.right = new TreeNode(4);
		System.out.println();
		printTree(root2);

		System.out.println("Same Tree: " + isSameTree(root, root2));

	}

	public static void printTree(final TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		if (root != null) {
			queue.add(root);
		} else {
			return;
		}

		while (!queue.isEmpty()) {
			StringBuffer sbuff = new StringBuffer();
			TreeNode temp = queue.poll();
			if (temp.right != null) {
				sbuff.append("right child-" + temp.right.val + " \t");
				queue.add(temp.right);
			}

			if (temp.left != null) {
				sbuff.append("left child-" + temp.left.val);
				queue.add(temp.left);
			}

			if (temp.right != null || temp.left != null) {
				System.out.println("root-" + temp.val + " : " + sbuff.toString());
			}

		}
	}

	// _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*
	// _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*
	// _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*

	// **************************************************************************************************
	// **************************************************************************************************
	/**
	 * 4 / \ 2 7 / \ / \ 1 3 6 9
	 * 
	 * TO
	 * 
	 * 4 / \ 7 2 / \ / \ 9 6 3 1
	 * 
	 * 
	 */
	public static TreeNode invertTree(final TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);

			TreeNode temp = p.left;
			p.left = p.right;
			p.right = temp;
		}

		return root;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static TreeNode invertRecursive(final TreeNode root) {
		if (root != null) {
			helper(root);
		}

		return root;
	}

	private static void helper(final TreeNode node) {
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;

		if (node.left != null) {
			helper(node.left);
		}
		if (node.right != null) {
			helper(node.right);
		}
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static boolean isSameTree(final TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p != null && q != null) {
			if (p.val == q.val) {
				if (isSameTree(p.right, q.right) && isSameTree(p.left, q.left)) {
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	/**
	 * BST: left < parent <= right
	 */

	public static TreeNode lowestCommonAncestorInBST(final TreeNode node, final TreeNode p, final TreeNode q) {
		TreeNode temp = node;

		if (temp.val > p.val && temp.val <= q.val) {
			return temp;
		} else if (temp.val > p.val && temp.val > q.val) {
			return lowestCommonAncestorInBST(node.left, p, q);
		} else if (temp.val < p.val && temp.val < q.val) {
			return lowestCommonAncestorInBST(node.right, p, q);
		}

		return node;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	/**
	 * {3,9,20,#,#,15,7} is 3 / \ 9 20 / \ 15 7
	 * 
	 * bottom up level order traversal : [ [15,7], [9,20], [3] ]
	 * 
	 */
	public static List<List<Integer>> levelOrderBottom(final TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		current.offer(root);

		List<Integer> numberList = new ArrayList<Integer>();

		while (!current.isEmpty()) {
			TreeNode temp = current.poll();
			numberList.add(temp.val);

			if (temp.left != null) {
				next.offer(temp.left);
			}
			if (temp.right != null) {
				next.offer(temp.right);
			}

			if (current.isEmpty()) {
				current = next;
				next = new LinkedList<TreeNode>();
				result.add(numberList);
				numberList = new ArrayList<Integer>();
			}
		}

		Collections.reverse(result);
		return result;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static boolean hasPathSum(final TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> values = new LinkedList<Integer>();

		nodes.add(root);
		values.add(root.val);

		while (!nodes.isEmpty()) {
			TreeNode temp = nodes.poll();
			int sumVal = values.poll();

			if (temp.left == null && temp.right == null && sum == sumVal) {
				return true;
			}

			if (temp.left != null) {
				nodes.add(temp.left);
				values.add(sumVal + temp.left.val);
			}
			if (temp.right != null) {
				nodes.add(temp.right);
				values.add(sumVal + temp.right.val);
			}
		}

		return false;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static boolean hasPathSumRecursive(final TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.val == sum && (root.left == null && root.right == null)) {
			return true;
		}

		return hasPathSumRecursive(root.left, sum - root.val) || hasPathSumRecursive(root.right, sum - root.val);
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static boolean isSymmetric(final TreeNode root) {
		if (root == null) {
			return true;
		}

		LinkedList<TreeNode> leftTree = new LinkedList<TreeNode>();
		LinkedList<TreeNode> rightTree = new LinkedList<TreeNode>();
		leftTree.add(root.left);
		rightTree.add(root.right);

		while (!leftTree.isEmpty() && !rightTree.isEmpty()) {
			TreeNode left = leftTree.poll();
			TreeNode right = rightTree.poll();
			if ((left == null && right != null) || (left != null && right == null)) {
				return false;
			}
			if (left != null) {
				if (left.val != right.val) {
					return false;
				}
				leftTree.add(left.left);
				rightTree.add(right.right);
				leftTree.add(left.right);
				rightTree.add(right.left);
			}
		}

		return true;
	}
	// **************************************************************************************************
	// **************************************************************************************************

	public static boolean isSymmetricRecursive(final TreeNode root) {
		if (root == null) {
			return true;
		}

		return isSymmetricRecursive(root.left, root.right);
	}

	public static boolean isSymmetricRecursive(final TreeNode left, final TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if ((left == null && right != null) || (left != null && right == null)) {
			return false;
		}

		if (left.val != right.val) {
			return false;
		}

		if (!isSymmetricRecursive(left.left, right.right)) {
			return false;
		} else if (!isSymmetricRecursive(left.right, right.left)) {
			return false;
		}
		return true;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static boolean isBalanced(final TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	public static int getHeight(final TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static int maxDepth(final TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static int minDepth(final TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		current.offer(root);

		List<Integer> levelLeaves = new ArrayList<Integer>();
		while (!current.isEmpty()) {
			TreeNode temp = current.poll();
			levelLeaves.add(temp.val);
			if (temp.left != null) {
				next.offer(temp.left);
			}
			if (temp.right != null) {
				next.offer(temp.right);
			}
			if (current.isEmpty()) {
				current = next;
				result.add(levelLeaves);
				next = new LinkedList<TreeNode>();
				levelLeaves = new ArrayList<Integer>();
			}
		}
		return result;
	}

	public static void printTreeLevelOrder(final TreeNode root) {
		if (root != null) {
			printTreeLevelOrder(Arrays.asList(root));
		}
	}

	public static void printTreeLevelOrder(final List<TreeNode> current) {
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		for (TreeNode temp : current) {
			System.out.print(temp.val + "\t");
			if (temp.left != null) {
				next.add(temp.left);
			}
			if (temp.right != null) {
				next.add(temp.right);
			}
		}
		System.out.println();
		if (!next.isEmpty()) {
			printTreeLevelOrder(next);
		}
	}

	// **************************************************************************************************
	// **************************************************************************************************

}