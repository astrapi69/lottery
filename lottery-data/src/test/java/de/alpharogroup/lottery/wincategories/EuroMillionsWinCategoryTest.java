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

import de.alpharogroup.evaluate.object.evaluators.EqualsHashCodeAndToStringEvaluator;
import lombok.SneakyThrows;
import org.meanbean.factories.ObjectCreationException;
import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

/**
 * The unit test class for the class {@link EuroMillionsWinCategory}.
 */
public class EuroMillionsWinCategoryTest
{

	/**
	 * Test method for {@link EuroMillionsWinCategory#equals(Object)} ,
	 * {@link EuroMillionsWinCategory#hashCode()} and {@link EuroMillionsWinCategory#toString()}
	 */
	@Test
	@SneakyThrows
	public void testEqualsHashcodeAndToStringWithClassSilently()
	{
		boolean expected;
		boolean actual;

		actual = EqualsHashCodeAndToStringEvaluator
				.evaluateEqualsHashcodeAndToString(EuroMillionsWinCategory.class);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for creation of object {@link EuroMillionsWinCategory}
	 */
	@Test
	public void testObjectCreation()
	{
		EuroMillionsWinCategory object = EuroMillionsWinCategory.builder().build();
		assertNotNull(object);

		/** The quantity of winning numbers. */
		int quantityOfWonNumbers = 3;

		/** The quantity of winning star numbers. */
		int quantityOfWonStarNumbers = 2;

		/** The flag if the joker is selected. */
		boolean withJoker = false;

		/** The payout rate of this winning category. */
		double payoutRate = 0.1;

		/** The computation. */
		String computation = "foo";

		object = new EuroMillionsWinCategory(computation, payoutRate, quantityOfWonNumbers,
			quantityOfWonStarNumbers, withJoker);
		assertNotNull(object);
	}

	/**
	 * Test method for {@link EuroMillionsWinCategory}
	 */
	@Test(expectedExceptions = { ObjectCreationException.class, BeanTestException.class,
			NoSuchMethodException.class, UnsupportedOperationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(EuroMillionsWinCategory.class);
	}

}
