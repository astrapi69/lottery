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

import static org.testng.Assert.assertNotNull;

import java.lang.reflect.InvocationTargetException;

import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.lottery.drawings.DrawnLotteryNumbers;

/**
 * The class {@link DrawnLotteryNumbersFactory}.
 */
public class DrawnLotteryNumbersFactoryTest
{
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
	 * Test method for {@link DrawnLotteryNumbersFactory#newRandomDrawnLotteryNumbers(int, int)}.
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
	 * {@link DrawnLotteryNumbersFactory#newRandomDrawnLotteryNumbers(int, int, int)}.
	 */
	@Test
	public void testNewRandomDrawnLotteryNumbersMaxMinMaxVolume()
	{
		final DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers(5, 1, 49);
		assertNotNull(luckyNumbers);
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersFactory} with {@link BeanTester}
	 */
	@Test(expectedExceptions = { BeanTestException.class, InvocationTargetException.class,
			UnsupportedOperationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawnLotteryNumbersFactory.class);
	}

}
