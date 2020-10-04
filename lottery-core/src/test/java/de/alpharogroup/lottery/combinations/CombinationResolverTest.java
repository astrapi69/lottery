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

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.List;
import java.util.Set;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.lottery.LotteryExtensions;
import de.alpharogroup.lottery.box.DoubleCollectionBox;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.CollectionExtensions;
import de.alpharogroup.collections.list.ListFactory;

/**
 * The unit test class for the class {@link CombinationResolver}.
 */
public class CombinationResolverTest
{

	/**
	 * Test the method {@link CombinationResolver#getPossibleCombinations(List, int, List, int)}
	 */
	@Test
	public void testGetPossibleCombinations() {
		List<Integer> firstCollection;
		int firstCollectionCombinationSize;
		List<Integer> secondCollection;
		int secondCollectionCombinationSize;
		Set<DoubleCollectionBox<Integer>> actual;
		Set<DoubleCollectionBox<Integer>> expected;
			// new scenario...
		firstCollection = ListFactory.newArrayList(1, 2, 3, 4, 5, 6);
		firstCollectionCombinationSize = 5;
		secondCollection = ListFactory.newArrayList(1, 2, 3);
		secondCollectionCombinationSize = 2;
		actual = CombinationResolver.getPossibleCombinations(firstCollection, firstCollectionCombinationSize,
			secondCollection, secondCollectionCombinationSize);
		expected = SetFactory.newHashSet();
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 2)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(2, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 2)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 5, 6))
			.secondCollection(SetFactory.newHashSet(2, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 4, 6))
			.secondCollection(SetFactory.newHashSet(1, 2)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 4, 6))
			.secondCollection(SetFactory.newHashSet(1, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 4, 6))
			.secondCollection(SetFactory.newHashSet(2, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 4, 5))
			.secondCollection(SetFactory.newHashSet(1, 2)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 4, 5))
			.secondCollection(SetFactory.newHashSet(1, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 2, 3, 4, 5))
			.secondCollection(SetFactory.newHashSet(2, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(2, 3, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 2)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(2, 3, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(2, 3, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(2, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 3, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 2)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 3, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(1, 3)).build());
		expected.add(DoubleCollectionBox
			.<Integer>builder()
			.firstCollection(SetFactory.newHashSet(1, 3, 4, 5, 6))
			.secondCollection(SetFactory.newHashSet(2, 3)).build());
		assertEquals(18, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
	}

	/**
	 * Test the method {@link CombinationResolver#getAllCombinations(List, int)}
	 */
	@Test
	public void testGetAllCombinations()
	{
		List<Integer> values;
		List<List<Integer>> actual;
		List<List<Integer>> expected;
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList(1, 2, 3, 4);
		actual = CombinationResolver.getAllCombinations(values, 3);
		expected.add(ListFactory.newArrayList(1, 2, 3));
		expected.add(ListFactory.newArrayList(1, 2, 4));
		expected.add(ListFactory.newArrayList(1, 3, 4));
		expected.add(ListFactory.newArrayList(2, 3, 4));
		assertEquals(4, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList(1, 2, 3, 4, 5);
		actual = CombinationResolver.getAllCombinations(values, 3);
		expected.add(ListFactory.newArrayList(1, 2, 3));
		expected.add(ListFactory.newArrayList(1, 2, 4));
		expected.add(ListFactory.newArrayList(1, 2, 5));
		expected.add(ListFactory.newArrayList(1, 3, 4));
		expected.add(ListFactory.newArrayList(1, 3, 5));
		expected.add(ListFactory.newArrayList(1, 4, 5));
		expected.add(ListFactory.newArrayList(2, 3, 4));
		expected.add(ListFactory.newArrayList(2, 3, 5));
		expected.add(ListFactory.newArrayList(2, 4, 5));
		expected.add(ListFactory.newArrayList(3, 4, 5));
		assertEquals(10, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList(1, 2, 3, 4, 5, 6, 7);
		actual = CombinationResolver.getAllCombinations(values, 6);
		expected.add(ListFactory.newArrayList(1, 2, 3, 4, 5, 6));
		expected.add(ListFactory.newArrayList(1, 2, 3, 4, 5, 7));
		expected.add(ListFactory.newArrayList(1, 2, 3, 4, 6, 7));
		expected.add(ListFactory.newArrayList(1, 2, 3, 5, 6, 7));
		expected.add(ListFactory.newArrayList(1, 2, 4, 5, 6, 7));
		expected.add(ListFactory.newArrayList(1, 3, 4, 5, 6, 7));
		expected.add(ListFactory.newArrayList(2, 3, 4, 5, 6, 7));
		assertEquals(7, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		values = ListFactory.newRangeList(1, 11);
		actual = CombinationResolver.getAllCombinations(values, 3);
		assertEquals(actual.size(), 165);
	}

	/**
	 * Test the method {@link CombinationResolver#getCombinations(List, int)}
	 */
	@Test
	public void testGetCombinationsWithStringList()
	{
		List<String> values;
		List<List<String>> actual;
		List<List<String>> expected;
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList("1", "2", "3", "4");
		actual = CombinationResolver.getCombinations(values, 3);
		expected.add(ListFactory.newArrayList("1", "2", "3"));
		expected.add(ListFactory.newArrayList("1", "2", "4"));
		expected.add(ListFactory.newArrayList("1", "3", "4"));
		expected.add(ListFactory.newArrayList("2", "3", "4"));
		assertEquals(4, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList("1", "2", "3", "4", "5");
		actual = CombinationResolver.getCombinations(values, 3);
		expected.add(ListFactory.newArrayList("1", "2", "3"));
		expected.add(ListFactory.newArrayList("1", "2", "4"));
		expected.add(ListFactory.newArrayList("1", "2", "5"));
		expected.add(ListFactory.newArrayList("1", "3", "4"));
		expected.add(ListFactory.newArrayList("1", "3", "5"));
		expected.add(ListFactory.newArrayList("1", "4", "5"));
		expected.add(ListFactory.newArrayList("2", "3", "4"));
		expected.add(ListFactory.newArrayList("2", "3", "5"));
		expected.add(ListFactory.newArrayList("2", "4", "5"));
		expected.add(ListFactory.newArrayList("3", "4", "5"));
		assertEquals(10, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList("1", "2", "3", "4", "5", "6", "7");
		actual = CombinationResolver.getCombinations(values, 6);
		expected.add(ListFactory.newArrayList("1", "2", "3", "4", "5", "6"));
		expected.add(ListFactory.newArrayList("1", "2", "3", "4", "5", "7"));
		expected.add(ListFactory.newArrayList("1", "2", "3", "4", "6", "7"));
		expected.add(ListFactory.newArrayList("1", "2", "3", "5", "6", "7"));
		expected.add(ListFactory.newArrayList("1", "2", "4", "5", "6", "7"));
		expected.add(ListFactory.newArrayList("1", "3", "4", "5", "6", "7"));
		expected.add(ListFactory.newArrayList("2", "3", "4", "5", "6", "7"));
		assertEquals(7, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		values = ListFactory.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
		actual = CombinationResolver.getCombinations(values, 3);
		assertEquals(actual.size(), 165);
	}

	/**
	 * Test the method {@link CombinationResolver#getCombinations(List, int)}
	 */
	@Test
	public void testGetCombinationsWithIntegerList()
	{
		List<Integer> values;
		List<List<Integer>> actual;
		List<List<Integer>> expected;
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList(1, 2, 3, 4);
		actual = CombinationResolver.getCombinations(values, 3);
		expected.add(ListFactory.newArrayList(1, 2, 3));
		expected.add(ListFactory.newArrayList(1, 2, 4));
		expected.add(ListFactory.newArrayList(1, 3, 4));
		expected.add(ListFactory.newArrayList(2, 3, 4));
		assertEquals(4, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList(1, 2, 3, 4, 5);
		actual = CombinationResolver.getCombinations(values, 3);
		expected.add(ListFactory.newArrayList(1, 2, 3));
		expected.add(ListFactory.newArrayList(1, 2, 4));
		expected.add(ListFactory.newArrayList(1, 2, 5));
		expected.add(ListFactory.newArrayList(1, 3, 4));
		expected.add(ListFactory.newArrayList(1, 3, 5));
		expected.add(ListFactory.newArrayList(1, 4, 5));
		expected.add(ListFactory.newArrayList(2, 3, 4));
		expected.add(ListFactory.newArrayList(2, 3, 5));
		expected.add(ListFactory.newArrayList(2, 4, 5));
		expected.add(ListFactory.newArrayList(3, 4, 5));
		assertEquals(10, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		expected = ListFactory.newArrayList();
		values = ListFactory.newArrayList(1, 2, 3, 4, 5, 6, 7);
		actual = CombinationResolver.getCombinations(values, 6);
		expected.add(ListFactory.newArrayList(1, 2, 3, 4, 5, 6));
		expected.add(ListFactory.newArrayList(1, 2, 3, 4, 5, 7));
		expected.add(ListFactory.newArrayList(1, 2, 3, 4, 6, 7));
		expected.add(ListFactory.newArrayList(1, 2, 3, 5, 6, 7));
		expected.add(ListFactory.newArrayList(1, 2, 4, 5, 6, 7));
		expected.add(ListFactory.newArrayList(1, 3, 4, 5, 6, 7));
		expected.add(ListFactory.newArrayList(2, 3, 4, 5, 6, 7));
		assertEquals(7, actual.size());
		assertEquals(expected.size(), actual.size());
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		values = ListFactory.newRangeList(1, 11);
		actual = CombinationResolver.getCombinations(values, 3);
		assertEquals(actual.size(), 165);
		// new scenario...
		values = ListFactory.newRangeList(1, 8);
		actual = CombinationResolver.getCombinations(values, 6);
		assertEquals(actual.size(), 28);
	}

	/**
	 * Test the method {@link CombinationResolver#getAllPossibleCombinationsCount(int, int, int, int)}
	 */
	@Test
	public void testGetAllPossibleCombinationsCountWithFourParams(){

		List<Integer> firstValues;
		List<Integer> secondValues;
		long actual;
		long expected;
		// new scenario...
		firstValues = ListFactory.newArrayList(1, 2, 3, 4, 5);
		secondValues = ListFactory.newArrayList(1, 2, 3);
		actual = CombinationResolver.getAllPossibleCombinationsCount(firstValues.size(), 3,
			secondValues.size(), 2);
		expected = 30;
		assertEquals(actual, expected);
	}

	/**
	 * Test the method {@link CombinationResolver#getAllPossibleCombinationsCount(int, int)}
	 */
	@Test
	public void testGetAllPossibleCombinationsCount()
	{
		List<Integer> values;
		long actual;
		long expected;
		// new scenario...
		values = ListFactory.newArrayList(1, 2, 3, 4);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 3);
		expected = 4;
		assertEquals(actual, expected);
		// new scenario...
		values = ListFactory.newArrayList(1, 2, 3, 4, 5);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 3);
		expected = 10;
		assertEquals(actual, expected);
		// new scenario...
		values = ListFactory.newArrayList(1, 2, 3, 4, 5, 6, 7);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 6);
		expected = 7;
		assertEquals(actual, expected);
		// new scenario...
		values = ListFactory.newRangeList(1, 11);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 3);
		expected = 165;
		assertEquals(actual, expected);
		// new scenario...
		// for lottery 6 of 49 for the numbers
		values = ListFactory.newRangeList(1, 49);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 6);
		expected = 13983816;
		assertEquals(actual, expected);
		// new scenario...
		// for eurojackpot for the numbers
		values = ListFactory.newRangeList(1, 50);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 5);
		expected = 2118760;
		assertEquals(actual, expected);
		// new scenario...
		// for eurojackpot for the star numbers
		values = ListFactory.newRangeList(1, 10);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 2);
		expected = 45;
		assertEquals(actual, expected);

		// new scenario...
		// compute the probability of eurojackpot
		long allPossibleCombinationsEurojackpotCount = CombinationResolver
			.getAllPossibleCombinationsCount(ListFactory.newRangeList(1, 50).size(), 5);
		long allPossibleCombinationsEurojackpotStarNumbersCount = CombinationResolver
			.getAllPossibleCombinationsCount(values.size(), 2);
		actual = allPossibleCombinationsEurojackpotCount
			* allPossibleCombinationsEurojackpotStarNumbersCount;
		expected = 95344200;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link CombinationResolver} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(CombinationResolver.class);
	}

}
