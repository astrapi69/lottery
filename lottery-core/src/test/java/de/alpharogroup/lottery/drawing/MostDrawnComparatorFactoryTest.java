package de.alpharogroup.lottery.drawing;

import static org.testng.Assert.assertNotNull;

import java.util.Comparator;
import java.util.Map;

import org.testng.annotations.Test;

import de.alpharogroup.collections.map.MapFactory;

/**
 * The unit test class for the class {@link MostDrawnComparatorFactory}
 */
public class MostDrawnComparatorFactoryTest
{

	/**
	 * Test method for
	 * {@link MostDrawnComparatorFactory#newMostDrawnComparator(int, int, int, int, boolean, boolean, Map)}
	 */
	@Test
	public void testNewMostDrawnComparator()
	{
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;
		boolean mostDrawn;
		boolean paranoid;
		Map<Integer, Integer> numberCounterMap;
		Comparator<Integer> comparator;
		// new scenario...

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		mostDrawn = true;
		paranoid = false;
		numberCounterMap = MapFactory.newNumberCounterMap(minVolume, maxVolume);

		comparator = MostDrawnComparatorFactory.newMostDrawnComparator(maxNumbers, minVolume,
			maxVolume, drawCount, mostDrawn, paranoid, numberCounterMap);
		assertNotNull(comparator);
	}

}
