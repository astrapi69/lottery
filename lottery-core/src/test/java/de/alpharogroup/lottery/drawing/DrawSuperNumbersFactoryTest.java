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

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.math.MathExtensions;
import org.testng.annotations.Test;

import java.util.Set;

import static org.junit.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DrawSuperNumbersFactoryTest
{

	/**
	 * Test method for {@link DrawSuperNumbersFactory#drawSuperNumber(Set, int)}.
	 */
	@Test
	public void testDrawSuperNumber()
	{
		Set<Integer> alreadyDrawnNumbers = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		int superNumber = DrawSuperNumbersFactory.drawSuperNumber(alreadyDrawnNumbers, 49);
		assertFalse(alreadyDrawnNumbers.contains(superNumber));
		assertTrue(MathExtensions.isBetween(1, 49, superNumber, true, true));
	}

}
