package de.alpharogroup.lottery.drawing;

import java.util.Map;

import de.alpharogroup.lottery.drawings.DrawModelBean;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import de.alpharogroup.collections.map.MapFactory;

/**
 * The unit test class for the class {@link DrawMerger}
 */
public class DrawMergerTest
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
		mergeDrawings = DrawMerger.mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount,
				mergeDrawings);
		assertNotNull(mergeDrawings);
		// summarize all count values
		actual = mergeDrawings.values().stream().reduce(0, Integer::sum);
		expected = 10000;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link DrawMerger#mergeDrawings(DrawModelBean, Map)}
	 */
	@Test
	public void testMergeDrawingsWithDrawModelBean()
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
		mergeDrawings = DrawMerger.mergeDrawings(DrawModelBean.builder()
				.maxNumbers(maxNumbers)
				.minVolume(minVolume)
				.maxVolume(maxVolume)
				.drawCount(drawCount)
				.build(),
				numberCounterMap);
		assertNotNull(mergeDrawings);
		// summarize all count values
		actual = mergeDrawings.values().stream().reduce(0, Integer::sum);
		expected = 5000;
		assertEquals(actual, expected);
		mergeDrawings = DrawMerger.mergeDrawings(DrawModelBean.builder()
						.maxNumbers(maxNumbers)
						.minVolume(minVolume)
						.maxVolume(maxVolume)
						.drawCount(drawCount)
						.shuffle(true)
						.build(),
				mergeDrawings);
		assertNotNull(mergeDrawings);
		// summarize all count values
		actual = mergeDrawings.values().stream().reduce(0, Integer::sum);
		expected = 10000;
		assertEquals(actual, expected);
	}

}
