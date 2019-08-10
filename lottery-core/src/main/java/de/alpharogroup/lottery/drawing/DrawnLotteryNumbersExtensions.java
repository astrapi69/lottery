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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomPrimitivesExtensions;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

/**
 * The class {@link DrawnLotteryNumbersExtensions}.
 */
@UtilityClass
@Log
public final class DrawnLotteryNumbersExtensions
{

	/**
	 * Draws a super number that is not in the given already drawn numbers {@link Set}.
	 *
	 * @param alreadyDrawnNumbers
	 *            the already drawn numbers
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the drawn super number
	 */
	@SneakyThrows
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int volume)
	{
		int superNumber = -1;
		boolean breakout = false;
		while (!breakout)
		{
			superNumber = RandomPrimitivesExtensions.getRandomIntBetween(1, volume);
			if (!alreadyDrawnNumbers.contains(superNumber))
			{
				breakout = true;
			}
		}
		return superNumber;
	}

	/**
	 * Draws a super number that is not in the given already drawn numbers {@link Set}.
	 *
	 * @param alreadyDrawnNumbers
	 *            the already drawn numbers
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @return the drawn super number
	 */
	@SneakyThrows
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int minVolume,
		int maxVolume)
	{
		int superNumber = -1;
		boolean breakout = false;
		while (!breakout)
		{
			superNumber = RandomPrimitivesExtensions.randomIntBetween(minVolume, maxVolume, true,
				true);
			if (!alreadyDrawnNumbers.contains(superNumber))
			{
				breakout = true;
			}
		}
		return superNumber;
	}

	/**
	 * Draw the number of the game seventy seven
	 *
	 * @return the drawn number of the game seventy seven
	 */
	public static int drawGameSeventySeven()
	{
		return RandomPrimitivesExtensions.randomIntBetween(0, 9999999, true, true);
	}

	/**
	 * Draw of lottery numbers.
	 *
	 * @param maxNumbers
	 *            the max number to draw
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the sets the
	 */
	@SneakyThrows
	public static Set<Integer> draw(int maxNumbers, int volume)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();

		int cnt = 0;

		while (cnt < maxNumbers)
		{
			final int num = RandomPrimitivesExtensions.getRandomIntBetween(1, volume);

			if (!numbers.contains(num))
			{
				numbers.add(num);
				++cnt;
			}
		}
		return numbers;
	}

	/**
	 * Draw of lottery numbers.
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> draw(int maxNumbers, int minVolume, int maxVolume)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();

		int cnt = 0;

		while (cnt < maxNumbers)
		{
			final int num = RandomPrimitivesExtensions.randomIntBetween(minVolume, maxVolume, true,
				true);

			if (!numbers.contains(num))
			{
				numbers.add(num);
				++cnt;
			}
		}
		return numbers;
	}

	/**
	 * This draw algorithm simulates the real world.
	 *
	 * @param maxNumbers
	 *            the max number to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the sets the
	 */
	@SneakyThrows
	public static Set<Integer> drawDefaultAlgorithm(int maxNumbers, int minVolume, int maxVolume)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();
		ArrayList<Integer> rangeList = new ArrayList<>(
			ListFactory.newRangeList(minVolume, maxVolume));

		final SecureRandom sr = DefaultSecureRandom.get();
		int cnt = 0;

		while (cnt < maxNumbers)
		{
			Collections.shuffle(rangeList, sr);
			final int index = RandomPrimitivesExtensions.randomIntBetween(0, rangeList.size(), true,
				false);
			Integer drawnNumber = rangeList.get(index);
			if (rangeList.remove(drawnNumber))
			{
				log.log(Level.FINE, "removed drawn number:" + drawnNumber);
			}
			if (!numbers.contains(drawnNumber))
			{
				numbers.add(drawnNumber);
				++cnt;
			}
		}
		return numbers;
	}

}
