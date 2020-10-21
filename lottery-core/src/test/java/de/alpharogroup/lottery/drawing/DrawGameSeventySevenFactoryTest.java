package de.alpharogroup.lottery.drawing;

import de.alpharogroup.math.MathExtensions;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * The unit test class for the class {@link DrawGameSeventySevenFactory}
 */
public class DrawGameSeventySevenFactoryTest
{
	/**
	 * Test method for {@link DrawGameSeventySevenFactory#drawGameSeventySeven()}
	 */
	@Test
	public void testDrawGameSeventySeven()
	{
		int actual;
		actual = DrawGameSeventySevenFactory.drawGameSeventySeven();
		assertTrue(MathExtensions.isBetween(0, 9999999, actual, true, true));
	}

	/**
	 * Test method for {@link DrawGameSeventySevenFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawGameSeventySevenFactory.class);
	}

}
