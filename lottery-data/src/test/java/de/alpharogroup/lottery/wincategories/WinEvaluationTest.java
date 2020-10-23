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

import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link WinEvaluation}
 */
public class WinEvaluationTest
{

	/**
	 * Test method for creation of object {@link WinEvaluation}
	 */
	@Test
	public void testObjectCreation()
	{
		WinEvaluation<LotteryWinCategory> object;
		WinEvaluation<LotteryWinCategory> other;
		object = WinEvaluation.<LotteryWinCategory> builder().build();
		assertNotNull(object);
		other = new WinEvaluation<>(2.0, LotteryWinCategory.EIGHTH_CLASS);
		assertNotNull(other);
		object = new WinEvaluation<>();
		assertNotNull(object);
		int hashCode = object.hashCode();
		assertNotNull(hashCode);
		String toString = object.toString();
		assertNotNull(toString);
		boolean equals = object.equals(other);
		assertNotNull(equals);

	}

}
