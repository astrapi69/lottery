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
package de.alpharogroup.lottery.played;

import static org.testng.Assert.assertNotNull;

import java.util.Set;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;
import de.alpharogroup.lottery.ticket.LotteryTicket;

/**
 * The unit test class for the class {@link PlayedLotteryTickets}.
 */
public class PlayedLotteryTicketsTest
{

	/**
	 * Test method for creation of object {@link PlayedLotteryTickets}
	 */
	@Test
	public void testObjectCreation()
	{
		PlayedLotteryTickets object = PlayedLotteryTickets.builder().build();
		assertNotNull(object);

		/** The user. */
		String user = "John Doe";

		/** The lottery tickets. */
		Set<LotteryTicket> lotteryTickets = SetFactory.newHashSet(LotteryTicket.builder().build());

		object = new PlayedLotteryTickets(lotteryTickets, user);
		assertNotNull(object);
	}

	/**
	 * Test method for {@link PlayedLotteryTickets}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(PlayedLotteryTickets.class);
	}

	/**
	 * Test method for {@link PlayedLotteryTickets#equals(Object)} ,
	 * {@link PlayedLotteryTickets#hashCode()} and {@link PlayedLotteryTickets#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(PlayedLotteryTickets.class).verify();
	}

}
