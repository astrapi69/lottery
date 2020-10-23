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
package de.alpharogroup.lottery.combinations;

import java.util.List;
import java.util.Set;

import org.apache.commons.math3.util.CombinatoricsUtils;

import de.alpharogroup.check.Argument;
import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.set.SetExtensions;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.lottery.box.DoubleSetBox;

public final class CombinationResolver
{

	/**
	 * Compute in recursive manner all combinations of the given arguments
	 *
	 * @param allCombinations
	 *            the all combinations
	 * @param possibleNumbers
	 *            the possible numbers
	 * @param currentCombination
	 *            the current combination
	 * @param currentStart
	 *            the current start
	 * @param currentEnd
	 *            the current end
	 * @param currentCombinationIndex
	 *            the current combination index
	 * @param combinationSize
	 *            the combination size
	 */
	private static void computeAllCombinations(List<List<Integer>> allCombinations,
		List<Integer> possibleNumbers, Integer[] currentCombination, int currentStart,
		int currentEnd, int currentCombinationIndex, int combinationSize)
	{
		if (currentCombinationIndex == combinationSize)
		{
			allCombinations.add(ListFactory.newArrayList(currentCombination));
			return;
		}

		for (int i = currentStart; i <= currentEnd
			&& currentEnd - i + 1 >= combinationSize - currentCombinationIndex; i++)
		{
			currentCombination[currentCombinationIndex] = possibleNumbers.get(i);
			computeAllCombinations(allCombinations, possibleNumbers, currentCombination, i + 1,
				currentEnd, currentCombinationIndex + 1, combinationSize);
		}
	}

	/**
	 * Gets all possible combinations from the given list of {@link Integer} objects
	 *
	 * @param possibleNumbers
	 *            the possible numbers
	 * @param combinationSize
	 *            the size of the combination to generate
	 * @return all possible combinations from the given list of {@link Integer} objects
	 */
	public static List<List<Integer>> getAllCombinations(final List<Integer> possibleNumbers,
		int combinationSize)
	{
		Argument.notNull(possibleNumbers, "possibleNumbers");
		Integer[] currentCombination = new Integer[combinationSize];
		List<List<Integer>> allCombinations = ListFactory.newArrayList();
		int currentEnd = possibleNumbers.size() - 1;
		int currentStart = 0;
		int currentCombinationIndex = 0;
		computeAllCombinations(allCombinations, possibleNumbers, currentCombination, currentStart,
			currentEnd, currentCombinationIndex, combinationSize);
		return allCombinations;
	}

	/**
	 * Gets the count of all possible combinations from the given size of the set of possible
	 * numbers and the given size of the subset to be counted.
	 *
	 * Note:<br>
	 * <br>
	 *
	 * uses internally the method of <code>
	 *  	    org.apache.commons.math3.util.CombinatoricsUtils#binomialCoefficient(int, int)
	 *  	</code>
	 *
	 * @param possibleNumbers
	 *            the size of possible numbers
	 * @param combinationSize
	 *            the size of a single combination
	 * @return an exact representation of the Binomial Coefficient, "n choose k", the number of
	 *         k-element subsets that can be selected from an n-element set.
	 */
	public static long getAllPossibleCombinationsCount(int possibleNumbers, int combinationSize)
	{
		return CombinatoricsUtils.binomialCoefficient(possibleNumbers, combinationSize);
	}

	/**
	 * Gets the count of all possible combinations from the given size of the set of first and
	 * second possible numbers and the given first and second size of the subset to be counted.
	 *
	 * One possible comparision is the lottery game eurojackpot that have 5 of 50 numbers and 2 of
	 * 10 numbers. So how many combination are there totally. So in this example you give as first
	 * argument 50, the second is 5, the third is 10 and the last argument is 2. The return value is
	 * 95344200 and relates to all possible combinations that provides the lottery game.
	 *
	 * Note:<br>
	 * <br>
	 *
	 * uses internally the method of <code>
	 *  	    org.apache.commons.math3.util.CombinatoricsUtils#binomialCoefficient(int, int)
	 *  	</code>
	 *
	 * @param firstPossibleNumbers
	 *            the size of first possible numbers
	 * @param firstCombinationSize
	 *            the size from the first combination of a single combination
	 * @param secondPossibleNumbers
	 *            the size of second possible numbers
	 * @param secondCombinationSize
	 *            the size from the second combination of a single combination
	 * @return an exact representation of the Binomial Coefficient, "n choose k", the number of
	 *         k-element subsets that can be selected from an n-element set.
	 */
	public static long getAllPossibleCombinationsCount(int firstPossibleNumbers,
		int firstCombinationSize, int secondPossibleNumbers, int secondCombinationSize)
	{
		return CombinatoricsUtils.binomialCoefficient(firstPossibleNumbers, firstCombinationSize)
			* CombinatoricsUtils.binomialCoefficient(secondPossibleNumbers, secondCombinationSize);
	}

	/**
	 * Gets all possible combinations from the given list. This is useful if you have a lottery
	 * system game that a player can play more lottery entries at once. For instance: <br>
	 * <br>
	 * In the lottery game 6 of 49 you play 6 numbers for one possible combination If you play the
	 * system game you can mark for example 7 numbers. This resolves to 7 combinations of 6 numbers,
	 * so to get this 7 combinations of numbers you put the 7 numbers that the player plays in the
	 * list 'possibleValues' and as 'combinationSize' you have to put the number 6. 6 because of 6
	 * of 49. If the player chooses to play now 8 numbers it will resolve to 28 combinations of 6
	 * numbers, so to get this 28 combinations of numbers you put the 8 numbers that the player
	 * plays in the list 'possibleValues' and as 'combinationSize' you have to put again the number
	 * 6 because of the lottery game 6 of 49.
	 *
	 * @param <T>
	 *            the generic type of the elements in the list
	 * @param combinationSize
	 *            the size of the elements of the combinations to generate
	 * @param possibleValues
	 *            the list with the element values
	 * @return all possible combinations from the given list
	 */
	public static <T> List<List<T>> getCombinations(final List<T> possibleValues,
		final int combinationSize)
	{
		List<List<T>> combinations = ListFactory.newArrayList();
		if (combinationSize == 0)
		{
			combinations.add(ListFactory.newArrayList());
			return combinations;
		}
		for (int i = 0; i < possibleValues.size(); i++)
		{
			T element = possibleValues.get(i);
			List<T> rest = getPartialList(possibleValues, i + 1);
			for (List<T> previous : getCombinations(rest, combinationSize - 1))
			{
				previous.add(element);
				combinations.add(previous);
			}
		}
		return combinations;
	}

	/**
	 * Gets the partial list
	 *
	 * @param <T>
	 *            the generic type of the elements in the list
	 * @param list
	 *            the list
	 * @param i
	 *            the i
	 * @return the partial list
	 */
	private static <T> List<T> getPartialList(List<T> list, int i)
	{
		List<T> partialList = ListFactory.newArrayList();
		for (int j = i; j < list.size(); j++)
		{
			partialList.add(list.get(j));
		}
		return partialList;
	}

	public static <T> Set<DoubleSetBox<T>> getPossibleCombinations(final List<T> firstCollection,
		final int firstCollectionCombinationSize, final List<T> secondCollection,
		final int secondCollectionCombinationSize)
	{
		Set<DoubleSetBox<T>> doubleSetBoxes = SetFactory.newHashSet();
		List<List<T>> firstCollectioncombinations = getCombinations(firstCollection,
			firstCollectionCombinationSize);
		List<List<T>> secondCollectioncombinations = getCombinations(secondCollection,
			secondCollectionCombinationSize);
		for (List<T> fcc : firstCollectioncombinations)
		{
			for (List<T> scc : secondCollectioncombinations)
			{
				doubleSetBoxes
					.add(DoubleSetBox.<T> builder().firstCollection(SetExtensions.toSet(fcc))
						.secondCollection(SetExtensions.toSet(scc)).build());
			}
		}
		return doubleSetBoxes;
	}

}
