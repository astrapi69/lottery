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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import de.alpharogroup.collections.map.MapExtensions;
import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.lottery.drawings.DrawModelBean;
import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomBooleanFactory;

/**
 * The factory class {@link DrawMultiMapLotteryNumbersFactory} provides factory methods to draw
 * lottery numbers with different algorithms and {@link SecureRandom} argument for custom randomize
 * draws, like for a special draw date we could initialize the {@link SecureRandom} with the draw
 * date. It has provides methods for merge several multi maps
 */
public final class DrawMultiMapLotteryNumbersFactory
{

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
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount,
			DefaultSecureRandom.get());
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
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn,
			DefaultSecureRandom.get());
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
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, paranoid,
			DefaultSecureRandom.get());
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, boolean mostDrawn, boolean paranoid, SecureRandom secureRandom)
	{
		return drawFromMultiMap(DrawModelBean.builder()
				.maxNumbers(maxNumbers)
				.minVolume(minVolume)
				.maxVolume(maxVolume)
				.drawCount(drawCount)
				.mostDrawn(mostDrawn)
				.paranoid(paranoid)
				.secureRandom(secureRandom)
				.build());
	}

	/**
	 * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
	 * times and return a new set.
	 *
	 * @param drawModelBean
	 *            the bean that holds the data how to draw the numbers
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawFromMultiMap(DrawModelBean drawModelBean)
	{
		Map<Integer, Integer> numberCounterMap = MapFactory.newNumberCounterMap(drawModelBean.getMinVolume(),
				drawModelBean.getMaxVolume());
		Comparator<Integer> mostDrawnComparator = MostDrawnComparatorFactory.newMostDrawnComparator(
				drawModelBean, numberCounterMap);
		return resolveLotteryNumbers(drawModelBean.getMaxNumbers(), mostDrawnComparator, numberCounterMap);
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, boolean mostDrawn, SecureRandom secureRandom)
	{
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, false,
			secureRandom);
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, SecureRandom secureRandom)
	{
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, true, false,
			secureRandom);
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
		return drawParanoidFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount,
			DefaultSecureRandom.get());
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawParanoidFromMultiMap(int maxNumbers, int minVolume,
		int maxVolume, int drawCount, SecureRandom secureRandom)
	{
		return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount,
			RandomBooleanFactory.randomBoolean(), true, secureRandom);
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
	 * Resolves the lottery numbers from the given number counter map in the order from the given
	 * comparator limited to maxNumbers
	 *
	 * @param maxNumbers
	 *            the max numbers
	 * @param numberCounterMap
	 *            the number counter map
	 * @return the sets of the lottery numbers
	 */
	public static Set<Integer> resolveLotteryNumbers(int maxNumbers,
		Map<Integer, Integer> numberCounterMap)
	{
		return resolveLotteryNumbers(maxNumbers,
			MostDrawnComparatorFactory.newMostDrawnComparator(numberCounterMap, false, true),
			numberCounterMap);
	}

	private DrawMultiMapLotteryNumbersFactory()
	{
	}
}
