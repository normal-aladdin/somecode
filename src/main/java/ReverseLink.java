import domain.Link;
import domain.Node;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class ReverseLink {
	public static void main(String[] args) {
		Link link = createLink(10);
		printLink(link);
		reverseByLoop(link);
		reverseByStack(link);
		reverseByQueue(link);
	}

	public static void reverseByQueue(Link link) {
		if (link == null) {
			System.out.println("链表为空......");
			return;
		}
		Node head = link.getHead();
		if (head == null) {
			System.out.println("链表为空......");
			return;
		}
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		for (Node current = head; current != null; current = current.getNext()) {
			queue.add(current);
		}
		Node pre = queue.poll();
		pre.setNext(null);
		while (!queue.isEmpty()) {
			Node next = queue.poll();
			next.setNext(pre);
			pre = next;
		}
		link.setHead(pre);
		printLink(link);
	}

	public static void reverseByStack(Link link) {
		if (link == null) {
			System.out.println("链表为空......");
			return;
		}
		Node head = link.getHead();
		if (head == null) {
			System.out.println("链表为空......");
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		for (Node current = head; current != null; current = current.getNext()) {
			stack.push(current);
		}
		Node top = stack.pop();
		link.setHead(top);
		Node tail = top;
		while (!stack.isEmpty()) {
			top = stack.pop();
			tail.setNext(top);
			tail = top;
		}
		tail.setNext(null);
		printLink(link);
	}

	public static void reverseByLoop(Link link) {
		if (link == null) {
			System.out.println("链表为空......");
			return;
		}
		Node head = link.getHead();
		if (head == null) {
			System.out.println("链表为空......");
			return;
		}
		Node pre = head;
		Node current = head.getNext();
		pre.setNext(null);
		for (Node next;current != null;) {
			next = current.getNext();
			current.setNext(pre);
			pre = current;
			current = next;
		}
		link.setHead(pre);
		printLink(link);
	}

	public static Link createLink(int size) {
		Link link = new Link(null);
		Node last = new Node(0 ,null);
		link.setHead(last);
		for (int i = 1; i < size; i++) {
			Node node = new Node(i ,null);
			last.setNext(node);
			last = node;
		}
		return link;
	}

	public static void printLink(Link link) {
		StringBuilder builder = new StringBuilder();
		for (Node current = link.getHead(); current != null; current = current.getNext()) {
			builder.append(current.getValue()).append(" ");
		}
		System.out.println(builder.toString());
	}
}
