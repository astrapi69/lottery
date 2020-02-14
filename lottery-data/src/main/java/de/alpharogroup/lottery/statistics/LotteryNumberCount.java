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
package de.alpharogroup.lottery.statistics;

import java.util.Map;

/**
 * The class {@link LotteryNumberCount} is used to count the lottery numbers in several draws and
 * can be used for addition or subtraction
 */
public class LotteryNumberCount
{
	public static class LotteryNumberCountBuilder
	{
		private String lotteryGameType;
		private Map<Integer, Integer> numberCounterMap;

		LotteryNumberCountBuilder()
		{
		}

		public LotteryNumberCount build()
		{
			return new LotteryNumberCount(lotteryGameType, numberCounterMap);
		}

		public LotteryNumberCount.LotteryNumberCountBuilder lotteryGameType(String lotteryGameType)
		{
			this.lotteryGameType = lotteryGameType;
			return this;
		}

		public LotteryNumberCount.LotteryNumberCountBuilder numberCounterMap(
			Map<Integer, Integer> numberCounterMap)
		{
			this.numberCounterMap = numberCounterMap;
			return this;
		}

		@Override
		public String toString()
		{
			return "LotteryNumberCount.LotteryNumberCountBuilder(lotteryGameType="
				+ this.lotteryGameType + ", numberCounterMap=" + this.numberCounterMap + ")";
		}
	}
	public static LotteryNumberCountBuilder builder()
	{
		return new LotteryNumberCountBuilder();
	}

	private String lotteryGameType;

	private Map<Integer, Integer> numberCounterMap;

	public LotteryNumberCount()
	{
	}

	public LotteryNumberCount(String lotteryGameType, Map<Integer, Integer> numberCounterMap)
	{
		this.lotteryGameType = lotteryGameType;
		this.numberCounterMap = numberCounterMap;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof LotteryNumberCount;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof LotteryNumberCount))
			return false;
		final LotteryNumberCount other = (LotteryNumberCount)o;
		if (!other.canEqual(this))
			return false;
		final Object this$lotteryGameType = this.getLotteryGameType();
		final Object other$lotteryGameType = other.getLotteryGameType();
		if (this$lotteryGameType == null
			? other$lotteryGameType != null
			: !this$lotteryGameType.equals(other$lotteryGameType))
			return false;
		final Object this$numberCounterMap = this.getNumberCounterMap();
		final Object other$numberCounterMap = other.getNumberCounterMap();
		if (this$numberCounterMap == null
			? other$numberCounterMap != null
			: !this$numberCounterMap.equals(other$numberCounterMap))
			return false;
		return true;
	}

	public String getLotteryGameType()
	{
		return this.lotteryGameType;
	}

	public Map<Integer, Integer> getNumberCounterMap()
	{
		return this.numberCounterMap;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $lotteryGameType = this.getLotteryGameType();
		result = result * PRIME + ($lotteryGameType == null ? 43 : $lotteryGameType.hashCode());
		final Object $numberCounterMap = this.getNumberCounterMap();
		result = result * PRIME + ($numberCounterMap == null ? 43 : $numberCounterMap.hashCode());
		return result;
	}

	public void setLotteryGameType(String lotteryGameType)
	{
		this.lotteryGameType = lotteryGameType;
	}

	public void setNumberCounterMap(Map<Integer, Integer> numberCounterMap)
	{
		this.numberCounterMap = numberCounterMap;
	}

	public LotteryNumberCountBuilder toBuilder()
	{
		return new LotteryNumberCountBuilder().lotteryGameType(this.lotteryGameType)
			.numberCounterMap(this.numberCounterMap);
	}

	@Override
	public String toString()
	{
		return "LotteryNumberCount(lotteryGameType=" + this.getLotteryGameType()
			+ ", numberCounterMap=" + this.getNumberCounterMap() + ")";
	}
}
