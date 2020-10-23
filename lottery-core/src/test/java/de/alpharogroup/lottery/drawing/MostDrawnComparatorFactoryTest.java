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
package de.alpharogroup.lottery.drawing;

import static org.testng.Assert.assertNotNull;

import java.util.Comparator;
import java.util.Map;

import org.testng.annotations.Test;

import de.alpharogroup.collections.map.MapFactory;

/**
 * The unit test class for the class {@link MostDrawnComparatorFactory}
 */
public class MostDrawnComparatorFactoryTest
{

	/**
	 * Test method for
	 * {@link MostDrawnComparatorFactory#newMostDrawnComparator(int, int, int, int, boolean, boolean, Map)}
	 */
	@Test
	public void testNewMostDrawnComparator()
	{
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;
		boolean mostDrawn;
		boolean paranoid;
		Map<Integer, Integer> numberCounterMap;
		Comparator<Integer> comparator;
		// new scenario...

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		mostDrawn = true;
		paranoid = false;
		numberCounterMap = MapFactory.newNumberCounterMap(minVolume, maxVolume);

		comparator = MostDrawnComparatorFactory.newMostDrawnComparator(maxNumbers, minVolume,
			maxVolume, drawCount, mostDrawn, paranoid, numberCounterMap);
		assertNotNull(comparator);
	}

}
