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

import java.util.List;
import java.util.Set;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.lottery.box.LotteryBox;
import de.alpharogroup.lottery.enums.LotteryGameType;
import de.alpharogroup.lottery.ticket.LotteryTicket;

/**
 * A factory for creating LotterySets objects for tests.
 */
public final class LotterySetsFactory
{
	/**
	 * New lottery sets for tests.
	 *
	 * @return the list
	 */
	public static List<Set<Integer>> newLotterySetsForTests()
	{
		List<Set<Integer>> sixOffourtynineGame;
		sixOffourtynineGame = ListFactory.<Set<Integer>> newArrayList(
			SetFactory.newTreeSet(6, 12, 15, 18, 25, 30),
			SetFactory.newTreeSet(6, 12, 15, 18, 25, 41),
			SetFactory.newTreeSet(6, 12, 15, 18, 25, 48),
			SetFactory.newTreeSet(6, 12, 15, 18, 30, 41),
			SetFactory.newTreeSet(6, 12, 15, 18, 30, 48),
			SetFactory.newTreeSet(6, 12, 15, 18, 41, 48),
			SetFactory.newTreeSet(6, 12, 15, 25, 30, 41),
			SetFactory.newTreeSet(6, 12, 15, 25, 30, 48),
			SetFactory.newTreeSet(6, 12, 15, 25, 41, 48),
			SetFactory.newTreeSet(6, 12, 15, 30, 41, 48),
			SetFactory.newTreeSet(6, 12, 18, 25, 30, 41),
			SetFactory.newTreeSet(6, 12, 18, 25, 30, 48),
			SetFactory.newTreeSet(6, 12, 18, 25, 41, 48),
			SetFactory.newTreeSet(6, 12, 18, 30, 41, 48),
			SetFactory.newTreeSet(6, 12, 25, 30, 41, 48),
			SetFactory.newTreeSet(6, 15, 18, 25, 30, 41),
			SetFactory.newTreeSet(6, 15, 18, 25, 30, 48),
			SetFactory.newTreeSet(6, 15, 18, 25, 41, 48),
			SetFactory.newTreeSet(6, 15, 18, 30, 41, 48),
			SetFactory.newTreeSet(6, 15, 25, 30, 41, 48),
			SetFactory.newTreeSet(6, 18, 25, 30, 41, 48),
			SetFactory.newTreeSet(12, 15, 18, 25, 30, 41),
			SetFactory.newTreeSet(12, 15, 18, 25, 30, 48),
			SetFactory.newTreeSet(12, 15, 18, 25, 41, 48),
			SetFactory.newTreeSet(12, 15, 18, 30, 41, 48),
			SetFactory.newTreeSet(12, 15, 25, 30, 41, 48),
			SetFactory.newTreeSet(12, 18, 25, 30, 41, 48),
			SetFactory.newTreeSet(15, 18, 25, 30, 41, 48));
		return sixOffourtynineGame;
	}

	/**
	 * Creates a new {@link LotteryTicket} with the given lottery sets.
	 *
	 * @param lotterySet
	 *            the lottery set
	 * @return the lottery ticket
	 */
	public static LotteryTicket newLotteryTicket(List<Set<Integer>> lotterySet)
	{
		Set<LotteryBox> lotteryBoxes = SetFactory.newHashSet();
		for (Set<Integer> lotteryNumbers : lotterySet)
		{
			lotteryBoxes.add(LotteryBox.builder().index(lotterySet.indexOf(lotteryNumbers))
				.gameType(LotteryGameType.SIX_OF_FOURTYNINE_NORMAL).selectedNumbers(lotteryNumbers)
				.build());
		}
		LotteryTicket lotteryTicket = LotteryTicket.builder().lotteryBoxes(lotteryBoxes).build();
		return lotteryTicket;
	}

	private LotterySetsFactory()
	{
	}


}
