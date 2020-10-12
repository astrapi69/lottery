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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Map;

import de.alpharogroup.random.number.RandomIntFactory;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.map.MapExtensions;
import de.alpharogroup.lottery.drawings.DrawnLotteryNumbers;
import de.alpharogroup.lottery.enums.LotteryAlgorithm;

/**
 * The class {@link DrawnLotteryNumbersFactory}.
 */
public class DrawnLotteryNumbersFactoryTest
{

	/**
	 * Test method for {@link DrawnLotteryNumbersFactory#newNumberCounterMap(int, int, Map)}
	 */
	@Test
	public void testMergeAndSummarize()
	{
		int minVolume;
		int maxVolume;
		Map<Integer, Integer> initialNumberCounterMap;
		Map<Integer, Integer> numberCounterMap;

		minVolume = 1;
		maxVolume = 10;
		numberCounterMap = DrawnLotteryNumbersFactory.newNumberCounterMap(minVolume, maxVolume);
		for (int i = minVolume; i <= maxVolume; i++)
		{
			numberCounterMap.merge(i, RandomIntFactory.randomIntBetween(1, 4),
				Integer::sum);
		}
		initialNumberCounterMap = DrawnLotteryNumbersFactory.newNumberCounterMap(minVolume,
			maxVolume, numberCounterMap);
		for (int i = minVolume; i <= maxVolume; i++)
		{
			initialNumberCounterMap.merge(i, RandomIntFactory.randomIntBetween(1, 4),
				Integer::sum);
		}
		Map<Integer, Integer> mergedMap = MapExtensions.mergeAndSummarize(initialNumberCounterMap,
			numberCounterMap);
		for (int i = minVolume; i <= maxVolume; i++)
		{
			int actual = mergedMap.get(i);
			int expected = numberCounterMap.get(i) + initialNumberCounterMap.get(i);
			assertEquals(actual, expected);
		}
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersFactory#newNumberCounterMap(int, int)}
	 */
	@Test
	public void testNewNumberCounterMap()
	{
		int minVolume;
		int maxVolume;
		minVolume = 1;
		maxVolume = 10;
		Map<Integer, Integer> numberCounterMap = DrawnLotteryNumbersFactory
			.newNumberCounterMap(minVolume, maxVolume);
		assertNotNull(numberCounterMap);
		assertEquals(numberCounterMap.size(), maxVolume);
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersFactory#newRandomDrawnLotteryNumbers()}.
	 */
	@Test
	public void testNewRandomDrawnLotteryNumbers()
	{
		final DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers();
		assertNotNull(luckyNumbers);
	}

	/**
	 * Test method for
	 * {@link DrawnLotteryNumbersFactory#newRandomDrawnLotteryNumbersDefaultAlgorithm(int, int)}.
	 */
	@Test
	public void testNewRandomDrawnLotteryNumbersDefaultAlgorithm()
	{
		final DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbersDefaultAlgorithm(5, 48);
		assertNotNull(luckyNumbers);
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersFactory#newRandomDrawnLotteryNumbers(int, int)}
	 */
	@Test
	public void testNewRandomDrawnLotteryNumbersIntInt()
	{
		final DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers(5, 48);
		assertNotNull(luckyNumbers);
	}

	/**
	 * Test method for
	 * {@link DrawnLotteryNumbersFactory#newRandomDrawnLotteryNumbers(int, int, int)}
	 */
	@Test
	public void testNewRandomDrawnLotteryNumbersMaxMinMaxVolume()
	{
		final DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers(5, 1, 49);
		assertNotNull(luckyNumbers);
	}

	/**
	 * Test method for
	 * {@link DrawnLotteryNumbersFactory#newRandomDrawnLotteryNumbers(int, int, int, LotteryAlgorithm)}
	 */
	@Test
	public void testNewRandomDrawnLotteryNumbersMaxMinMaxVolumeAlgo()
	{
		DrawnLotteryNumbers luckyNumbers;

		luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers(6, 1, 49, LotteryAlgorithm.MAP);
		assertNotNull(luckyNumbers);
		luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers(6, 1, 49, LotteryAlgorithm.SET);
		assertNotNull(luckyNumbers);
		luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers(6, 1, 49, LotteryAlgorithm.DEFAULT);
		assertNotNull(luckyNumbers);
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawnLotteryNumbersFactory.class);
	}

}
