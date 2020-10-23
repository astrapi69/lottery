package de.alpharogroup.lottery.drawing;

import java.util.Map;

public final class DrawMerger
{
	/**
	 * Merges several drawings of lottery numbers from the given arguments
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param drawCount
	 *            the draw count defines how many times to draw numbers
	 * @param numberCounterMap
	 *            the counter map for generate statistics of the drawn lottery numbers
	 * @return the map with the merged lottery numbers
	 */
	public static Map<Integer, Integer> mergeDrawings(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, Map<Integer, Integer> numberCounterMap)
	{
		for (int i = 0; i < drawCount; i++)
		{
			DrawLotteryNumbersFactory.draw(maxNumbers, minVolume, maxVolume)
				.forEach(key -> numberCounterMap.merge(key, 1, Integer::sum));
		}
		return numberCounterMap;
	}

	private DrawMerger()
	{
	}
}
