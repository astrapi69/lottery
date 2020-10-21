package de.alpharogroup.lottery.drawing;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.math.MathExtensions;
import org.testng.annotations.Test;

import java.util.Set;

import static org.junit.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DrawSuperNumbersFactoryTest
{

	/**
	 * Test method for {@link DrawSuperNumbersFactory#drawSuperNumber(Set, int)}.
	 */
	@Test
	public void testDrawSuperNumber()
	{
		Set<Integer> alreadyDrawnNumbers = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		int superNumber = DrawSuperNumbersFactory.drawSuperNumber(alreadyDrawnNumbers, 49);
		assertFalse(alreadyDrawnNumbers.contains(superNumber));
		assertTrue(MathExtensions.isBetween(1, 49, superNumber, true, true));
	}

}
