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
package de.alpharogroup.lottery.evaluation;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.alpharogroup.evaluate.object.evaluators.EqualsHashCodeAndToStringEvaluator;
import lombok.SneakyThrows;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.lottery.enums.LotteryGameType;

/**
 * The unit test class for the class {@link EvaluatedLotteryNumbers}.
 */
public class EvaluatedLotteryNumbersTest
{
	/**
	 * Test method for {@link EvaluatedLotteryNumbers#equals(Object)} ,
	 * {@link EvaluatedLotteryNumbers#hashCode()} and {@link EvaluatedLotteryNumbers#toString()}
	 */
	@Test
	@SneakyThrows
	public void testEqualsHashcodeAndToStringWithClassSilently()
	{
		boolean expected;
		boolean actual;
		actual = EqualsHashCodeAndToStringEvaluator
				.evaluateEqualsHashcodeAndToString(EvaluatedLotteryNumbers.class);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for creation of object {@link EvaluatedLotteryNumbers}
	 */
	@Test
	public void testObjectCreation()
	{
		EvaluatedLotteryNumbers object = EvaluatedLotteryNumbers.builder().build();
		assertNotNull(object);

		/** The id. */
		Integer id = 1;

		/** The played lottery numbers. */
		Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers = new HashMap<>();

		/** The evaluated super six number. */
		Integer wonSuperSixNumber = 1;

		/** The evaluated super number. */
		Integer wonSuperNumber = 1;

		/** The evaluated game seventy seven. */
		Integer wonGameSeventySevenNumber = 1;

		object = new EvaluatedLotteryNumbers(id, wonGameSeventySevenNumber, wonLotteryNumbers,
			wonSuperNumber, wonSuperSixNumber);
		assertNotNull(object);
	}

	/**
	 * Test method for {@link EvaluatedLotteryNumbers}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(EvaluatedLotteryNumbers.class);
	}

}
