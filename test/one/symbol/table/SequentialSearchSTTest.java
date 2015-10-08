package one.symbol.table;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class SequentialSearchSTTest {
	
	one.symbol.table.SequentialSearchST<Integer, String> st = new one.symbol.table.SequentialSearchST<>();
	
	

	@Test
	public void testPutAndGet() {
		st.put(1, "a");
		st.put(2, "b");
		st.put(3, "c");
		st.put(4, "d");
		assertEquals("a", st.get(1));
		assertEquals("b", st.get(2));
		assertEquals("c", st.get(3));
		assertEquals("d", st.get(4));
	}
	
	@Test
	public void testSize(){
		st.put(1, "a");
		st.put(2, "b");
		st.put(3, "c");
		st.put(4, "d");
		assertEquals(4, st.size());
	}
	
	@Test
	public void testDelete(){
		st.put(1, "a");
		st.put(2, "b");
		st.put(3, "c");
		st.put(4, "d");
		st.delete(1);
		assertEquals(null, st.get(1));
		st.delete(3);
		assertEquals(null, st.get(3));
		st.delete(4);
		assertEquals(null, st.get(4));
	}
	
	@Test
	public void testKeys(){
		st.put(1, "a");
		st.put(2, "b");
		st.put(3, "c");
		st.put(4, "d");
		Iterator<Integer> it = st.keys().iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			System.out.print(" "+key);
		}
		//不要为了省事而犯这种低级错误！keyset.iterator()会返回一个新的对象
//		while (keyset.iterator().hasNext()) {
//			Integer key = keyset.iterator().next();
//			System.out.print(" "+key);
//		}
	}
	
	

}
