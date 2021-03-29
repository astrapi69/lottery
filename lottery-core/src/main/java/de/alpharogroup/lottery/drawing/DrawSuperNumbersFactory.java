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
import java.util.Set;

import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomIntFactory;

/**
 * The factory class {@link DrawSuperNumbersFactory} provides factory methods to draw super numbers
 * with {@link SecureRandom} argument for custom randomize draws, like for a special draw date we
 * could initialize the {@link SecureRandom} with the draw date.
 */
public final class DrawSuperNumbersFactory
{

	private DrawSuperNumbersFactory()
	{
	}

	/**
	 * Draws a super number that is not in the given already drawn numbers {@link Set}.
	 *
	 * @param alreadyDrawnNumbers
	 *            the already drawn numbers
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @return the drawn super number
	 */
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int volume)
	{
		return drawSuperNumber(alreadyDrawnNumbers, volume, DefaultSecureRandom.get());
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
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int minVolume,
		int maxVolume)
	{
		return drawSuperNumber(alreadyDrawnNumbers, minVolume, maxVolume,
			DefaultSecureRandom.get());
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the drawn super number
	 */
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int minVolume,
		int maxVolume, SecureRandom secureRandom)
	{
		int superNumber = -1;
		boolean breakout = false;
		while (!breakout)
		{
			superNumber = RandomIntFactory.randomIntBetween(minVolume, maxVolume, true, true,
				secureRandom);
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
	 * @param volume
	 *            the volume of the numbers starts from 1 till volume
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the drawn super number
	 */
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int volume,
		SecureRandom secureRandom)
	{
		int superNumber = -1;
		boolean breakout = false;
		while (!breakout)
		{
			superNumber = RandomIntFactory.randomIntBetween(1, volume, secureRandom);
			if (!alreadyDrawnNumbers.contains(superNumber))
			{
				breakout = true;
			}
		}
		return superNumber;
	}

}
