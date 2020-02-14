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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import de.alpharogroup.collections.CollectionExtensions;
import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.lottery.box.LotteryBox;
import de.alpharogroup.lottery.drawing.DrawnLotteryNumbersFactory;
import de.alpharogroup.lottery.drawings.DrawnLotteryNumbers;
import de.alpharogroup.lottery.enums.LotteryGameType;
import de.alpharogroup.lottery.evaluation.EvaluatedLotteryNumbers;
import de.alpharogroup.lottery.played.LotteryPlayedNumbers;
import de.alpharogroup.lottery.ticket.LotteryTicket;
import de.alpharogroup.lottery.wincategories.LotteryWinCategory;
import de.alpharogroup.math.MathExtensions;

/**
 * The class {@link LotteryExtensions} provides utility methods for draw lottery, super numbers and
 * other gambling algorithms.
 */
public final class LotteryExtensions
{
	private static final Logger log = Logger.getLogger(LotteryExtensions.class.getName());

	/**
	 * Calculate draws for statistics.
	 *
	 * @param lotteryPlayedNumbers
	 *            the lottery played numbers
	 * @param winningNumbersCount
	 *            the winning numbers count
	 * @return the int
	 */
	public static int calculateDraws(final LotteryPlayedNumbers lotteryPlayedNumbers,
		final int winningNumbersCount)
	{
		return calculateDraws(lotteryPlayedNumbers, winningNumbersCount, 10000);
	}

	/**
	 * Calculate draws for statistics.
	 *
	 * @param lotteryPlayedNumbers
	 *            the lottery played numbers
	 * @param winningNumbersCount
	 *            the winning numbers count
	 * @param maxIterations
	 *            the max iterations in the while loop
	 * @return the int
	 */
	public static int calculateDraws(final LotteryPlayedNumbers lotteryPlayedNumbers,
		final int winningNumbersCount, int maxIterations)
	{
		if (!MathExtensions.isBetween(1, 6, winningNumbersCount))
		{
			log.info("winningNumbersCount have to be between 1 and 5");
			return -1;
		}
		int count = 0;
		DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers();
		count++;
		EvaluatedLotteryNumbers evaluatedLotteryNumbers;
		boolean breakout = false;
		while (!breakout)
		{
			evaluatedLotteryNumbers = LotteryExtensions.checkResult(luckyNumbers,
				lotteryPlayedNumbers);
			final Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers = evaluatedLotteryNumbers
				.getWonLotteryNumbers();
			if (!wonLotteryNumbers.isEmpty())
			{
				final List<Collection<Integer>> collections = wonLotteryNumbers
					.get(LotteryGameType.SIX_OF_FOURTYNINE_NORMAL);
				for (int i = 0; i < collections.size(); i++)
				{
					final Collection<Integer> s = collections.get(i);
					if (winningNumbersCount < s.size())
					{
						breakout = true;
						break;
					}
				}
			}
			luckyNumbers = DrawnLotteryNumbersFactory.newRandomDrawnLotteryNumbers();
			count++;
			if (maxIterations < count)
			{
				breakout = true;
			}
		}

		return count;
	}

	/**
	 * Calculate how much draws will be needed to win with the given lottery ticket in the given win
	 * category.<br>
	 * Caution: use with care if win category is first-class this can take a while till a return
	 * value is calculated.
	 *
	 * @param lotteryTicket
	 *            the lottery ticket
	 * @param lotteryWinCategory
	 *            the lottery win category
	 * @return the quantity of draws for win of the given ticket
	 */
	public static int calculateDraws(LotteryTicket lotteryTicket,
		LotteryWinCategory lotteryWinCategory)
	{
		Objects.requireNonNull(lotteryWinCategory);
		return calculateDraws(lotteryTicket, lotteryWinCategory, 10000);
	}


	/**
	 * This method provides calculation of how much draws will be needed to win with the given
	 * lottery ticket in the given win category. Can be used for statistics. <br>
	 * Caution: use with care if win category is first-class this can take a while till a return
	 * value is calculated.
	 *
	 * @param lotteryTicket
	 *            the lottery ticket
	 * @param lotteryWinCategory
	 *            the lottery win category
	 * @param maxIterations
	 *            the max iterations in the while loop
	 * @return the quantity of draws for win of the given ticket
	 */
	public static int calculateDraws(LotteryTicket lotteryTicket,
		LotteryWinCategory lotteryWinCategory, int maxIterations)
	{
		Objects.requireNonNull(lotteryWinCategory);
		final long startTime = System.nanoTime();

		int count = 0;

		DrawnLotteryNumbers luckyNumbers = DrawnLotteryNumbersFactory
			.newRandomDrawnLotteryNumbers();
		count++;
		boolean breakout = false;
		// int i1 = 3;
		while (!breakout)
		{
			evaluate(luckyNumbers, lotteryTicket);
			Set<LotteryBox> lotteryBoxes = lotteryTicket.getLotteryBoxes();
			for (LotteryBox box : lotteryBoxes)
			{
				if (!box.getWinCategory().equals(LotteryWinCategory.NONE))
				{
					log.info("current draw " + count + " and win category: "
						+ box.getWinCategory().name());
				}
				breakout = box.getWinCategory().equals(lotteryWinCategory);
			}
			luckyNumbers = DrawnLotteryNumbersFactory.newRandomDrawnLotteryNumbers();
			count++;
			if (maxIterations < count)
			{
				breakout = true;
			}
		}

		log.info("Elapsed time till you have won something: "
			+ calculateElapsedTimeInSeconds(startTime));
		log.info("you have won after " + count + " drawings");
		log.info("you have won: " + lotteryTicket);
		return count;
	}

	/**
	 * Calculate elapsed time in seconds from the given start time as long to the current system
	 * time. This is useful for benchmarking
	 *
	 * @param startTime
	 *            the start time
	 * @return The elapsed time in double
	 */
	public static double calculateElapsedTimeInSeconds(final long startTime)
	{
		return ((double)(System.nanoTime() - startTime)) / 1000000;
	}

	/**
	 * Checks the result if the drawn lottery numbers are equal to the given played numbers. The
	 * result is a {@link EvaluatedLotteryNumbers} object that keep the winning numbers.
	 *
	 * @param drawnLotteryNumbers
	 *            the drawn lottery numbers are the numbers that are drawn from the lottery
	 *            corporation
	 * @param lotteryPlayedNumbers
	 *            the lottery played numbers are the numbers that are played from the users
	 * @return the won numbers
	 */
	public static EvaluatedLotteryNumbers checkResult(final DrawnLotteryNumbers drawnLotteryNumbers,
		final LotteryPlayedNumbers lotteryPlayedNumbers)
	{
		final Set<Integer> drawnLuckyLotteryNumbers = drawnLotteryNumbers.getLotteryNumbers();
		final Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers = lotteryPlayedNumbers
			.getPlayedLotteryNumbers();
		final Set<LotteryGameType> playedLotteryTickets = playedLotteryNumbers.keySet();
		final EvaluatedLotteryNumbers evaluatedLotteryNumbersBean = EvaluatedLotteryNumbers
			.builder().build();
		final Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbersMap = evaluatedLotteryNumbersBean
			.getWonLotteryNumbers();
		for (final LotteryGameType lotteryGameType : playedLotteryTickets)
		{
			final List<Set<Integer>> lotteryTicket = playedLotteryNumbers.get(lotteryGameType);
			final List<Collection<Integer>> currentWonLotteryNumbersList = ListFactory
				.newArrayList(wonLotteryNumbersMap.get(lotteryGameType));
			wonLotteryNumbersMap.put(lotteryGameType, currentWonLotteryNumbersList);
			for (int i = 0; i < lotteryTicket.size(); i++)
			{
				Set<Integer> currentLotteryPlayedBox = lotteryTicket.get(i);
				final Collection<Integer> wonNumbers = CollectionExtensions.intersection(
					SetFactory.newTreeSet(drawnLuckyLotteryNumbers), currentLotteryPlayedBox);
				currentWonLotteryNumbersList.add(wonNumbers);
			}
		}
		return evaluatedLotteryNumbersBean;
	}

	/**
	 * Evaluate the given lottery ticket from the given drawn numbers.
	 *
	 * @param drawnLotteryNumbers
	 *            the drawn lottery numbers
	 * @param playedLotteryTicket
	 *            the played lottery ticket
	 */
	public static void evaluate(DrawnLotteryNumbers drawnLotteryNumbers,
		LotteryTicket playedLotteryTicket)
	{
		Set<LotteryBox> lotteryBoxes = playedLotteryTicket.getLotteryBoxes();

		for (LotteryBox lotteryBox : lotteryBoxes)
		{
			boolean withSuperNumber = lotteryBox.getSelectedNumbers()
				.contains(drawnLotteryNumbers.getSuperNumber());
			Optional<LotteryWinCategory> lotteryWinCategory = LotteryWinCategory
				.getLotteryWinCategory(drawnLotteryNumbers.getLotteryNumbers(),
					lotteryBox.getSelectedNumbers(), withSuperNumber);
			lotteryWinCategory.ifPresent(lwc -> lotteryBox.setWinCategory(lwc));
		}
	}

	public static void setWinCategories(final EvaluatedLotteryNumbers evaluatedLotteryNumbers)
	{
		final Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbersMap = evaluatedLotteryNumbers
			.getWonLotteryNumbers();
		Set<LotteryGameType> lotteryGameTypeSet = wonLotteryNumbersMap.keySet();
		boolean withSuperNumber = false;
		for (final LotteryGameType lotteryGameType : lotteryGameTypeSet)
		{
			List<Collection<Integer>> currentWonLotteryNumbersList = wonLotteryNumbersMap
				.get(lotteryGameType);
			for (Collection<Integer> wonLotteryTicket : currentWonLotteryNumbersList)
			{
				Optional<LotteryWinCategory> lotteryWinCategory = LotteryWinCategory
					.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
				lotteryWinCategory.ifPresent(l -> System.out.println(l.name()));
			}
		}
	}

	private LotteryExtensions()
	{
	}

}
