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

import java.util.LinkedHashMap;
import java.util.Map;

import de.alpharogroup.lottery.wincategories.LotteryWinCategory;
import de.alpharogroup.lottery.wincategories.WinEvaluation;

public final class UnitEstimationExtensions
{
	public static Map<LotteryWinCategory, WinEvaluation<LotteryWinCategory>> calculateFromSecondTillEighthClass(
		double restUnitsOfPot)
	{
		Map<LotteryWinCategory, WinEvaluation<LotteryWinCategory>> map = new LinkedHashMap<>();
		map.put(LotteryWinCategory.SECOND_CLASS, getSecondClassPortion(restUnitsOfPot));
		map.put(LotteryWinCategory.THIRD_CLASS, getThirdClassPortion(restUnitsOfPot));
		map.put(LotteryWinCategory.FOURTH_CLASS, getFourthClassPortion(restUnitsOfPot));
		map.put(LotteryWinCategory.FIFTH_CLASS, getFifthClassPortion(restUnitsOfPot));
		map.put(LotteryWinCategory.SIXTH_CLASS, getSixthClassPortion(restUnitsOfPot));
		map.put(LotteryWinCategory.SEVENTH_CLASS, getSeventhClassPortion(restUnitsOfPot));
		map.put(LotteryWinCategory.EIGHTH_CLASS, getEighthClassPortion(restUnitsOfPot));
		return map;
	}

	public static Map<LotteryWinCategory, WinEvaluation<LotteryWinCategory>> calculateLotteryPot(
		double unitsInPot, double unitsOfWinClassNine)
	{
		WinEvaluation<LotteryWinCategory> firstClassPortionWinEvaluation = getFirstClassPortion(
			unitsInPot);
		double firstClassPortion = firstClassPortionWinEvaluation.getEvaluationOfUnitsResult();
		double restUnitsOfPot = unitsInPot - firstClassPortion;
		double potForSecondTillEighthClass = calculatePotForSecondTillEighthClass(restUnitsOfPot,
			unitsOfWinClassNine);
		Map<LotteryWinCategory, WinEvaluation<LotteryWinCategory>> lotteryWinCategoryWinEvaluationMap = calculateFromSecondTillEighthClass(
			potForSecondTillEighthClass);
		lotteryWinCategoryWinEvaluationMap.put(LotteryWinCategory.FIRST_CLASS,
			firstClassPortionWinEvaluation);
		return lotteryWinCategoryWinEvaluationMap;
	}

	public static double calculatePotForSecondTillEighthClass(double restUnitsOfPot,
		double unitsOfWinClassNine)
	{
		return restUnitsOfPot - unitsOfWinClassNine;
	}

	public static WinEvaluation<LotteryWinCategory> getEighthClassPortion(double restUnitsOfPot)
	{
		double portion = percentageOf(restUnitsOfPot, 45.0);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.EIGHTH_CLASS).evaluationOfUnitsResult(portion).build();
	}

	public static WinEvaluation<LotteryWinCategory> getFifthClassPortion(double restUnitsOfPot)
	{
		double portion = percentageOf(restUnitsOfPot, 5.0);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.FIFTH_CLASS).evaluationOfUnitsResult(portion).build();
	}

	public static WinEvaluation<LotteryWinCategory> getFirstClassPortion(double unitsInPot)
	{
		double portion = percentageOf(unitsInPot, 12.8);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.FIRST_CLASS).evaluationOfUnitsResult(portion).build();
	}

	public static WinEvaluation<LotteryWinCategory> getFourthClassPortion(double restUnitsOfPot)
	{
		double portion = percentageOf(restUnitsOfPot, 15.0);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.FOURTH_CLASS).evaluationOfUnitsResult(portion).build();
	}

	public static WinEvaluation<LotteryWinCategory> getSecondClassPortion(double restUnitsOfPot)
	{
		double portion = percentageOf(restUnitsOfPot, 10.0);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.SECOND_CLASS).evaluationOfUnitsResult(portion).build();
	}

	public static WinEvaluation<LotteryWinCategory> getSeventhClassPortion(double restUnitsOfPot)
	{
		double portion = percentageOf(restUnitsOfPot, 10.0);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.SEVENTH_CLASS).evaluationOfUnitsResult(portion).build();
	}

	public static WinEvaluation<LotteryWinCategory> getSixthClassPortion(double restUnitsOfPot)
	{
		double portion = percentageOf(restUnitsOfPot, 10.0);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.SIXTH_CLASS).evaluationOfUnitsResult(portion).build();
	}

	public static WinEvaluation<LotteryWinCategory> getThirdClassPortion(double restUnitsOfPot)
	{
		double portion = percentageOf(restUnitsOfPot, 5.0);
		return WinEvaluation.<LotteryWinCategory> builder()
			.winCategory(LotteryWinCategory.THIRD_CLASS).evaluationOfUnitsResult(portion).build();
	}

	/**
	 * Calculates the percentage of the given value
	 *
	 * @param value
	 *            The value
	 * @param percentage
	 *            The percentage
	 * @return the result of the percentage of the given value
	 */
	public static double percentageOf(double value, double percentage)
	{
		return percentage * value / 100;
	}

	private UnitEstimationExtensions()
	{
	}

}
