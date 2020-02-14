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
package de.alpharogroup.lottery.drawings;

import java.util.Set;

/**
 * The class {@link DrawnLotteryNumbers} contains data that can be used for the validation if the
 * given played lottery numbers have won.
 */
public class DrawnLotteryNumbers
{
	public static class DrawnLotteryNumbersBuilder
	{
		private Integer id;
		private Set<Integer> lotteryNumbers;
		private Integer superNumber;
		private Integer superSixNumber;

		DrawnLotteryNumbersBuilder()
		{
		}

		public DrawnLotteryNumbers build()
		{
			return new DrawnLotteryNumbers(id, lotteryNumbers, superNumber, superSixNumber);
		}

		public DrawnLotteryNumbers.DrawnLotteryNumbersBuilder id(Integer id)
		{
			this.id = id;
			return this;
		}

		public DrawnLotteryNumbers.DrawnLotteryNumbersBuilder lotteryNumbers(
			Set<Integer> lotteryNumbers)
		{
			this.lotteryNumbers = lotteryNumbers;
			return this;
		}

		public DrawnLotteryNumbers.DrawnLotteryNumbersBuilder superNumber(Integer superNumber)
		{
			this.superNumber = superNumber;
			return this;
		}

		public DrawnLotteryNumbers.DrawnLotteryNumbersBuilder superSixNumber(Integer superSixNumber)
		{
			this.superSixNumber = superSixNumber;
			return this;
		}

		@Override
		public String toString()
		{
			return "DrawnLotteryNumbers.DrawnLotteryNumbersBuilder(id=" + this.id
				+ ", lotteryNumbers=" + this.lotteryNumbers + ", superNumber=" + this.superNumber
				+ ", superSixNumber=" + this.superSixNumber + ")";
		}
	}

	public static DrawnLotteryNumbersBuilder builder()
	{
		return new DrawnLotteryNumbersBuilder();
	}

	/** The id. */
	private Integer id;

	/** The set with the drawn lottery numbers. */
	private Set<Integer> lotteryNumbers;

	/** The drawn super number. */
	private Integer superNumber;

	/** The drawn super six number. */
	private Integer superSixNumber;

	public DrawnLotteryNumbers()
	{
	}

	public DrawnLotteryNumbers(Integer id, Set<Integer> lotteryNumbers, Integer superNumber,
		Integer superSixNumber)
	{
		this.id = id;
		this.lotteryNumbers = lotteryNumbers;
		this.superNumber = superNumber;
		this.superSixNumber = superSixNumber;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof DrawnLotteryNumbers;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof DrawnLotteryNumbers))
			return false;
		final DrawnLotteryNumbers other = (DrawnLotteryNumbers)o;
		if (!other.canEqual(this))
			return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id))
			return false;
		final Object this$lotteryNumbers = this.getLotteryNumbers();
		final Object other$lotteryNumbers = other.getLotteryNumbers();
		if (this$lotteryNumbers == null
			? other$lotteryNumbers != null
			: !this$lotteryNumbers.equals(other$lotteryNumbers))
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

	public Set<Integer> getLotteryNumbers()
	{
		return this.lotteryNumbers;
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
		final Object $lotteryNumbers = this.getLotteryNumbers();
		result = result * PRIME + ($lotteryNumbers == null ? 43 : $lotteryNumbers.hashCode());
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

	public void setLotteryNumbers(Set<Integer> lotteryNumbers)
	{
		this.lotteryNumbers = lotteryNumbers;
	}

	public void setSuperNumber(Integer superNumber)
	{
		this.superNumber = superNumber;
	}

	public void setSuperSixNumber(Integer superSixNumber)
	{
		this.superSixNumber = superSixNumber;
	}

	public DrawnLotteryNumbersBuilder toBuilder()
	{
		return new DrawnLotteryNumbersBuilder().id(this.id).lotteryNumbers(this.lotteryNumbers)
			.superNumber(this.superNumber).superSixNumber(this.superSixNumber);
	}

	@Override
	public String toString()
	{
		return "DrawnLotteryNumbers(id=" + this.getId() + ", lotteryNumbers="
			+ this.getLotteryNumbers() + ", superNumber=" + this.getSuperNumber()
			+ ", superSixNumber=" + this.getSuperSixNumber() + ")";
	}
}
