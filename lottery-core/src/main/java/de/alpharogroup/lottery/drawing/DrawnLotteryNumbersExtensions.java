/**
 * Commercial License
 *
 * Copyright (C) 2015 Asterios Raptis - All Rights Reserved
 *
 * Proprietary and confidential
 *
 * Unauthorized copying of this software and its files,
 * via any medium is strictly prohibited
 *
 * Written by Asterios Raptis
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.alpharogroup.lottery.drawing;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.map.MapExtensions;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.comparators.ComparatorFactory;
import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomPrimitivesExtensions;
import lombok.experimental.UtilityClass;

/**
 * The class {@link DrawnLotteryNumbersExtensions} provides utility methods to draw lottery numbers
 * with different algorithms
 */
@UtilityClass
public final class DrawnLotteryNumbersExtensions
{

	/**
	 * Draws a super number that is not in the given already drawn numbers {@link Set}.
	 *
	 * @param alreadyDrawnNumbers
	 *            the already drawn numbers
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the drawn super number
	 */
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int volume)
	{
		int superNumber = -1;
		boolean breakout = false;
		while (!breakout)
		{
			superNumber = RandomPrimitivesExtensions.getRandomIntBetween(1, volume);
			if (!alreadyDrawnNumbers.contains(superNumber))
			{
				breakout = true;
			}
		}
		return superNumber;
	}

	/**
	 * Draws a super number that is not in the given already drawn numbers {@link Set}.
	 *
	 * @param alreadyDrawnNumbers
	 *            the already drawn numbers
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @return the drawn super number
	 */
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int minVolume,
		int maxVolume)
	{
		int superNumber = -1;
		boolean breakout = false;
		while (!breakout)
		{
			superNumber = RandomPrimitivesExtensions.randomIntBetween(minVolume, maxVolume, true,
				true);
			if (!alreadyDrawnNumbers.contains(superNumber))
			{
				breakout = true;
			}
		}
		return superNumber;
	}

	/**
	 * Draw the number of the game seventy seven
	 *
	 * @return the drawn number of the game seventy seven
	 */
	public static int drawGameSeventySeven()
	{
		return RandomPrimitivesExtensions.randomIntBetween(0, 9999999, true, true);
	}

	/**
	 * Draw of lottery numbers.
	 *
	 * @param maxNumbers
	 *            the max number to draw
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the sets the
	 */
	public static Set<Integer> draw(int maxNumbers, int volume)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();

		int cnt = 0;

		while (cnt < maxNumbers)
		{
			final int num = RandomPrimitivesExtensions.getRandomIntBetween(1, volume);

			if (!numbers.contains(num))
			{
				numbers.add(num);
				++cnt;
			}
		}
		return numbers;
	}

	/**
	 * Draw of lottery numbers.
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> draw(int maxNumbers, int minVolume, int maxVolume)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();

		int cnt = 0;

		while (cnt < maxNumbers)
		{
			final int num = RandomPrimitivesExtensions.randomIntBetween(minVolume, maxVolume, true,
				true);

			if (!numbers.contains(num))
			{
				numbers.add(num);
				++cnt;
			}
		}
		return numbers;
	}

	/**
	 * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
	 * times and return a new set.
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param drawCount
	 *            the draw count defines how many times to draw numbers
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
		int drawCount)
	{
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, true);
	}

	/**
	 * Draw of paranoid lottery numbers from given drawCount and take the numbers that are drawn the
	 * most times and return a new set.
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param drawCount
	 *            the draw count defines how many times to draw numbers
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawParanoidFromMultiMap(int maxNumbers, int minVolume,
		int maxVolume, int drawCount)
	{
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount,
			RandomPrimitivesExtensions.randomBoolean(), true);
	}

	/**
	 * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
	 * times and return a new set.
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
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, boolean mostDrawn)
	{
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, false);
	}

	/**
	 * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
	 * times and return a new set.
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
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, boolean mostDrawn, boolean paranoid)
	{
		Map<Integer, Integer> numberCounterMap = DrawnLotteryNumbersFactory
			.newNumberCounterMap(minVolume, maxVolume);
		for (int i = 0; i < drawCount; i++)
		{
			DrawnLotteryNumbersExtensions.draw(maxNumbers, minVolume, maxVolume)
				.forEach(key -> numberCounterMap.merge(key, 1, Integer::sum));
		}
		Comparator<Integer> mostDrawnComparator;
		if (paranoid)
		{
			List<Integer> numberCounterValues = ListFactory
				.newArrayList(SetFactory.newTreeSet(numberCounterMap.values()));
			Collections.shuffle(numberCounterValues, DefaultSecureRandom.get());
			mostDrawnComparator = ComparatorFactory.newComparator(numberCounterValues);
		}
		else
		{
			mostDrawnComparator = mostDrawn ? Comparator.reverseOrder() : Comparator.naturalOrder();
		}
		return resolveLotteryNumbers(maxNumbers, mostDrawnComparator, numberCounterMap);
	}

	/**
	 * Resolves the lottery numbers from the given number counter map in the order from the given
	 * comparator limited to maxNumbers
	 *
	 * @param maxNumbers
	 *            the max numbers
	 * @param mostDrawn
	 *            the comparator that defines in which order to take the drawn numbers. For instance
	 *            if you want to have the reverse order you can simply give the
	 *            <code>Comparator.reverseOrder()</code> or you can define your custom order
	 * @param numberCounterMap
	 *            the number counter map
	 * @return the sets of the lottery numbers
	 */
	public static Set<Integer> resolveLotteryNumbers(int maxNumbers, Comparator<Integer> mostDrawn,
		Map<Integer, Integer> numberCounterMap)
	{
		List<Map.Entry<Integer, Integer>> sortByValue = MapExtensions
			.sortByValueAsList(numberCounterMap, mostDrawn);

		List<Integer> newLotteryNumbers = sortByValue.stream().map(Map.Entry::getKey)
			.limit(maxNumbers).collect(Collectors.toList());
		return SetFactory.newTreeSet(newLotteryNumbers);
	}

	/**
	 * This draw algorithm simulates the real world.
	 *
	 * @param maxNumbers
	 *            the max number to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the sets the
	 */
	public static Set<Integer> drawDefaultAlgorithm(int maxNumbers, int minVolume, int maxVolume)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();
		ArrayList<Integer> rangeList = new ArrayList<>(
			ListFactory.newRangeList(minVolume, maxVolume));

		final SecureRandom sr = DefaultSecureRandom.get();
		int cnt = 0;

		while (cnt < maxNumbers)
		{
			Collections.shuffle(rangeList, sr);
			final int index = RandomPrimitivesExtensions.randomIntBetween(0, rangeList.size(), true,
				false);
			Integer drawnNumber = rangeList.get(index);
			if (!numbers.contains(drawnNumber))
			{
				numbers.add(drawnNumber);
				++cnt;
			}
		}
		return numbers;
	}

}
