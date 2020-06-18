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
package de.alpharogroup.lottery.computation;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import de.alpharogroup.lottery.wincategories.LotteryWinCategory;
import de.alpharogroup.lottery.wincategories.WinEvaluation;

public class UnitEstimationExtensionsTest
{


	@Test(enabled = true)
	public void testCalculateLotteryPot()
	{
		double actual;
		double expected;
		WinEvaluation<LotteryWinCategory> winEvaluation;
		Map<LotteryWinCategory, WinEvaluation<LotteryWinCategory>> lotteryWinCategoryWinEvaluationMap = UnitEstimationExtensions
			.calculateLotteryPot(100000000.0d, 7200000.0d);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.FIRST_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 12800000.0d;
		assertEquals(actual, expected);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.SECOND_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 8000000.0d;
		assertEquals(actual, expected);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.THIRD_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 4000000.0d;
		assertEquals(actual, expected);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.FOURTH_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 12000000.0d;
		assertEquals(actual, expected);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.FIFTH_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 4000000.0d;
		assertEquals(actual, expected);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.SIXTH_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 8000000.0d;
		assertEquals(actual, expected);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.SEVENTH_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 8000000.0d;
		assertEquals(actual, expected);

		winEvaluation = lotteryWinCategoryWinEvaluationMap.get(LotteryWinCategory.EIGHTH_CLASS);

		actual = winEvaluation.getEvaluationOfUnitsResult();
		expected = 36000000.0d;
		assertEquals(actual, expected);

	}

}