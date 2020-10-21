package de.alpharogroup.lottery.drawing;

import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomIntFactory;

import java.security.SecureRandom;
import java.util.Set;

/**
 * The factory class {@link DrawSuperNumbersFactory} provides factory methods to draw super numbers
 * with {@link SecureRandom} argument for custom randomize draws, like
 * for a special draw date we could initialize the {@link SecureRandom} with the draw date.
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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the drawn super number
	 */
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int volume, SecureRandom secureRandom)
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
			superNumber = RandomIntFactory.randomIntBetween(minVolume, maxVolume, true,
				true, secureRandom);
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
	public static int drawSuperNumber(Set<Integer> alreadyDrawnNumbers, int minVolume,
		int maxVolume)
	{
		return drawSuperNumber(alreadyDrawnNumbers, minVolume, maxVolume, DefaultSecureRandom.get());
	}

}
