package de.alpharogroup.lottery.drawing;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Map;

import de.alpharogroup.comparators.ComparatorFactory;
import de.alpharogroup.random.DefaultSecureRandom;

/**
 * A factory class for creating {@link Comparator} objects for sort lottery numbers
 */
public final class MostDrawnComparatorFactory
{

	/**
	 * Factory method for create a comparator for sort the lottery numbers
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param drawCount
	 *            the draw count defines how many times to draw numbers
	 * @param mostDrawn
	 *            the flag that indicates if the most drawn numbers should be taken if true,
	 *            otherwise the reverse order will be taken
	 * @param paranoid
	 *            the flag paranoid indicates to create a custom comparator from the counter map and
	 *            define a random defined order to draw if true, otherwise the flag mostDrawn will
	 *            define the order to draw
	 * @param numberCounterMap
	 *            the counter map for generate statistics of the drawn lottery numbers
	 * @return the comparator for sort the lottery numbers
	 */
	public static Comparator<Integer> newMostDrawnComparator(int maxNumbers, int minVolume,
		int maxVolume, int drawCount, boolean mostDrawn, boolean paranoid,
		Map<Integer, Integer> numberCounterMap)
	{
		return newMostDrawnComparator(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn,
			paranoid, numberCounterMap, DefaultSecureRandom.get());
	}

	/**
	 * Factory method for create a comparator for sort the lottery numbers
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
	 * @return the comparator for sort the lottery numbers
	 */
	public static Comparator<Integer> newMostDrawnComparator(int maxNumbers, int minVolume,
		int maxVolume, int drawCount, Map<Integer, Integer> numberCounterMap)
	{
		return MostDrawnComparatorFactory.newMostDrawnComparator(maxNumbers, minVolume, maxVolume,
			drawCount, numberCounterMap, DefaultSecureRandom.get());
	}

	/**
	 * Factory method for create a comparator for sort the lottery numbers
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the comparator for sort the lottery numbers
	 */
	public static Comparator<Integer> newMostDrawnComparator(int maxNumbers, int minVolume,
		int maxVolume, int drawCount, Map<Integer, Integer> numberCounterMap,
		SecureRandom secureRandom)
	{
		return MostDrawnComparatorFactory.newMostDrawnComparator(
			DrawMerger.mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap),
			false, true, secureRandom);
	}

	/**
	 * Factory method for create a comparator for sort the lottery numbers
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param drawCount
	 *            the draw count defines how many times to draw numbers
	 * @param mostDrawn
	 *            the flag that indicates if the most drawn numbers should be taken if true,
	 *            otherwise the reverse order will be taken
	 * @param paranoid
	 *            the flag paranoid indicates to create a custom comparator from the counter map and
	 *            define a random defined order to draw if true, otherwise the flag mostDrawn will
	 *            define the order to draw
	 * @param numberCounterMap
	 *            the counter map for generate statistics of the drawn lottery numbers
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the comparator for sort the lottery numbers
	 */
	public static Comparator<Integer> newMostDrawnComparator(int maxNumbers, int minVolume,
		int maxVolume, int drawCount, boolean mostDrawn, boolean paranoid,
		Map<Integer, Integer> numberCounterMap, SecureRandom secureRandom)
	{
		return MostDrawnComparatorFactory.newMostDrawnComparator(
			DrawMerger.mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap),
			paranoid, mostDrawn, secureRandom);
	}

	/**
	 * Factory method for create a comparator for sort the lottery numbers
	 *
	 * @param numberCounterMap
	 *            the counter map for generate statistics of the drawn lottery numbers
	 * @param paranoid
	 *            the flag paranoid indicates to create a custom comparator from the counter map and
	 *            define a random defined order to draw if true, otherwise the flag mostDrawn will
	 *            define the order to draw
	 * @param mostDrawn
	 *            the flag that indicates if the most drawn numbers should be taken if true,
	 *            otherwise the reverse order will be taken
	 * @return the comparator for sort the lottery numbers
	 */
	public static Comparator<Integer> newMostDrawnComparator(Map<Integer, Integer> numberCounterMap,
		boolean paranoid, boolean mostDrawn)
	{
		return newMostDrawnComparator(numberCounterMap, paranoid, mostDrawn,
			DefaultSecureRandom.get());
	}

	/**
	 * Factory method for create a comparator for sort the lottery numbers
	 *
	 * @param numberCounterMap
	 *            the counter map for generate statistics of the drawn lottery numbers
	 * @param paranoid
	 *            the flag paranoid indicates to create a custom comparator from the counter map and
	 *            define a random defined order to draw if true, otherwise the flag mostDrawn will
	 *            define the order to draw
	 * @param mostDrawn
	 *            the flag that indicates if the most drawn numbers should be taken if true,
	 *            otherwise the reverse order will be taken
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the comparator for sort the lottery numbers
	 */
	public static Comparator<Integer> newMostDrawnComparator(Map<Integer, Integer> numberCounterMap,
		boolean paranoid, boolean mostDrawn, SecureRandom secureRandom)
	{
		Comparator<Integer> mostDrawnComparator;
		if (paranoid)
		{
			mostDrawnComparator = ComparatorFactory.newRandomMapValuesComparator(numberCounterMap,
				secureRandom);
		}
		else
		{
			mostDrawnComparator = mostDrawn ? Comparator.reverseOrder() : Comparator.naturalOrder();
		}
		return mostDrawnComparator;
	}

	private MostDrawnComparatorFactory()
	{
	}


}
