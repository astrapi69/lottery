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
package de.alpharogroup.lottery.ticket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Set;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.evaluators.SilentEqualsHashCodeAndToStringEvaluator;
import de.alpharogroup.lottery.box.LotteryBox;
import de.alpharogroup.lottery.gameseventyseven.GameSeventySeven;

/**
 * The unit test class for the class {@link LotteryTicket}.
 */
public class LotteryTicketTest
{

	/**
	 * Test method for {@link LotteryTicket#equals(Object)} , {@link LotteryTicket#hashCode()} and
	 * {@link LotteryTicket#toString()}
	 */
	@Test
	public void testEqualsHashcodeAndToStringWithClassSilently()
	{
		boolean expected;
		boolean actual;
		actual = SilentEqualsHashCodeAndToStringEvaluator
			.evaluateEqualsHashcodeAndToStringQuietly(LotteryTicket.class);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for creation of object {@link LotteryTicket}
	 */
	@Test
	public void testObjectCreation()
	{
		LotteryTicket object = LotteryTicket.builder().build();
		assertNotNull(object);

		/** The id. */
		String id = "fooid";

		Set<LotteryBox> lotteryBoxes = SetFactory.newHashSet(
			LotteryBox.builder().selectedNumbers(SetFactory.newHashSet(1, 2, 3, 4, 5, 6)).build());

		GameSeventySeven gameSeventySeven = GameSeventySeven.builder().build();

		/** The super six number. */
		Integer superSixNumber = 6;

		/** The super number. */
		Integer superNumber = 23;

		object = new LotteryTicket(gameSeventySeven, id, lotteryBoxes, superNumber, superSixNumber);
		assertNotNull(object);
	}

	/**
	 * Test method for {@link LotteryTicket}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(LotteryTicket.class);
	}

}
