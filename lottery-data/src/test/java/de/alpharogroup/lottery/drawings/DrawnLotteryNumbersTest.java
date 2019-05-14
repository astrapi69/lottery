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
package de.alpharogroup.lottery.drawings;

import static org.testng.Assert.assertNotNull;

import java.util.Set;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link DrawnLotteryNumbers}.
 */
public class DrawnLotteryNumbersTest
{

	/**
	 * Test method for creation of object {@link DrawnLotteryNumbers}
	 */
	@Test
	public void testObjectCreation()
	{
		DrawnLotteryNumbers object = DrawnLotteryNumbers.builder().build();
		assertNotNull(object);
		/** The id. */
		Integer id = 1;

		/** The lucky lottery numbers. */
		Set<Integer> lotteryNumbers = SetFactory.newTreeSet(3, 7, 22, 23, 34, 45);

		/** The super six number. */
		Integer superSixNumber = 4;

		/** The super number. */
		Integer superNumber = 8;

		object = new DrawnLotteryNumbers(id, lotteryNumbers, superSixNumber, superNumber);
		assertNotNull(object);
	}

	/**
	 * Test method for {@link DrawnLotteryNumbers}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawnLotteryNumbers.class);
	}

	/**
	 * Test method for {@link DrawnLotteryNumbers#equals(Object)} ,
	 * {@link DrawnLotteryNumbers#hashCode()} and {@link DrawnLotteryNumbers#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(DrawnLotteryNumbers.class).verify();
	}

}
