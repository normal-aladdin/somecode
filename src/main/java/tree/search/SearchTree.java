package tree.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class SearchTree {
	public static void main(String[] args) {
		Node root = new Node("c0",new ArrayList<Node>());
		for (int i = 1; i < 5; i++) {
			Node child = new Node("c1-" + i,new ArrayList<Node>());
			root.addChild(child);
			for (int j = 0; j < 4; j++) {
				Node child1 = new Node("c2-" + i + "-" + j,null);
				child.addChild(child1);
			}
		}
		deepSearch(root);
		breadSearch(root);
	}

	private static void breadSearch(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		List<Node> result = new ArrayList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node first = queue.poll();
			result.add(first);
			List<Node> children = first.getChildren();
			if (children != null && children.size() > 0) {
				for (int i = 0; i < children.size(); i++) {
					queue.add(children.get(i));
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			builder.append(result.get(i).value()).append(" ");
		}
		System.out.println(builder.toString());
	}

	private static void deepSearch(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		List<Node> result = new ArrayList<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node top = stack.pop();
			result.add(top);
			List<Node> children = top.getChildren();
			if (children != null && children.size() > 0) {
				for (int i = children.size() - 1; i >= 0; i--) {
					stack.push(children.get(i));
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			builder.append(result.get(i).value()).append(" ");
		}
		System.out.println(builder.toString());
	}
}
