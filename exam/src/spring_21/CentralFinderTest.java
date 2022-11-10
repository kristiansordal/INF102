package examV21;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class CentralFinderTest {

	public ICentralFinder cf;
	
	@BeforeEach
	void setUp() throws Exception {
		//cf = new CentralFinder();
		cf = new CentralFinderSimple();
	}

	@Test
	void testOneRemoveOdd() {
		cf.add(5);
		cf.add(6);
		cf.add(7);
		
		assertEquals(6, cf.removeCentralValue());
	}

	@Test
	void testOneRemoveEven() {
		cf.add(5);
		cf.add(6);
		cf.add(7);
		cf.add(8);
		
		int center = cf.removeCentralValue();
		assertTrue(center==6 || center==7);
	}

	@Test
	void testRemoveAllCentralValue() {
		cf.add(75);
		cf.add(43);
		cf.add(-18);
		cf.add(22);
		cf.add(43);

		assertEquals(43, cf.removeCentralValue());

		int center = cf.removeCentralValue();
		assertTrue(center==22 || center==43);
		if(center==22) {
			assertEquals(43, cf.removeCentralValue());			
		}else {
			assertEquals(22, cf.removeCentralValue());						
		}

		center = cf.removeCentralValue();
		assertTrue(center==-18 || center==75);
		if(center==-18) {
			assertEquals(75, cf.removeCentralValue());			
		}else {
			assertEquals(-18, cf.removeCentralValue());						
		}

	}

	@Test
	void testRemoveFromEmpty() {
		assertThrows(NoSuchElementException.class, cf::removeCentralValue, "");
	}

	@Test
	void testSize() {
		cf.add(75);
		cf.add(43);
		cf.add(-18);
		cf.add(22);
		assertEquals(4, cf.size());
		cf.removeCentralValue();
		assertEquals(3, cf.size());
		cf.add(99);
		cf.add(57);
		assertEquals(5, cf.size());
	}

}
