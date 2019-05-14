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
/**
 *
 */
package de.alpharogroup.lottery.drawings;

import static org.testng.Assert.assertNotNull;

import java.util.Set;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link DrawnEuroMillionsNumbers}.
 */
public class DrawnEuroMillionsNumbersTest
{

	/**
	 * Test method for {@link DrawnEuroMillionsNumbers#equals(Object)} ,
	 * {@link DrawnEuroMillionsNumbers#hashCode()} and {@link DrawnEuroMillionsNumbers#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(DrawnEuroMillionsNumbers.class).verify();
	}

	/**
	 * Test method for creation of object {@link DrawnEuroMillionsNumbers}
	 */
	@Test
	public void testObjectCreation()
	{
		DrawnEuroMillionsNumbers object = DrawnEuroMillionsNumbers.builder().build();
		assertNotNull(object);
		/** The id. */
		Integer id = 1;

		/** The lucky lottery numbers. */
		Set<Integer> lotteryNumbers = SetFactory.newTreeSet(3, 7, 22, 23, 34);

		/** The super six number. */
		Set<Integer> starNumbers = SetFactory.newTreeSet(3, 7);

		object = new DrawnEuroMillionsNumbers(id, lotteryNumbers, starNumbers);
		assertNotNull(object);
	}

	/**
	 * Test method for {@link DrawnEuroMillionsNumbers}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawnEuroMillionsNumbers.class);
	}

}
