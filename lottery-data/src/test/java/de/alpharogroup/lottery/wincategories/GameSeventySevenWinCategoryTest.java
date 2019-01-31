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

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

/**
 * The class {@link GameSeventySevenWinCategory}.
 */
public class GameSeventySevenWinCategoryTest
{

	/**
	 * Test method for
	 * {@link GameSeventySevenWinCategory#getGameSeventySevenWinCategory(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public void testGetGameSeventySevenWinCategory() throws Exception
	{
		GameSeventySevenWinCategory expected;
		GameSeventySevenWinCategory actual;

		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 7777777);
		expected = GameSeventySevenWinCategory.FIRST_CLASS;
		assertEquals(actual, expected);

		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 777777);
		expected = GameSeventySevenWinCategory.SECOND_CLASS;
		assertEquals(actual, expected);

		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 77777);
		expected = GameSeventySevenWinCategory.THIRD_CLASS;
		assertEquals(actual, expected);

		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 7777);
		expected = GameSeventySevenWinCategory.FOURTH_CLASS;
		assertEquals(actual, expected);
		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 777);
		expected = GameSeventySevenWinCategory.FIFTH_CLASS;
		assertEquals(actual, expected);

		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 77);
		expected = GameSeventySevenWinCategory.SIXTH_CLASS;
		assertEquals(actual, expected);

		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 7);
		expected = GameSeventySevenWinCategory.SEVENTH_CLASS;
		assertEquals(actual, expected);

		actual = GameSeventySevenWinCategory.getGameSeventySevenWinCategory(7777777, 1);
		expected = GameSeventySevenWinCategory.NONE;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for creation of object {@link LotteryWinCategory}
	 */
	@Test
	public void testObjectCreation()
	{
		Integer expected;
		Integer actual;
		GameSeventySevenWinCategory object = GameSeventySevenWinCategory.FIFTH_CLASS;
		assertNotNull(object);

		expected = 3;
		actual = object.getEqualNumbers();
		assertEquals(expected, actual);
	}

}
