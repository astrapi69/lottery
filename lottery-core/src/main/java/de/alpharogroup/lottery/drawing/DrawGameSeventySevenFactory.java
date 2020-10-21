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
