package one.symbol.table;

/**
 * 有序泛型符号表API
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
	 * 小于等于key的最大键
	 * 
	 * @param key
	 * @return
	 */
	public abstract Key floor(Key key);

	/**
	 * 大于等于key的最小键
	 * 
	 * @param key
	 * @return
	 */
	public abstract Key ceiling(Key key);

	/**
	 * 小于key的键的数量
	 * 
	 * @param key
	 * @return
	 */
	public abstract int rank(Key key);

	/**
	 * 排名为k的键
	 * 
	 * @param k
	 * @return
	 */
	public abstract Key select(int k);

	public abstract void deleteMin();

	public abstract void deleteMax();

	/**
	 * [lo,hi]之间键的数量
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	public abstract int size(Key lo, Key hi);

	/**
	 * [lo,hi]之间键的集合，已排序
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	public abstract Iterable<Key> keys(Key lo, Key hi);

	public abstract Iterable<Key> keys();

}
