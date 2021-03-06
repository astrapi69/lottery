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

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomIntFactory;

/**
 * The factory class {@link DrawLotteryNumbersFactory} provides factory methods to draw lottery
 * numbers with different algorithms and {@link SecureRandom} argument for custom randomize draws,
 * like for a special draw date we could initialize the {@link SecureRandom} with the draw date.
 */
public final class DrawLotteryNumbersFactory
{

	private DrawLotteryNumbersFactory()
	{
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
	public static Set<Integer> draw(int maxNumbers, int volume)
	{
		return draw(maxNumbers, volume, DefaultSecureRandom.get());
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
		return draw(maxNumbers, minVolume, maxVolume, DefaultSecureRandom.get());
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> draw(int maxNumbers, int minVolume, int maxVolume,
		SecureRandom secureRandom)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();
		int cnt = 0;
		while (cnt < maxNumbers)
		{
			final int num = RandomIntFactory.randomIntBetween(minVolume, maxVolume, true, true,
				secureRandom);
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
	 *            the max number to draw
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the sets the
	 */
	public static Set<Integer> draw(int maxNumbers, int volume, SecureRandom secureRandom)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();
		int cnt = 0;
		while (cnt < maxNumbers)
		{
			final int num = RandomIntFactory.randomIntBetween(1, volume, secureRandom);

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
	public static Set<Integer> drawWithShuffle(int maxNumbers, int minVolume, int maxVolume)
	{
		return drawWithShuffle(maxNumbers, minVolume, maxVolume, DefaultSecureRandom.get());
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the sets of the drawn numbers
	 */
	public static Set<Integer> drawWithShuffle(int maxNumbers, int minVolume, int maxVolume,
		SecureRandom secureRandom)
	{
		Set<Integer> numbers = SetFactory.newTreeSet();
		ArrayList<Integer> rangeList = new ArrayList<>(
			ListFactory.newRangeList(minVolume, maxVolume));
		int cnt = 0;
		while (cnt < maxNumbers)
		{
			Collections.shuffle(rangeList, secureRandom);
			final int index = RandomIntFactory.randomIntBetween(0, rangeList.size(), true, false,
				secureRandom);
			Integer drawnNumber = rangeList.get(index);
			if (!numbers.contains(drawnNumber))
			{
				numbers.add(drawnNumber);
				++cnt;
			}
		}
		return numbers;
	}
}
