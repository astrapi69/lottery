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
package de.alpharogroup.lottery.played;

import java.util.List;
import java.util.Map;
import java.util.Set;

import de.alpharogroup.lottery.enums.LotteryGameType;

/**
 * The class {@link LotteryPlayedNumbers} contains the data of the lottery player.
 */
public class LotteryPlayedNumbers implements Cloneable
{

	public static class LotteryPlayedNumbersBuilder
	{
		private Integer id;
		private Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers;
		private Integer superNumber;
		private Integer superSixNumber;

		LotteryPlayedNumbersBuilder()
		{
		}

		public LotteryPlayedNumbers build()
		{
			return new LotteryPlayedNumbers(id, playedLotteryNumbers, superNumber, superSixNumber);
		}

		public LotteryPlayedNumbers.LotteryPlayedNumbersBuilder id(Integer id)
		{
			this.id = id;
			return this;
		}

		public LotteryPlayedNumbers.LotteryPlayedNumbersBuilder playedLotteryNumbers(
			Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers)
		{
			this.playedLotteryNumbers = playedLotteryNumbers;
			return this;
		}

		public LotteryPlayedNumbers.LotteryPlayedNumbersBuilder superNumber(Integer superNumber)
		{
			this.superNumber = superNumber;
			return this;
		}

		public LotteryPlayedNumbers.LotteryPlayedNumbersBuilder superSixNumber(
			Integer superSixNumber)
		{
			this.superSixNumber = superSixNumber;
			return this;
		}

		@Override
		public String toString()
		{
			return "LotteryPlayedNumbers.LotteryPlayedNumbersBuilder(id=" + this.id
				+ ", playedLotteryNumbers=" + this.playedLotteryNumbers + ", superNumber="
				+ this.superNumber + ", superSixNumber=" + this.superSixNumber + ")";
		}
	}

	public static LotteryPlayedNumbersBuilder builder()
	{
		return new LotteryPlayedNumbersBuilder();
	}

	/** The id. */
	private Integer id;

	/** The played lottery numbers. */
	private Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers;

	/** The super number. */
	private Integer superNumber;

	/** The super six number. */
	private Integer superSixNumber;

	public LotteryPlayedNumbers()
	{
	}

	public LotteryPlayedNumbers(Integer id,
		Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers, Integer superNumber,
		Integer superSixNumber)
	{
		this.id = id;
		this.playedLotteryNumbers = playedLotteryNumbers;
		this.superNumber = superNumber;
		this.superSixNumber = superSixNumber;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof LotteryPlayedNumbers;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return LotteryPlayedNumbers.builder().id(id).playedLotteryNumbers(playedLotteryNumbers)
			.superSixNumber(superSixNumber).superNumber(superNumber).build();
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof LotteryPlayedNumbers))
			return false;
		final LotteryPlayedNumbers other = (LotteryPlayedNumbers)o;
		if (!other.canEqual(this))
			return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id))
			return false;
		final Object this$playedLotteryNumbers = this.getPlayedLotteryNumbers();
		final Object other$playedLotteryNumbers = other.getPlayedLotteryNumbers();
		if (this$playedLotteryNumbers == null
			? other$playedLotteryNumbers != null
			: !this$playedLotteryNumbers.equals(other$playedLotteryNumbers))
			return false;
		final Object this$superNumber = this.getSuperNumber();
		final Object other$superNumber = other.getSuperNumber();
		if (this$superNumber == null
			? other$superNumber != null
			: !this$superNumber.equals(other$superNumber))
			return false;
		final Object this$superSixNumber = this.getSuperSixNumber();
		final Object other$superSixNumber = other.getSuperSixNumber();
		if (this$superSixNumber == null
			? other$superSixNumber != null
			: !this$superSixNumber.equals(other$superSixNumber))
			return false;
		return true;
	}

	public Integer getId()
	{
		return this.id;
	}

	public Map<LotteryGameType, List<Set<Integer>>> getPlayedLotteryNumbers()
	{
		return this.playedLotteryNumbers;
	}

	public Integer getSuperNumber()
	{
		return this.superNumber;
	}

	public Integer getSuperSixNumber()
	{
		return this.superSixNumber;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $playedLotteryNumbers = this.getPlayedLotteryNumbers();
		result = result * PRIME
			+ ($playedLotteryNumbers == null ? 43 : $playedLotteryNumbers.hashCode());
		final Object $superNumber = this.getSuperNumber();
		result = result * PRIME + ($superNumber == null ? 43 : $superNumber.hashCode());
		final Object $superSixNumber = this.getSuperSixNumber();
		result = result * PRIME + ($superSixNumber == null ? 43 : $superSixNumber.hashCode());
		return result;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setPlayedLotteryNumbers(
		Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers)
	{
		this.playedLotteryNumbers = playedLotteryNumbers;
	}

	public void setSuperNumber(Integer superNumber)
	{
		this.superNumber = superNumber;
	}

	public void setSuperSixNumber(Integer superSixNumber)
	{
		this.superSixNumber = superSixNumber;
	}

	public LotteryPlayedNumbersBuilder toBuilder()
	{
		return new LotteryPlayedNumbersBuilder().id(this.id)
			.playedLotteryNumbers(this.playedLotteryNumbers).superNumber(this.superNumber)
			.superSixNumber(this.superSixNumber);
	}

	@Override
	public String toString()
	{
		return "LotteryPlayedNumbers(id=" + this.getId() + ", playedLotteryNumbers="
			+ this.getPlayedLotteryNumbers() + ", superNumber=" + this.getSuperNumber()
			+ ", superSixNumber=" + this.getSuperSixNumber() + ")";
	}
}
