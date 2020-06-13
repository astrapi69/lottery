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
package de.alpharogroup.lottery.wincategories;

import java.util.Collection;
import java.util.Optional;

import de.alpharogroup.collections.CollectionExtensions;
import de.alpharogroup.collections.set.SetFactory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * The enum {@link LotteryWinCategory} represents all lottery winning categories.
 */
@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum LotteryWinCategory implements WinningOpportunity
{

	/** The eighth winning class. */
	EIGHTH_CLASS(WinCategory.builder().quotaOfProfit(45.0d).quantityOfWonNumbers(3).withSuperNumber(false).build()),
	/** The fifth winning class. */
	FIFTH_CLASS(WinCategory.builder().quotaOfProfit(5.0d).quantityOfWonNumbers(4).withSuperNumber(true).build()),
	/** The first winning class. */
	FIRST_CLASS(WinCategory.builder().quotaOfProfit(12.8d).quantityOfWonNumbers(6).withSuperNumber(true).build()),
	/** The fourth winning class. */
	FOURTH_CLASS(WinCategory.builder().quotaOfProfit(15.0d).quantityOfWonNumbers(5).withSuperNumber(false).build()),
	/** The ninth winning class. */
	NINTH_CLASS(WinCategory.builder().fixedWinningUnits(5).quantityOfWonNumbers(2).withSuperNumber(true).build()),
	/** The none winning class. */
	NONE(null),
	/** The second winning class. */
	SECOND_CLASS(WinCategory.builder().quotaOfProfit(10.0d).quantityOfWonNumbers(6).withSuperNumber(false).build()),
	/** The seventh winning class. */
	SEVENTH_CLASS(WinCategory.builder().quotaOfProfit(10.0d).quantityOfWonNumbers(3).withSuperNumber(true).build()),
	/** The sixth winning class. */
	SIXTH_CLASS(WinCategory.builder().quotaOfProfit(10.0d).quantityOfWonNumbers(4).withSuperNumber(false).build()),
	/** The third winning class. */
	THIRD_CLASS(WinCategory.builder().quotaOfProfit(5.0d).quantityOfWonNumbers(5).withSuperNumber(true).build());

	/**
	 * Gets an {@linkplain Optional} with the {@linkplain LotteryWinCategory} from the given
	 * Collection that contains the result of an intersection with the drawn lottery numbers.
	 *
	 * @param wonLotteryTicket
	 *            the won lottery ticket
	 * @param withSuperNumber
	 *            the with super number
	 * @return the lottery win category
	 */
	public static Optional<LotteryWinCategory> getLotteryWinCategory(
		Collection<Integer> wonLotteryTicket, boolean withSuperNumber)
	{
		int size = wonLotteryTicket.size();
		Optional<LotteryWinCategory> optional = Optional.of(NONE);
		if (size == 6)
		{
			if (withSuperNumber)
			{
				optional = Optional.of(FIRST_CLASS);
			}
			if (!withSuperNumber)
			{
				optional = Optional.of(SECOND_CLASS);
			}
		}
		if (size == 5)
		{
			if (withSuperNumber)
			{
				optional = Optional.of(THIRD_CLASS);
			}
			if (!withSuperNumber)
			{
				optional = Optional.of(FOURTH_CLASS);
			}
		}
		if (size == 4)
		{
			if (withSuperNumber)
			{
				optional = Optional.of(FIFTH_CLASS);
			}
			if (!withSuperNumber)
			{
				optional = Optional.of(SIXTH_CLASS);
			}
		}
		if (size == 3)
		{
			if (withSuperNumber)
			{
				optional = Optional.of(SEVENTH_CLASS);
			}
			if (!withSuperNumber)
			{
				optional = Optional.of(EIGHTH_CLASS);
			}
		}
		if (size == 2 && withSuperNumber)
		{
			optional = Optional.of(NINTH_CLASS);
		}
		return optional;
	}

	/**
	 * Gets an {@linkplain Optional} with the {@linkplain LotteryWinCategory} that is an
	 * intersection of the given drawn lottery numbers and the given played lottery Ticket.
	 *
	 * @param drawnLotteryNumbers
	 *            the drawn lottery numbers
	 * @param playedLotteryTicket
	 *            the played lottery ticket
	 * @param withSuperNumber
	 *            the with super number
	 * @return the lottery win category
	 */
	public static Optional<LotteryWinCategory> getLotteryWinCategory(
		Collection<Integer> drawnLotteryNumbers, Collection<Integer> playedLotteryTicket,
		boolean withSuperNumber)
	{
		final Collection<Integer> wonNumbers = CollectionExtensions
			.intersection(SetFactory.newTreeSet(drawnLotteryNumbers), playedLotteryTicket);
		return getLotteryWinCategory(wonNumbers, withSuperNumber);
	}

	/** The bean that represents the win category. */
	WinCategory winCategory;

}
