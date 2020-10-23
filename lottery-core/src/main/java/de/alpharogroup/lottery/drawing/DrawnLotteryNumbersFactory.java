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
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.Set;

import de.alpharogroup.lottery.drawings.DrawnLotteryNumbers;
import de.alpharogroup.lottery.enums.LotteryAlgorithm;
import de.alpharogroup.random.SecureRandomBean;
import de.alpharogroup.random.SecureRandomFactory;
import de.alpharogroup.random.number.RandomIntFactory;

/**
 * A factory class for creating {@link DrawnLotteryNumbers} objects with generated lottery numbers
 */
public final class DrawnLotteryNumbersFactory
{

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
	 *
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers()
	{
		return newRandomDrawnLotteryNumbers(7, 49);
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
	 *
	 * @param max
	 *            the max number to draw
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int volume)
	{
		return newRandomDrawnLotteryNumbers(max, volume,
			LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
	 *
	 * @param max
	 *            the max number to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int minVolume,
		int maxVolume)
	{
		Set<Integer> drawnNumbers = DrawLotteryNumbersFactory.draw(max, minVolume, maxVolume);
		return DrawnLotteryNumbers.builder().id(RandomIntFactory.randomInt(Integer.MAX_VALUE))
			.lotteryNumbers(drawnNumbers)
			.superNumber(
				DrawSuperNumbersFactory.drawSuperNumber(drawnNumbers, minVolume, maxVolume))
			.superSixNumber(RandomIntFactory.randomIntBetween(1, 10)).build();
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
	 * with the given algorithm
	 *
	 * @param max
	 *            the max number to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param drawCount
	 *            the draw count defines how many times to draw numbers. Note: only with map
	 *            algorithm
	 * @param algorithm
	 *            the algorithm to use
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int minVolume,
		int maxVolume, int drawCount, LotteryAlgorithm algorithm)
	{
		Objects.requireNonNull(algorithm);
		switch (algorithm)
		{
			case MAP :
				DrawnLotteryNumbers drawnLotteryNumbers = newRandomDrawnLotteryNumbers(max,
					minVolume, maxVolume);
				drawnLotteryNumbers.setLotteryNumbers(DrawMultiMapLotteryNumbersFactory
					.drawFromMultiMap(max, minVolume, maxVolume, drawCount));
				return drawnLotteryNumbers;
			case SET :
				return newRandomDrawnLotteryNumbers(max, maxVolume);
			case DEFAULT :
			default :
				return newRandomDrawnLotteryNumbersDefaultAlgorithm(max, maxVolume);
		}
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
	 * with the given algorithm
	 *
	 * @param max
	 *            the max number to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param algorithm
	 *            the algorithm to use
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int minVolume,
		int maxVolume, LotteryAlgorithm algorithm)
	{
		Objects.requireNonNull(algorithm);
		return newRandomDrawnLotteryNumbers(max, minVolume, maxVolume, 200, algorithm);
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
	 *
	 * @param max
	 *            the max number to draw
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @param drawDate
	 *            the draw date as long
	 * @return the new {@link DrawnLotteryNumbers}
	 */
	public static DrawnLotteryNumbers newRandomDrawnLotteryNumbers(int max, int volume,
		long drawDate)
	{
		final SecureRandom sr = SecureRandomFactory.newSecureRandom(
			SecureRandomBean.DEFAULT_ALGORITHM, SecureRandomBean.DEFAULT_PROVIDER, drawDate);
		final DrawnLotteryNumbers drawnLotteryNumbers = DrawnLotteryNumbers.builder()
			.id(RandomIntFactory.randomInt(Integer.MAX_VALUE))
			.lotteryNumbers(DrawLotteryNumbersFactory.draw(max, volume, sr)).build();
		drawnLotteryNumbers.setSuperNumber(DrawSuperNumbersFactory
			.drawSuperNumber(drawnLotteryNumbers.getLotteryNumbers(), volume));
		drawnLotteryNumbers.setSuperSixNumber(RandomIntFactory.randomIntBetween(1, 10));
		return drawnLotteryNumbers;
	}

	/**
	 * Factory method for create a new {@link DrawnLotteryNumbers} object with all drawn numbers
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
		Set<Integer> lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		int id = RandomIntFactory.randomInt(Integer.MAX_VALUE);
		int superNumber = DrawSuperNumbersFactory.drawSuperNumber(lotteryNumbers, volume);
		int superSixNumber = RandomIntFactory.randomIntBetween(1, 10);
		return DrawnLotteryNumbers.builder().id(id).lotteryNumbers(lotteryNumbers)
			.superNumber(superNumber).superSixNumber(superSixNumber).build();
	}

	private DrawnLotteryNumbersFactory()
	{
	}

}
