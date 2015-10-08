package one.symbol.table;

/**
 * �����ͷ��ű�API
 * 
 * @author WangJun
 *
 */
public abstract class OrderST<Key extends Comparable<Key>, Value> {

	public OrderST() {
	};

	public abstract void put(Key key, Value val);

	public abstract Value get(Key key);

	public abstract void delete(Key key);

	public abstract boolean contains(Key key);

	public abstract boolean isEmpty();

	public abstract int size();

	public abstract Key min();

	public abstract Key max();

	/**
	 * С�ڵ���key������
	 * 
	 * @param key
	 * @return
	 */
	public abstract Key floor(Key key);

	/**
	 * ���ڵ���key����С��
	 * 
	 * @param key
	 * @return
	 */
	public abstract Key ceiling(Key key);

	/**
	 * С��key�ļ�������
	 * 
	 * @param key
	 * @return
	 */
	public abstract int rank(Key key);

	/**
	 * ����Ϊk�ļ�
	 * 
	 * @param k
	 * @return
	 */
	public abstract Key select(int k);

	public abstract void deleteMin();

	public abstract void deleteMax();

	/**
	 * [lo,hi]֮���������
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	public abstract int size(Key lo, Key hi);

	/**
	 * [lo,hi]֮����ļ��ϣ�������
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	public abstract Iterable<Key> keys(Key lo, Key hi);

	public abstract Iterable<Key> keys();

}
