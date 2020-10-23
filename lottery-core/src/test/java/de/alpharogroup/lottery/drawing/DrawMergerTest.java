package de.alpharogroup.lottery.drawing;

import java.util.Map;

import org.testng.annotations.Test;

import de.alpharogroup.collections.map.MapFactory;
import junit.framework.TestCase;

/**
 * The unit test class for the class {@link DrawMerger}
 */
public class DrawMergerTest extends TestCase
{

	/**
	 * Test method for {@link DrawMerger#mergeDrawings(int, int, int, int, Map)}
	 */
	@Test
	public void testMergeDrawings()
	{
		// actual return types
		Map<Integer, Integer> mergeDrawings;
		// actual count and ex
		long actual;
		long expected;
		// declare parameters
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;
		Map<Integer, Integer> numberCounterMap;
		// new scenario...
		// set arguments
		maxNumbers = 5;
		minVolume = 1;
		maxVolume = 49;
		drawCount = 1000;
		numberCounterMap = MapFactory.newNumberCounterMap(minVolume, maxVolume);
		mergeDrawings = DrawMerger.mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount,
			numberCounterMap);
		assertNotNull(mergeDrawings);
		// summarize all count values
		actual = mergeDrawings.values().stream().reduce(0, Integer::sum);
		expected = 5000;
		assertEquals(actual, expected);
	}

}
