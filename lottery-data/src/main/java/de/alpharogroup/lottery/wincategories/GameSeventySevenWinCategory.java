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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * The enum {@link GameSeventySevenWinCategory}.
 */
@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum GameSeventySevenWinCategory implements WinningOpportunity
{

	/** The fifth winning class. */
	FIFTH_CLASS(3, 77),
	/** The first winning class. */
	FIRST_CLASS(7, 177777),
	/** The fourth winning class. */
	FOURTH_CLASS(4, 777),
	/** The none winning class. */
	BLANK(0, 0),
	/** The second winning class. */
	SECOND_CLASS(6, 77777),
	/** The seventh winning class. */
	SEVENTH_CLASS(1, 5),
	/** The sixth winning class. */
	SIXTH_CLASS(2, 17),
	/** The third winning class. */
	THIRD_CLASS(5, 7777);

	public static GameSeventySevenWinCategory getGameSeventySevenWinCategory(
		Integer drawnGameSeventySeven, Integer playedGameSeventySeven)
	{

		String dgss = String.format("%07d", drawnGameSeventySeven);
		String pgss = String.format("%07d", playedGameSeventySeven);

		String rdgss = new StringBuilder(dgss).reverse().toString();
		String rpgss = new StringBuilder(pgss).reverse().toString();

		if (rdgss.equals(rpgss))
		{
			return GameSeventySevenWinCategory.FIRST_CLASS;
		}

		String drawnSubstring = rdgss.substring(0, 6);
		String playedSubstring = rpgss.substring(0, 6);

		if (drawnSubstring.equals(playedSubstring))
		{
			return GameSeventySevenWinCategory.SECOND_CLASS;
		}

		drawnSubstring = rdgss.substring(0, 5);
		playedSubstring = rpgss.substring(0, 5);

		if (drawnSubstring.equals(playedSubstring))
		{
			return GameSeventySevenWinCategory.THIRD_CLASS;
		}

		drawnSubstring = rdgss.substring(0, 4);
		playedSubstring = rpgss.substring(0, 4);

		if (drawnSubstring.equals(playedSubstring))
		{
			return GameSeventySevenWinCategory.FOURTH_CLASS;
		}

		drawnSubstring = rdgss.substring(0, 3);
		playedSubstring = rpgss.substring(0, 3);

		if (drawnSubstring.equals(playedSubstring))
		{
			return GameSeventySevenWinCategory.FIFTH_CLASS;
		}

		drawnSubstring = rdgss.substring(0, 2);
		playedSubstring = rpgss.substring(0, 2);

		if (drawnSubstring.equals(playedSubstring))
		{
			return GameSeventySevenWinCategory.SIXTH_CLASS;
		}

		drawnSubstring = rdgss.substring(0, 1);
		playedSubstring = rpgss.substring(0, 1);

		if (drawnSubstring.equals(playedSubstring))
		{
			return GameSeventySevenWinCategory.SEVENTH_CLASS;
		}
		return GameSeventySevenWinCategory.BLANK;
	}

	/** The last numbers that equal the seventy seven numbers  */
	Integer equalNumbers;
	/** The fixed winning units is for win categories that have fixed winning units */
	Integer fixedWinningUnits;

}
