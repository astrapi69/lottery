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
package de.alpharogroup.lottery;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.lottery.drawings.DrawnLotteryNumbers;
import de.alpharogroup.lottery.enums.LotteryGameType;
import de.alpharogroup.lottery.evaluation.EvaluatedLotteryNumbers;
import de.alpharogroup.lottery.played.LotteryPlayedNumbers;
import de.alpharogroup.lottery.ticket.LotteryTicket;
import de.alpharogroup.lottery.wincategories.LotteryWinCategory;

/**
 * The unit test class for the class {@link LotteryExtensions}.
 */
public class LotteryExtensionsTest
{

	private final static Logger log = Logger.getLogger(LotteryExtensionsTest.class.getName());

	private static final LotteryGameType sixOffourtynineGameType = LotteryGameType.SIX_OF_FOURTYNINE_NORMAL;

	/**
	 * Test method for calculate how many times for winning of 4 numbers. This test is disabled
	 * because it can take very long time, so be careful if you enable.
	 */
	@Test(enabled = true)
	public void test4NumbersWinLuckyNumbers()
	{
		// This numbers is your played lottery numbers...
		List<Set<Integer>> sixOffourtynineGame;

		sixOffourtynineGame = LotterySetsFactory.newLotterySetsForTests();
		// ListExtensions.newArrayList(null,
		// SetExtensions.newTreeSet(3, 7, 22, 23, 34, 45),
		// SetExtensions.newTreeSet(13, 17, 21, 23, 34, 48),
		// SetExtensions.newTreeSet(5, 8, 21, 22, 34, 45));
		final Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers = MapFactory
			.newHashMap();
		playedLotteryNumbers.put(sixOffourtynineGameType, sixOffourtynineGame);

		final LotteryPlayedNumbers lotteryPlayedNumbers = LotteryPlayedNumbers.builder()
			.playedLotteryNumbers(playedLotteryNumbers).superNumber(23).superSixNumber(4).build();

		LotteryExtensions.calculateDraws(lotteryPlayedNumbers, 4);


		int actual = LotteryExtensions.calculateDraws(lotteryPlayedNumbers, 6);
		int expected = -1;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link LotteryExtensions#calculateDraws(LotteryPlayedNumbers, int, int)}.
	 */
	@Test
	public void testCalculateDrawsLotteryPlayedNumbersIntInt()
	{
		// This numbers is your played lottery numbers...
		List<Set<Integer>> sixOffourtynineGame;

		sixOffourtynineGame = LotterySetsFactory.newLotterySetsForTests();
		final Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers = MapFactory
			.newHashMap();
		playedLotteryNumbers.put(sixOffourtynineGameType, sixOffourtynineGame);
		final LotteryPlayedNumbers lotteryPlayedNumbers = LotteryPlayedNumbers.builder()
			.playedLotteryNumbers(playedLotteryNumbers).superNumber(23).superSixNumber(4).build();

		LotteryExtensions.calculateDraws(lotteryPlayedNumbers, 4, 2);
	}


	/**
	 * Test method for
	 * {@link LotteryExtensions#calculateDraws(LotteryTicket, LotteryWinCategory, int)}.
	 */
	@Test
	public void testCalculateDrawsLotteryTicketLotteryWinCategoryInt()
	{
		LotteryTicket lotteryTicket = LotterySetsFactory
			.newLotteryTicket(LotterySetsFactory.newLotterySetsForTests());
		LotteryExtensions.calculateDraws(lotteryTicket, LotteryWinCategory.FIRST_CLASS, 2);
	}

	/**
	 * Test method for
	 * {@link LotteryExtensions#checkResult(DrawnLotteryNumbers, LotteryPlayedNumbers)}.
	 */
	@Test
	public void testCheckResult()
	{

		// This numbers are lucky choosen from the lottery queen...
		final Set<Integer> lotteryNumbers = SetFactory.newTreeSet(7, 23, 34, 42, 45, 48);
		final DrawnLotteryNumbers drawnLotteryNumbers = DrawnLotteryNumbers.builder()
			.lotteryNumbers(lotteryNumbers).superNumber(5).superSixNumber(8).build();

		// This numbers is your played lottery numbers...
		List<Set<Integer>> sixOffourtynineGame;

		sixOffourtynineGame = ListFactory.<Set<Integer>> newArrayList(
			SetFactory.newTreeSet(3, 7, 22, 23, 34, 45),
			SetFactory.newTreeSet(13, 17, 21, 23, 34, 48),
			SetFactory.newTreeSet(5, 8, 21, 22, 34, 45));
		final Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers = MapFactory
			.newHashMap();
		playedLotteryNumbers.put(sixOffourtynineGameType, sixOffourtynineGame);

		final LotteryPlayedNumbers lotteryPlayedNumbers = LotteryPlayedNumbers.builder()
			.playedLotteryNumbers(playedLotteryNumbers).superNumber(23).superSixNumber(4).build();

		// Lets process if your numbers have won the jackpot...
		final EvaluatedLotteryNumbers evaluatedLotteryNumbers = LotteryExtensions
			.checkResult(drawnLotteryNumbers, lotteryPlayedNumbers);

		// make the checks and map to WinCategories...
		LotteryExtensions.setWinCategories(evaluatedLotteryNumbers);
		log.info(evaluatedLotteryNumbers.toString());
	}

	/**
	 * Test method for {@link LotteryExtensions} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(LotteryExtensions.class);
	}

}