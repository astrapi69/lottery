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
 * The class {@link DrawnEuroMillionsNumbers} contains data that can be used for the validation if
 * the given played Euromillions numbers have won.
 */
public class DrawnEuroMillionsNumbers
{
	public static class DrawnEuroMillionsNumbersBuilder
	{
		private Integer id;
		private Set<Integer> lotteryNumbers;
		private Set<Integer> starNumbers;

		DrawnEuroMillionsNumbersBuilder()
		{
		}

		public DrawnEuroMillionsNumbers build()
		{
			return new DrawnEuroMillionsNumbers(id, lotteryNumbers, starNumbers);
		}

		public DrawnEuroMillionsNumbers.DrawnEuroMillionsNumbersBuilder id(Integer id)
		{
			this.id = id;
			return this;
		}

		public DrawnEuroMillionsNumbers.DrawnEuroMillionsNumbersBuilder lotteryNumbers(
			Set<Integer> lotteryNumbers)
		{
			this.lotteryNumbers = lotteryNumbers;
			return this;
		}

		public DrawnEuroMillionsNumbers.DrawnEuroMillionsNumbersBuilder starNumbers(
			Set<Integer> starNumbers)
		{
			this.starNumbers = starNumbers;
			return this;
		}

		@Override
		public String toString()
		{
			return "DrawnEuroMillionsNumbers.DrawnEuroMillionsNumbersBuilder(id=" + this.id
				+ ", lotteryNumbers=" + this.lotteryNumbers + ", starNumbers=" + this.starNumbers
				+ ")";
		}
	}

	public static DrawnEuroMillionsNumbersBuilder builder()
	{
		return new DrawnEuroMillionsNumbersBuilder();
	}

	/** The id. */
	private Integer id;

	/** The set with the drawn lottery numbers. */
	private Set<Integer> lotteryNumbers;

	/** The set with the drawn star numbers. */
	private Set<Integer> starNumbers;

	public DrawnEuroMillionsNumbers()
	{
	}

	public DrawnEuroMillionsNumbers(Integer id, Set<Integer> lotteryNumbers,
		Set<Integer> starNumbers)
	{
		this.id = id;
		this.lotteryNumbers = lotteryNumbers;
		this.starNumbers = starNumbers;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof DrawnEuroMillionsNumbers;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof DrawnEuroMillionsNumbers))
			return false;
		final DrawnEuroMillionsNumbers other = (DrawnEuroMillionsNumbers)o;
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
		final Object this$starNumbers = this.getStarNumbers();
		final Object other$starNumbers = other.getStarNumbers();
		if (this$starNumbers == null
			? other$starNumbers != null
			: !this$starNumbers.equals(other$starNumbers))
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

	public Set<Integer> getStarNumbers()
	{
		return this.starNumbers;
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
		final Object $starNumbers = this.getStarNumbers();
		result = result * PRIME + ($starNumbers == null ? 43 : $starNumbers.hashCode());
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

	public void setStarNumbers(Set<Integer> starNumbers)
	{
		this.starNumbers = starNumbers;
	}

	public DrawnEuroMillionsNumbersBuilder toBuilder()
	{
		return new DrawnEuroMillionsNumbersBuilder().id(this.id).lotteryNumbers(this.lotteryNumbers)
			.starNumbers(this.starNumbers);
	}

	@Override
	public String toString()
	{
		return "DrawnEuroMillionsNumbers(id=" + this.getId() + ", lotteryNumbers="
			+ this.getLotteryNumbers() + ", starNumbers=" + this.getStarNumbers() + ")";
	}
}
