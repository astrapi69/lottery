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

import java.util.Map;

public final class DrawMerger
{
	/**
	 * Merges several drawings of lottery numbers from the given arguments
	 *
	 * @param maxNumbers
	 *            the maximum of numbers to draw
	 * @param minVolume
	 *            the min volume
	 * @param maxVolume
	 *            the max volume
	 * @param drawCount
	 *            the draw count defines how many times to draw numbers
	 * @param numberCounterMap
	 *            the counter map for generate statistics of the drawn lottery numbers
	 * @return the map with the merged lottery numbers
	 */
	public static Map<Integer, Integer> mergeDrawings(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, Map<Integer, Integer> numberCounterMap)
	{
		for (int i = 0; i < drawCount; i++)
		{
			DrawLotteryNumbersFactory.draw(maxNumbers, minVolume, maxVolume)
				.forEach(key -> numberCounterMap.merge(key, 1, Integer::sum));
		}
		return numberCounterMap;
	}

	private DrawMerger()
	{
	}
}
