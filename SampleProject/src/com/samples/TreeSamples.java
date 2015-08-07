package com.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

		// printTreeLevelOrder(root);
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
		// checkPathSum2();
		// checkSumNumbers();
		checkTreeTraversal();
		//checkLCAInBinaryTree();
		//getKthSmallestInBST();
	}
	
	/**
	 * 
	 * 			_6_
	 * 		   /   \
	 * 		  /     \
	 * 		 2	     8
	 * 		/ \     / \
	 * 	   0   4   7   9
	 * 		  / \
	 *		 3   5
	 */
	public static void getKthSmallestInBST() {
		TreeNode root = new TreeNode(6); TreeNode child6Left = new TreeNode(2); TreeNode child6Right = new TreeNode(8);
		TreeNode child2Left = new TreeNode(0); TreeNode child2Right = new TreeNode(4);
		TreeNode child4Left = new TreeNode(3); TreeNode child4Right = new TreeNode(5);
		TreeNode child8Left = new TreeNode(7); TreeNode child8Right = new TreeNode(9);

		root.left = child6Left; root.right = child6Right;
		child6Left.left = child2Left; child6Left.right = child2Right;
		child2Right.left = child4Left; child2Right.right = child4Right;
		child6Right.left = child8Left; child6Right.right = child8Right;
		printTree(root);
		System.out.println("2: 2nd smallest: " + kthSmallest(root, 2));
		System.out.println("0: 1st smallest: " + kthSmallest(root, 1));
		System.out.println("5: 5th smallest: " + kthSmallest(root, 5));

	}

	
	/**
	 *  	  3 
	 * 		/   \ 
	 * 	   /     \ 
	 *    5       1 
	 *   / \     / \ 
	 *  6   2   0   8 
	 *     / \     
	 *    7   4   
	 */
	public static void checkLCAInBinaryTree(){
		TreeNode root3 = new TreeNode(3); TreeNode node5 = new TreeNode(5); TreeNode node1 = new TreeNode(1);
		TreeNode node6 = new TreeNode(6); TreeNode node2 = new TreeNode(2); TreeNode node0 = new TreeNode(0);
		TreeNode node8 = new TreeNode(8); TreeNode node7 = new TreeNode(7); TreeNode node4 = new TreeNode(4);
		
		root3.left = node5; root3.right = node1;
		node1.left = node0; node1.right = node8;
		node5.left = node6; node5.right = node2;
		node2.left = node7; node2.right = node4;
		
		System.out.println("LCA for 3,4: " + getLCAInBT(root3, root3, node4).val);
		System.out.println("LCA for 0,8: " + getLCAInBT(root3, node0, node8).val);
		System.out.println("LCA for 1,7: " + getLCAInBT(root3, node1, node7).val);
		System.out.println("LCA for 6,4: " + getLCAInBT(root3, node6, node4).val);
		System.out.println("LCA for 3,3: " + getLCAInBT(root3, root3, root3).val);
	}
	
	/**
	 *  	 5 
	 * 		/ \ 
	 * 	   /   \ 
	 *    4     8 
	 *   / \     \ 
	 *  3   11    6 
	 *     / \   / 
	 *    7   2 1
	 * 
	 * Pre-order : 5, 4, 3, 11, 7, 2, 8, 6, 1 
	 * Post-order: 3, 7, 2, 11, 4, 1, 6, 8, 5 
	 * In-order  : 3, 4, 7, 11, 2, 5, 8, 1, 6
	 * 
	 */
	public static void checkTreeTraversal() {
		TreeNode root5 = new TreeNode(5); TreeNode node4 = new TreeNode(4); TreeNode node8 = new TreeNode(8);
		TreeNode node6 = new TreeNode(6); TreeNode node7 = new TreeNode(7);TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1); TreeNode node3 = new TreeNode(3); TreeNode node11 = new TreeNode(11);

		root5.left = node4; root5.right = node8;
		node4.left = node3; node4.right = node11;
		node11.left = node7; node11.right = node2;
		node8.right = node6;
		node6.left = node1;
		printTree(root5);

		System.out.println("PreOrder Traversal: " + preOrderTraversal(root5));
		List<Integer> preOrderResult = new ArrayList<>();
		recursivePreOrderTraversal(root5, preOrderResult);
		System.out.println("Recursive PreOrder Traversal: " + preOrderResult);
		
		System.out.println("PostOrder Traversal: " + postOrderTraversal(root5));
		List<Integer> postOrderResult = new ArrayList<>();
		recursivePostOrderTraversal(root5, postOrderResult);
		System.out.println("Recursive PostOrder Traversal: " + postOrderResult);
		
		System.out.println("InOrder Traversal: " + inOrderTraversal(root5));
		List<Integer> inOrderResult = new ArrayList<>();
		recursiveInOrderTraversal(root5, inOrderResult);
		System.out.println("Recursive InOrder Traversal: " + inOrderResult);
		
	}

	public static void checkSumNumbers() {
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

		System.out.println("result: " + sumNumbers(root));
	}

	/**
	 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1
	 * 
	 */
	public static void checkPathSum2() {
		TreeNode root5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node4_2 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);

		root5.left = node8;
		root5.right = node4;
		node4.left = node11;
		node8.left = node13;
		node8.right = node4_2;
		node11.left = node7;
		node11.right = node2;
		node4_2.left = node5;
		node4_2.right = node1;
		printTree(root5);

		System.out.println("Check Path Sum for 22: " + pathSum(root5, 22));
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
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		List<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		dfs(root, sum - root.val, result, list);
		return result;
	}

	public static void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {

		if (node.left == null && node.right == null && sum == 0) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			result.add(temp);
		}

		// search left nodes
		if (node.left != null) {
			list.add(node.left.val);
			dfs(node.left, sum - node.left.val, result, list);
			list.remove(list.size() - 1);
		}

		if (node.right != null) {
			list.add(node.right.val);
			dfs(node.right, sum - node.right.val, result, list);
			list.remove(list.size() - 1);
		}

	}

	// **************************************************************************************************
	// **************************************************************************************************
	public static int sumNumbers(final TreeNode root) {
		int result = 0;
		if (root == null) {
			return result;
		}

		List<List<TreeNode>> allNodes = new ArrayList<>();
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		dfs(root, nodes, allNodes);

		for (List<TreeNode> list : allNodes) {
			int num = 0;
			int listSize = list.size();
			for (TreeNode node : list) {
				int multiplier = (int) (Math.pow(10, --listSize));
				num = num + (node.val * multiplier);
			}
			result = result + num;
		}

		return result;
	}

	public static void dfs(final TreeNode node, final List<TreeNode> nodes, final List<List<TreeNode>> allNodes) {
		if (node.left == null && node.right == null) {
			List<TreeNode> temp = new ArrayList<TreeNode>();
			temp.addAll(nodes);
			allNodes.add(temp);
		}

		if (node.left != null) {
			nodes.add(node.left);
			dfs(node.left, nodes, allNodes);
			nodes.remove(nodes.size() - 1);
		}

		if (node.right != null) {
			nodes.add(node.right);
			dfs(node.right, nodes, allNodes);
			nodes.remove(nodes.size() - 1);
		}
	}

	public static List<Integer> preOrderTraversal(final TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			result.add(temp.val);

			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
		return result;
	}

	public static void recursivePreOrderTraversal(final TreeNode root, final List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		recursivePreOrderTraversal(root.left, result);
		recursivePreOrderTraversal(root.right, result);
		return;
	}

	public static List<Integer> postOrderTraversal(final TreeNode root){
    	List<Integer> result = new ArrayList<>();
    	if(root == null){
    		return result;
    	}
    	
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	
    	TreeNode prev = null;
    	
    	while(!stack.isEmpty()){
    		TreeNode curr = stack.peek();
    		
    		//Going through tree until the leaf node
    		//checking prev == null for root node
    		if(prev == null || prev.left == curr || prev.right == curr){
    			if(curr.left != null){
    				stack.push(curr.left);
    			} else if(curr.right != null){
    				stack.push(curr.right);
    			} else {
    				stack.pop();
    				result.add(curr.val);
    			}
    		} else if (curr.left == prev) {
    			//Going up the tree from left node and pushing right child to stack if there is one
    			if(curr.right != null){
    				stack.push(curr.right);
    			} else {
    				stack.pop();
    				result.add(curr.val);
    			}
    		} else if (curr.right == prev){
    			stack.pop();
    			result.add(curr.val);
    		}
    		prev = curr;
    	}
    	return result;
    }
	
	public static void recursivePostOrderTraversal(final TreeNode node, final List<Integer> result) {
		if (node != null) {
			recursivePostOrderTraversal(node.left, result);
			recursivePostOrderTraversal(node.right, result);
			result.add(node.val);
		}
		return;
		
	}
	
	public static List<Integer> inOrderTraversal(final TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		
		while(!stack.isEmpty() || temp != null){
			
			if(temp != null){
				stack.push(temp);
				temp = temp.left;
			} else {
				TreeNode t = stack.pop();
				result.add(t.val);
				temp = t.right;
			}
		}
		return result;
	}
	
	public static void recursiveInOrderTraversal(final TreeNode node, List<Integer> result){
    	if(node.left != null){
    		recursiveInOrderTraversal(node.left, result);
    	}
    	result.add(node.val);
    	if(node.right != null){
    		recursiveInOrderTraversal(node.right, result);
    	}
    }
    
    public static TreeNode getLCAInBT(final TreeNode node, final TreeNode p, final TreeNode q) {
    	
    	if(node == null){
    		return null;
    	}
    	if(node == p || node == q){
    		return node;
    	}
    	
    	TreeNode left = getLCAInBT(node.left, p, q);
    	TreeNode right = getLCAInBT(node.right, p, q);
    	
    	if(left!= null && right != null){
    		return node;
    	}
    	
    	return left != null ? left : right;
    }	
    
    public static int kthSmallest(final TreeNode root, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
        	return -1;
        }
        recursiveInOrderTraversal(root, result);
        System.out.println("InOrder Traversal: " + result);
    	return result.get(k-1);
    }
  
}	
