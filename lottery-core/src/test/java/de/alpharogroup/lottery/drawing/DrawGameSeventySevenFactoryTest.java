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

import static org.testng.Assert.assertTrue;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.math.MathExtensions;

/**
 * The unit test class for the class {@link DrawGameSeventySevenFactory}
 */
public class DrawGameSeventySevenFactoryTest
{
	/**
	 * Test method for {@link DrawGameSeventySevenFactory#drawGameSeventySeven()}
	 */
	@Test
	public void testDrawGameSeventySeven()
	{
		int actual;
		actual = DrawGameSeventySevenFactory.drawGameSeventySeven();
		assertTrue(MathExtensions.isBetween(0, 9999999, actual, true, true));
	}

	/**
	 * Test method for {@link DrawGameSeventySevenFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawGameSeventySevenFactory.class);
	}

}
