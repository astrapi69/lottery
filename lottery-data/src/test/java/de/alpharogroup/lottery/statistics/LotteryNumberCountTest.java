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
package de.alpharogroup.lottery.statistics;

import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * The unit test class for the class {@link LotteryNumberCount}
 */
public class LotteryNumberCountTest
{

	/**
	 * Test method for creation of object {@link LotteryNumberCount}
	 */
	@Test public void testObjectCreation()
	{
		LotteryNumberCount object;
		object = LotteryNumberCount.builder().build();
		assertNotNull(object);
		object = new LotteryNumberCount("SIX_OF_FOURTYNINE_FULL_SYSTEM", MapFactory.newHashMap());
		assertNotNull(object);
		object = new LotteryNumberCount();
		assertNotNull(object);
	}

	/**
	 * Test method for {@link LotteryNumberCount}
	 */
	@Test public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(LotteryNumberCount.class);
	}

	/**
	 * Test method for {@link LotteryNumberCount#equals(Object)} , {@link LotteryNumberCount#hashCode()} and
	 * {@link LotteryNumberCount#toString()}
	 */
	@Test public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(LotteryNumberCount.class).verify();
	}

}
