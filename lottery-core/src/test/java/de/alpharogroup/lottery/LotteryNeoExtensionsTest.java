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

import java.util.Set;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import de.alpharogroup.lottery.box.LotteryBox;
import de.alpharogroup.lottery.drawing.DrawnLotteryNumbersFactory;
import de.alpharogroup.lottery.drawings.DrawnLotteryNumbers;
import de.alpharogroup.lottery.ticket.LotteryTicket;
import de.alpharogroup.lottery.wincategories.LotteryWinCategory;

/**
 * The unit test class for the class {@link LotteryExtensions}.
 */
public class LotteryNeoExtensionsTest
{

	private final static Logger log = Logger.getLogger(LotteryNeoExtensionsTest.class.getName());

	/**
	 * Log the winning category of every lottery box from the given lottery ticket.
	 *
	 * @param drawnLotteryNumbers
	 *            the drawn lottery numbers
	 * @param playedLotteryTicket
	 *            the played lottery ticket
	 */
	public static void logWinning(DrawnLotteryNumbers drawnLotteryNumbers,
		LotteryTicket playedLotteryTicket)
	{
		Set<LotteryBox> lotteryBoxes = playedLotteryTicket.getLotteryBoxes();
		for (LotteryBox lotteryBox : lotteryBoxes)
		{
			log.info(lotteryBox.getWinCategory().toString());
		}
	}

	@Test(enabled = false)
	public void testCalculateDrawsInFifthClass()
	{
		LotteryTicket lotteryTicket = LotterySetsFactory
			.newLotteryTicket(LotterySetsFactory.newLotterySetsForTests());
		LotteryExtensions.calculateDraws(lotteryTicket, LotteryWinCategory.FIFTH_CLASS, 2);
	}

	@Test(enabled = true)
	public void testCalculateDrawsInFourthClass()
	{
		LotteryTicket lotteryTicket = LotterySetsFactory
			.newLotteryTicket(LotterySetsFactory.newLotterySetsForTests());
		LotteryExtensions.calculateDraws(lotteryTicket, LotteryWinCategory.FOURTH_CLASS, 2);
	}

	@Test(enabled = true)
	public void testCalculateDrawsInSixthClass()
	{
		LotteryTicket lotteryTicket = LotterySetsFactory
			.newLotteryTicket(LotterySetsFactory.newLotterySetsForTests());
		LotteryExtensions.calculateDraws(lotteryTicket, LotteryWinCategory.SIXTH_CLASS, 2);
	}

	@Test(enabled = true)
	public void testEvaluate()
	{
		DrawnLotteryNumbers drawnLotteryNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers();
		LotteryTicket lotteryTicket = LotterySetsFactory
			.newLotteryTicket(LotterySetsFactory.newLotterySetsForTests());
		LotteryExtensions.evaluate(drawnLotteryNumbers, lotteryTicket);

	}

	@Test(enabled = false)
	public void testWholeLotterySzenario()
	{
		// 1. you want to provide a lottery with draw 6 numbers of a pool of a number range, lets
		// say 1 till 49.
		// 2. you have to anounce the draw date and make marketing for it.
		log.info("bla bla get lottery ticket and have fun bla bla");
		// 3. bring the lottery tickets under the folk
		LotteryTicket lotteryTicket = LotterySetsFactory
			.newLotteryTicket(LotterySetsFactory.newLotterySetsForTests());
		// 4. make the draw
		final DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers();
		// 5. announce the drawn numbers to the public
		log.info(luckyNumbers.toString());
		// 6. evaluate who have won
		LotteryExtensions.evaluate(luckyNumbers, lotteryTicket);
		// 7. payout

	}


}
