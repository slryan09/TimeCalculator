package TimeCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calc;

	@Before
	public void setUp() throws Exception {
		calc = Calculator.instanceOf();
		calc.resetTime();
	}

	@Test
	public void testInstanceOf() {
		assertNotNull(Calculator.instanceOf());
		assertNotNull(calc);
	}

	@Test
	public void testAddTime() {
		try {
			calc.addTime(0, 0, -5);
			fail();
		} catch (IllegalArgumentException e) {
			// GOOD
		}

		try {
			calc.addTime(0, -5, 0);
			fail();
		} catch (IllegalArgumentException e) {
			// GOOD
		}

		try {
			calc.addTime(-5, 0, 0);
			fail();
		} catch (IllegalArgumentException e) {
			// GOOD
		}

		calc.addTime(1, 30, 30);
		assertEquals("01:30:30", calc.toString());
		calc.addTime(0, 0, 30);
		assertEquals("01:31:00", calc.toString());
		calc.addTime(0, 29, 00);
		assertEquals("02:00:00", calc.toString());
		calc.addTime(1, 0, 0);
		assertEquals("03:00:00", calc.toString());
		calc.addTime(1, 75, 75);
		assertEquals("05:16:15", calc.toString());
	}

	@Test
	public void testReset() {
		calc.addTime(1, 30, 30);
		assertEquals("01:30:30", calc.toString());
		calc.resetTime();
		assertEquals("00:00:00", calc.toString());

	}

}
