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

import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.math.MathExtensions;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * The unit test class for the class {@link DrawMultiMapLotteryNumbersFactory}
 */
public class DrawMultiMapLotteryNumbersFactoryTest
{

	/**
	 * Test method for {@link DrawMultiMapLotteryNumbersFactory#mergeDrawings(int, int, int, int, Map)}
	 */
	@Test
	public void testMergeDrawings() {
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
		mergeDrawings = DrawMultiMapLotteryNumbersFactory
			.mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap);
		assertNotNull(mergeDrawings);
		// summarize all count values
		actual = mergeDrawings.values().stream().reduce(0, Integer::sum);
		expected = 5000;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link DrawMultiMapLotteryNumbersFactory#drawFromMultiMap(int, int, int, int)}
	 */
	@Test
	public void testDrawFromMultiMap()
	{
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		lotteryNumbers = DrawMultiMapLotteryNumbersFactory.drawFromMultiMap(maxNumbers, minVolume,
			maxVolume, drawCount);
		actual = lotteryNumbers.size();
		expected = maxNumbers;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawMultiMapLotteryNumbersFactory#drawFromMultiMap(int, int, int, int, boolean)}
	 */
	@Test
	public void testDrawFromMultiMapIntIntIntIntBoolean()
	{
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;
		boolean mostDrawn;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		mostDrawn = true;
		lotteryNumbers = DrawMultiMapLotteryNumbersFactory
			.drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn);
		actual = lotteryNumbers.size();
		expected = maxNumbers;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}


	/**
	 * Test method for {@link DrawMultiMapLotteryNumbersFactory#drawFromMultiMap(int, int, int, int, boolean, boolean)}
	 */
	@Test
	public void testDrawFromMultiMapIntIntIntIntBooleanBoolean()
	{
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;
		boolean mostDrawn;
		boolean paranoid;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		mostDrawn = true;
		paranoid = true;
		lotteryNumbers = DrawMultiMapLotteryNumbersFactory
			.drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, paranoid);
		actual = lotteryNumbers.size();
		expected = maxNumbers;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawMultiMapLotteryNumbersFactory#drawFromMultiMap(int, int, int, int, boolean, boolean, Map)}
	 */
	@Test
	public void testDrawFromMultiMapIntIntIntIntBooleanBooleanMap()
	{
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;
		boolean mostDrawn;
		boolean paranoid;
		Comparator<Integer> comparator;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		mostDrawn = true;
		paranoid = true;

		Map<Integer, Integer> numberCounterMap;
		numberCounterMap = MapFactory.newNumberCounterMap(minVolume, maxVolume);
		comparator = DrawMultiMapLotteryNumbersFactory
			.drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, paranoid, numberCounterMap);
		assertNotNull(comparator);
	}

	/**
	 * Test method for {@link DrawMultiMapLotteryNumbersFactory#drawFromMultiMap(int, int, int, int)}
	 */
	@Test
	public void testDrawFromMultiMapWithMultiMap()
	{
		// actual return types
		Map<Integer, Integer> mergeDrawings;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		Comparator<Integer> comparator;
		Map<Integer, Integer> numberCounterMap;
			// new scenario...
		numberCounterMap = MapFactory.newNumberCounterMap(minVolume, maxVolume);
		mergeDrawings = DrawMultiMapLotteryNumbersFactory
			.mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap);
		comparator = DrawMultiMapLotteryNumbersFactory
			.drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mergeDrawings);
		assertNotNull(comparator);
	}


	/**
	 * Test method for
	 * {@link DrawMultiMapLotteryNumbersFactory#resolveLotteryNumbers(int, Map)}
	 */
	@Test
	public void testResolveLotteryNumbers(){

		// actual return types
		Map<Integer, Integer> mergeDrawings;
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		Comparator<Integer> comparator;
		Map<Integer, Integer> numberCounterMap;
		// new scenario...
		numberCounterMap = MapFactory.newNumberCounterMap(minVolume, maxVolume);
		mergeDrawings = DrawMultiMapLotteryNumbersFactory
			.mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap);
		Set<Integer> integers = DrawMultiMapLotteryNumbersFactory
			.resolveLotteryNumbers(maxNumbers, mergeDrawings);
		assertNotNull(integers);
		assertEquals(integers.size(), maxNumbers);
	}

	/**
	 * Test method for
	 * {@link DrawMultiMapLotteryNumbersFactory#drawParanoidFromMultiMap(int, int, int, int)}
	 */
	@Test
	public void testDrawParanoidFromMultiMap()
	{
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 1000;
		lotteryNumbers = DrawMultiMapLotteryNumbersFactory.drawParanoidFromMultiMap(maxNumbers,
			minVolume, maxVolume, drawCount);
		actual = lotteryNumbers.size();
		expected = maxNumbers;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawMultiMapLotteryNumbersFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawMultiMapLotteryNumbersFactory.class);
	}
}
