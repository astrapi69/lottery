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
package de.alpharogroup.lottery.evaluation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.lottery.enums.LotteryGameType;

/**
 * The class {@link EvaluatedLotteryNumbers} contains the evaluated result of the drawn lottery
 * numbers and the played numbers of a player.
 */
public class EvaluatedLotteryNumbers
{

	public static class EvaluatedLotteryNumbersBuilder
	{
		private Integer id;
		private Integer wonGameSeventySevenNumber;
		private Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers = MapFactory
			.newHashMap();
		private Integer wonSuperNumber;
		private Integer wonSuperSixNumber;

		EvaluatedLotteryNumbersBuilder()
		{
		}

		public EvaluatedLotteryNumbers build()
		{
			return new EvaluatedLotteryNumbers(id, wonGameSeventySevenNumber, wonLotteryNumbers,
				wonSuperNumber, wonSuperSixNumber);
		}

		public EvaluatedLotteryNumbers.EvaluatedLotteryNumbersBuilder id(Integer id)
		{
			this.id = id;
			return this;
		}

		@Override
		public String toString()
		{
			return "EvaluatedLotteryNumbers.EvaluatedLotteryNumbersBuilder(id=" + this.id
				+ ", wonGameSeventySevenNumber=" + this.wonGameSeventySevenNumber
				+ ", wonLotteryNumbers=" + this.wonLotteryNumbers + ", wonSuperNumber="
				+ this.wonSuperNumber + ", wonSuperSixNumber=" + this.wonSuperSixNumber + ")";
		}

		public EvaluatedLotteryNumbers.EvaluatedLotteryNumbersBuilder wonGameSeventySevenNumber(
			Integer wonGameSeventySevenNumber)
		{
			this.wonGameSeventySevenNumber = wonGameSeventySevenNumber;
			return this;
		}

		public EvaluatedLotteryNumbers.EvaluatedLotteryNumbersBuilder wonLotteryNumbers(
			Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers)
		{
			this.wonLotteryNumbers = wonLotteryNumbers;
			return this;
		}

		public EvaluatedLotteryNumbers.EvaluatedLotteryNumbersBuilder wonSuperNumber(
			Integer wonSuperNumber)
		{
			this.wonSuperNumber = wonSuperNumber;
			return this;
		}

		public EvaluatedLotteryNumbers.EvaluatedLotteryNumbersBuilder wonSuperSixNumber(
			Integer wonSuperSixNumber)
		{
			this.wonSuperSixNumber = wonSuperSixNumber;
			return this;
		}
	}

	public static EvaluatedLotteryNumbersBuilder builder()
	{
		return new EvaluatedLotteryNumbersBuilder();
	}

	/** The id. */
	private Integer id;

	/** The evaluated game seventy seven. */
	private Integer wonGameSeventySevenNumber;

	/** The played lottery numbers. */
	private Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers = MapFactory
		.newHashMap();

	/** The evaluated super number. */
	private Integer wonSuperNumber;

	/** The evaluated super six number. */
	private Integer wonSuperSixNumber;

	public EvaluatedLotteryNumbers()
	{
	}

	public EvaluatedLotteryNumbers(Integer id, Integer wonGameSeventySevenNumber,
		Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers, Integer wonSuperNumber,
		Integer wonSuperSixNumber)
	{
		this.id = id;
		this.wonGameSeventySevenNumber = wonGameSeventySevenNumber;
		this.wonLotteryNumbers = wonLotteryNumbers;
		this.wonSuperNumber = wonSuperNumber;
		this.wonSuperSixNumber = wonSuperSixNumber;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof EvaluatedLotteryNumbers;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof EvaluatedLotteryNumbers))
			return false;
		final EvaluatedLotteryNumbers other = (EvaluatedLotteryNumbers)o;
		if (!other.canEqual(this))
			return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id))
			return false;
		final Object this$wonGameSeventySevenNumber = this.getWonGameSeventySevenNumber();
		final Object other$wonGameSeventySevenNumber = other.getWonGameSeventySevenNumber();
		if (this$wonGameSeventySevenNumber == null
			? other$wonGameSeventySevenNumber != null
			: !this$wonGameSeventySevenNumber.equals(other$wonGameSeventySevenNumber))
			return false;
		final Object this$wonLotteryNumbers = this.getWonLotteryNumbers();
		final Object other$wonLotteryNumbers = other.getWonLotteryNumbers();
		if (this$wonLotteryNumbers == null
			? other$wonLotteryNumbers != null
			: !this$wonLotteryNumbers.equals(other$wonLotteryNumbers))
			return false;
		final Object this$wonSuperNumber = this.getWonSuperNumber();
		final Object other$wonSuperNumber = other.getWonSuperNumber();
		if (this$wonSuperNumber == null
			? other$wonSuperNumber != null
			: !this$wonSuperNumber.equals(other$wonSuperNumber))
			return false;
		final Object this$wonSuperSixNumber = this.getWonSuperSixNumber();
		final Object other$wonSuperSixNumber = other.getWonSuperSixNumber();
		if (this$wonSuperSixNumber == null
			? other$wonSuperSixNumber != null
			: !this$wonSuperSixNumber.equals(other$wonSuperSixNumber))
			return false;
		return true;
	}

	public Integer getId()
	{
		return this.id;
	}

	public Integer getWonGameSeventySevenNumber()
	{
		return this.wonGameSeventySevenNumber;
	}

	public Map<LotteryGameType, List<Collection<Integer>>> getWonLotteryNumbers()
	{
		return this.wonLotteryNumbers;
	}

	public Integer getWonSuperNumber()
	{
		return this.wonSuperNumber;
	}

	public Integer getWonSuperSixNumber()
	{
		return this.wonSuperSixNumber;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $wonGameSeventySevenNumber = this.getWonGameSeventySevenNumber();
		result = result * PRIME
			+ ($wonGameSeventySevenNumber == null ? 43 : $wonGameSeventySevenNumber.hashCode());
		final Object $wonLotteryNumbers = this.getWonLotteryNumbers();
		result = result * PRIME + ($wonLotteryNumbers == null ? 43 : $wonLotteryNumbers.hashCode());
		final Object $wonSuperNumber = this.getWonSuperNumber();
		result = result * PRIME + ($wonSuperNumber == null ? 43 : $wonSuperNumber.hashCode());
		final Object $wonSuperSixNumber = this.getWonSuperSixNumber();
		result = result * PRIME + ($wonSuperSixNumber == null ? 43 : $wonSuperSixNumber.hashCode());
		return result;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setWonGameSeventySevenNumber(Integer wonGameSeventySevenNumber)
	{
		this.wonGameSeventySevenNumber = wonGameSeventySevenNumber;
	}

	public void setWonLotteryNumbers(
		Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers)
	{
		this.wonLotteryNumbers = wonLotteryNumbers;
	}

	public void setWonSuperNumber(Integer wonSuperNumber)
	{
		this.wonSuperNumber = wonSuperNumber;
	}

	public void setWonSuperSixNumber(Integer wonSuperSixNumber)
	{
		this.wonSuperSixNumber = wonSuperSixNumber;
	}

	public EvaluatedLotteryNumbersBuilder toBuilder()
	{
		return new EvaluatedLotteryNumbersBuilder().id(this.id)
			.wonGameSeventySevenNumber(this.wonGameSeventySevenNumber)
			.wonLotteryNumbers(this.wonLotteryNumbers).wonSuperNumber(this.wonSuperNumber)
			.wonSuperSixNumber(this.wonSuperSixNumber);
	}

	@Override
	public String toString()
	{
		return "EvaluatedLotteryNumbers(id=" + this.getId() + ", wonGameSeventySevenNumber="
			+ this.getWonGameSeventySevenNumber() + ", wonLotteryNumbers="
			+ this.getWonLotteryNumbers() + ", wonSuperNumber=" + this.getWonSuperNumber()
			+ ", wonSuperSixNumber=" + this.getWonSuperSixNumber() + ")";
	}
}
