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

import org.testng.annotations.Test;

import de.alpharogroup.collections.CollectionExtensions;
import de.alpharogroup.collections.list.ListFactory;

/**
 * The unit test class for the class {@link CombinationResolver}.
 */
public class CombinationResolverTest
{

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
	public void testGetCombinations()
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
		assertTrue(CollectionExtensions.isEqualCollection(actual, expected));
		// new scenario...
		values = ListFactory.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
		actual = CombinationResolver.getCombinations(values, 3);
		assertEquals(actual.size(), 165);
	}

	/**
	 * Test the method {@link CombinationResolver#getAllPossibleCombinationsCount(int, int)}
	 */
	@Test
	public void testGgetAllPossibleCombinationsCount()
	{
		List<Integer> values;
		long actual;
		long expected;
		// new scenario...
		expected = 4;
		values = ListFactory.newArrayList(1, 2, 3, 4);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 3);
		assertEquals(actual, expected);
		// new scenario...
		expected = 10;
		values = ListFactory.newArrayList(1, 2, 3, 4, 5);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 3);
		assertEquals(actual, expected);
		// new scenario...
		expected = 7;
		values = ListFactory.newArrayList(1, 2, 3, 4, 5, 6, 7);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 6);
		assertEquals(actual, expected);
		// new scenario...
		expected = 165;
		values = ListFactory.newRangeList(1, 11);
		actual = CombinationResolver.getAllPossibleCombinationsCount(values.size(), 3);
		assertEquals(actual, expected);
	}

}