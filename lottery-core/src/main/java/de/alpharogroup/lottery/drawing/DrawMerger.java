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

import java.security.SecureRandom;
import java.util.Map;

import de.alpharogroup.lottery.drawings.DrawModelBean;
import de.alpharogroup.random.DefaultSecureRandom;

public final class DrawMerger
{
	private DrawMerger()
	{
	}

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
		return mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap,
			DefaultSecureRandom.get());
	}

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
	 * @param secureRandom
	 *            the secure random object for random generation
	 * @return the map with the merged lottery numbers
	 */
	public static Map<Integer, Integer> mergeDrawings(int maxNumbers, int minVolume, int maxVolume,
		int drawCount, Map<Integer, Integer> numberCounterMap, SecureRandom secureRandom)
	{
		for (int i = 0; i < drawCount; i++)
		{
			DrawLotteryNumbersFactory.draw(maxNumbers, minVolume, maxVolume, secureRandom)
				.forEach(key -> numberCounterMap.merge(key, 1, Integer::sum));
		}
		return numberCounterMap;
	}

	/**
	 * Merges several drawings of lottery numbers from the given arguments
	 *
	 * @param drawModelBean
	 *            the bean that holds the data how to draw the numbers
	 * @param numberCounterMap
	 *            the counter map for generate statistics of the drawn lottery numbers
	 * @return the map with the merged lottery numbers
	 */
	public static Map<Integer, Integer> mergeDrawings(DrawModelBean drawModelBean,
		Map<Integer, Integer> numberCounterMap)
	{
		if (drawModelBean.isShuffle())
		{
			for (int i = 0; i < drawModelBean.getDrawCount(); i++)
			{
				DrawLotteryNumbersFactory
					.drawWithShuffle(drawModelBean.getMaxNumbers(), drawModelBean.getMinVolume(),
						drawModelBean.getMaxVolume(), drawModelBean.getSecureRandom())
					.forEach(key -> numberCounterMap.merge(key, 1, Integer::sum));
			}
			return numberCounterMap;
		}
		else
		{
			return mergeDrawings(drawModelBean.getMaxNumbers(), drawModelBean.getMinVolume(),
				drawModelBean.getMaxVolume(), drawModelBean.getDrawCount(), numberCounterMap,
				drawModelBean.getSecureRandom());
		}
	}
}
