package one.symbol.table;

import java.util.HashSet;
import java.util.Set;

/**
 * �������������˳�����
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
	 * keyƥ��ɹ������滻value ��ƥ��ʧ�ܣ����µļ�ֵ�Բ嵽����ͷ
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		//��������ֵ����ɾ��key
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

	// FIXME ÿ�λ�ȡ�����С��Ҫ����һ��ô��
	// sizeӦ��Ҳ������put��delete������д�߼�
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
		//FIXME ������hashset��ʵ��Iterable����ô��arraylist?
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
	 * ��ʱ�Ե�ɾ��
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		/*
		 * 1. ɾ��һ���ڵ㣬���ýڵ�ĸ��ڵ��nextָ��ýڵ����һ�� �� node.parent.next = node.next; 2.
		 * node=null; ����ǵ�һ���ڵ���Ҫɾ����ֱ��first = first.next; 3.
		 * ��������һ���ڵ���Ҫɾ�������ڵ�1�����
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
