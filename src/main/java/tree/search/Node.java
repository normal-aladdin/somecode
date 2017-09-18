package tree.search;

import java.util.List;

public class Node {
	private String value;
	private List<Node> children;

	public Node(String value, List<Node> children) {
		this.value = value;
		this.children = children;
	}

	public Node() {
	}

	public String value() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void addChild(Node node) {
		if (node == null) {
			return;
		}
		this.children.add(node);
	}

	public List<Node> getChildren() {
		return this.children;
	}
}
