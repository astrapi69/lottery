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

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.math.MathExtensions;
import de.alpharogroup.random.DefaultSecureRandom;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * The unit test class for the class {@link DrawLotteryNumbersFactory}.
 */
public class DrawLotteryNumbersFactoryTest
{

	/**
	 * Test method for {@link DrawLotteryNumbersFactory#drawWithShuffle(int, int, int, SecureRandom)}
	 */
	@Test
	public void testDrawWithShuffle()
	{
		int actual;
		int expected;

		Set<Integer> lotteryNumbers;
		int max;
		int minVolume;
		int maxVolume;


		// simulate a draw of 7 numbers in between of 5 and 39
		max = 7;
		minVolume = 5;
		maxVolume = 39;
		lotteryNumbers = DrawLotteryNumbersFactory.drawWithShuffle(max, minVolume,
			maxVolume, DefaultSecureRandom.get());
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawLotteryNumbersFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawLotteryNumbersFactory.class);
	}

}
