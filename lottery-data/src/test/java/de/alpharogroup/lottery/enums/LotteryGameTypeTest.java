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
package de.alpharogroup.lottery.enums;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link LotteryGameType}
 */
public class LotteryGameTypeTest
{

	/**
	 * Test method for the constant values of {@link LotteryGameType}
	 */
	@Test
	public void testValues()
	{
		String actual;
		String expected;

		actual = LotteryGameType.SIX_OF_FOURTYNINE_FULL_SYSTEM.name();
		expected = "SIX_OF_FOURTYNINE_FULL_SYSTEM";
		assertEquals(actual, expected);

		actual = LotteryGameType.SIX_OF_FOURTYNINE_NORMAL.name();
		expected = "SIX_OF_FOURTYNINE_NORMAL";
		assertEquals(actual, expected);

	}
}
