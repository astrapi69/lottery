package de.alpharogroup.lottery.drawing;

import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomIntFactory;

import java.security.SecureRandom;
import java.util.Set;

/**
 * The factory class {@link DrawGameSeventySevenFactory} provides factory methods to draw numbers
 * for the game seventyseven with {@link SecureRandom} argument for custom randomize draws, like
 * for a special draw date we could initialize the {@link SecureRandom} with the draw date.
 */
public final class DrawGameSeventySevenFactory
{

	private DrawGameSeventySevenFactory()
	{
	}

	/**
	 * Draw the number of the game seventy seven
	 *
	 * @return the drawn number of the game seventy seven
	 */
	public static int drawGameSeventySeven()
	{
		return drawGameSeventySeven(DefaultSecureRandom.get());
	}

	/**
	 * Draw the number of the game seventy seven
	 *
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the drawn number of the game seventy seven
	 */
	public static int drawGameSeventySeven(SecureRandom secureRandom)
	{
		return RandomIntFactory.randomIntBetween(0, 9999999, true, true, secureRandom);
	}
}
