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
package de.alpharogroup.lottery.box;

import static org.testng.Assert.assertNotNull;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;
import de.alpharogroup.lottery.enums.LotteryGameType;

/**
 * The unit test class for the class {@link LotteryBox}.
 */
public class LotteryBoxTest
{

	/**
	 * Test method for creation of object {@link LotteryBox}
	 */
	@Test
	public void testObjectCreation()
	{
		LotteryBox object;
		object = LotteryBox.builder().build();
		assertNotNull(object);
		object = new LotteryBox(LotteryGameType.SIX_OF_FOURTYNINE_NORMAL, 1,
			SetFactory.newHashSet(1, 2, 3, 4, 5, 6), null);
		assertNotNull(object);
		object = new LotteryBox();
		assertNotNull(object);
	}

	/**
	 * Test method for {@link LotteryBox}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(LotteryBox.class);
	}

	/**
	 * Test method for {@link LotteryBox#equals(Object)} , {@link LotteryBox#hashCode()} and
	 * {@link LotteryBox#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(LotteryBox.class).verify();
	}

}
