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
package de.alpharogroup.lottery.gameseventyseven;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link GameSeventySeven}.
 */
public class GameSeventySevenTest
{

	/**
	 * Test method for creation of object {@link GameSeventySeven}
	 */
	@Test
	public void testObjectCreation()
	{
		int expected;
		int actual;
		GameSeventySeven object = GameSeventySeven.builder().number(1236547).build();
		assertNotNull(object);
		Integer number = 1236547;
		object = new GameSeventySeven(number);
		assertNotNull(object);
		expected = number;
		actual = object.getNumber();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GameSeventySeven}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(GameSeventySeven.class);
	}

	/**
	 * Test method for {@link GameSeventySeven#equals(Object)} , {@link GameSeventySeven#hashCode()}
	 * and {@link GameSeventySeven#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(GameSeventySeven.class).verify();
	}

}
