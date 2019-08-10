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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.lottery.drawings.DrawnLotteryNumbers;
import de.alpharogroup.random.SecureRandomFactory;
import de.alpharogroup.random.number.RandomPrimitivesExtensions;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * A factory for creating {@link DrawnLotteryNumbers} objects with generated lottery numbers.
 */
@UtilityClass
public class DrawnLotteryNumbersFactory
{
	enum LotteryAlgorithm
	{

		/** The default algorithm */
		DEFAULT,

		/** The set algorithm */
		SET,

		/** The map algorithm */
		MAP;

	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers.
	 *
	 * @param max
	 *            the max number to draw
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int volume)
	{
		final DrawnLotteryNumbers drawnLotteryNumbers = DrawnLotteryNumbers.builder()
			.id(RandomPrimitivesExtensions.randomInt(Integer.MAX_VALUE))
			.lotteryNumbers(SetFactory.newTreeSet()).build();
		final SecureRandom sr = SecureRandomFactory.newSecureRandom();
		int cnt = 0;

		while (cnt < max)
		{
			final int num = 1 + Math.abs(sr.nextInt()) % volume;

			if (!drawnLotteryNumbers.getLotteryNumbers().contains(num))
			{
				if (cnt == (max - 1))
				{
					drawnLotteryNumbers.setSuperNumber(num);
				}
				else
				{
					drawnLotteryNumbers.getLotteryNumbers().add(num);
				}
				++cnt;
			}
		}
		drawnLotteryNumbers.setSuperSixNumber(RandomPrimitivesExtensions.randomIntBetween(1, 10));
		return drawnLotteryNumbers;
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers.
	 *
	 * @param max
	 *            the max number to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	@SneakyThrows
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int minVolume,
		int maxVolume)
	{
		Set<Integer> drawnNumbers = DrawnLotteryNumbersExtensions.draw(max, minVolume, maxVolume);
		return DrawnLotteryNumbers.builder().id(RandomPrimitivesExtensions.randomInt(Integer.MAX_VALUE))
			.lotteryNumbers(drawnNumbers)
			.superNumber(
				DrawnLotteryNumbersExtensions.drawSuperNumber(drawnNumbers, minVolume, maxVolume))
			.superSixNumber(RandomPrimitivesExtensions.randomIntBetween(1, 10)).build();
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers.
	 *
	 * @param max
	 *            the max number to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	@SneakyThrows
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int minVolume,
		int maxVolume, @NonNull LotteryAlgorithm algorithm)
	{
		switch (algorithm)
		{
			case SET :
				return newRandomDrawnLotteryNumbers(max, maxVolume);
			case MAP :
				Map<Integer, Integer> numberCount = MapFactory.newHashMap();
				for (int i = minVolume; i <= maxVolume; i++)
				{
					numberCount.put(i, 0);
				}
				DrawnLotteryNumbers drawnLotteryNumbers = null;
				for (int i = 0; i < 200; i++)
				{
					drawnLotteryNumbers = newRandomDrawnLotteryNumbers(max,
						minVolume, maxVolume);
					drawnLotteryNumbers.getLotteryNumbers().stream()
						.forEach(key -> numberCount.merge(key, 1, Integer::sum));
				}
				List<Entry<Integer, Integer>> sortByValue = sortByValue(numberCount);
				List<Integer> newLotteryNumbers = ListFactory.newArrayList();
				int count = 1;
				for(Entry<Integer, Integer> entry : sortByValue) {
					if(6 < count) {
						break;
					}
					newLotteryNumbers.add(entry.getKey());
					count++;
				}
				newLotteryNumbers.sort(Comparator.naturalOrder());
				drawnLotteryNumbers.setLotteryNumbers(SetFactory.newLinkedHashSet(newLotteryNumbers));
				return drawnLotteryNumbers;
			case DEFAULT :
			default :
				return newRandomDrawnLotteryNumbersDefaultAlgorithm(max, maxVolume);
		}
	}

	public static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortByValue(Map<K, V> map)
	{
		List<Entry<K, V>> list = ListFactory.newArrayList(map.entrySet());
		list.sort(Entry.comparingByValue());
		Collections.reverse(list);
		return list;
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers.
	 *
	 * @param max
	 *            the max number to draw
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbersDefaultAlgorithm(int max,
		int volume)
	{
		Set<Integer> lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		int id = RandomPrimitivesExtensions.randomInt(Integer.MAX_VALUE);
		int superNumber = DrawnLotteryNumbersExtensions.drawSuperNumber(lotteryNumbers, volume);
		int superSixNumber = RandomPrimitivesExtensions.randomIntBetween(1, 10);

		final DrawnLotteryNumbers drawnLotteryNumbers = DrawnLotteryNumbers.builder().id(id)
			.lotteryNumbers(lotteryNumbers).superNumber(superNumber).superSixNumber(superSixNumber)
			.build();

		return drawnLotteryNumbers;
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
	 *
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers()
	{
		return newRandomDrawnLotteryNumbers(7, 49);
	}

}
