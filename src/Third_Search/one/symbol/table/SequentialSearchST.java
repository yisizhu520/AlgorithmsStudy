package one.symbol.table;

import java.util.HashSet;
import java.util.Set;

/**
 * 基于无序链表的顺序查找
 * 
 * @author WangJun
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {

	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			super();
			this.key = key;
			this.val = val;
			this.next = next;
		}

	}

	private Node first;

	public Value get(Key key) {
		Node node = first;
		while (node != null) {
			if (node.key.equals(key))
				return node.val;
			else
				node = node.next;
		}
		return null;
	}

	/**
	 * key匹配成功，则替换value 都匹配失败，则将新的键值对插到链表开头
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		//如果插入空值，则删除key
		if(value==null){
			delete(key);
		}
		Node node = first;
		while (node != null) {
			if (node.key.equals(key)) {
				node.val = value;
				return;
			} else {
				node = node.next;
			}
		}
		Node x = new Node(key, value, first);
		first = x;
	}

	// FIXME 每次获取链表大小都要遍历一遍么？
	// size应该也可以在put和delete方法里写逻辑
	public int size() {
		Node node = first;
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

	/**
	 * @return
	 */
	public Iterable<Key> keys() {
		//FIXME 这里用hashset来实现Iterable合适么？arraylist?
		Set<Key> keyset = new HashSet<>();
//		List<Key> keyset = new ArrayList<>();
		Node node = first;
		while (node != null) {
			keyset.add(node.key);
			node = node.next;
		}
		return keyset;
	}

	/**
	 * 即时性的删除
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		/*
		 * 1. 删除一个节点，将该节点的父节点的next指向该节点的下一个 即 node.parent.next = node.next; 2.
		 * node=null; 如果是第一个节点需要删除，直接first = first.next; 3.
		 * 如果是最后一个节点需要删除，属于第1种情况
		 */

		Node node = first;
		if (node.key.equals(key)) {
			first = first.next;
			node = null;
			return;
		} else {
			Node parent = node;
			node = node.next;
			while (node != null) {
				if (node.key.equals(key)) {
					parent.next = node.next;
					node = null;
					return;
				} else {
					parent = node;
					node = node.next;
				}

			}
		}

	}

}
