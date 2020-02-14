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
package de.alpharogroup.lottery.wincategories;

/**
 * The class {@link EuroMillionsWinCategory} represents an win category for the EuroMillion lottery.
 */
public class EuroMillionsWinCategory implements Cloneable
{

	public static class EuroMillionsWinCategoryBuilder
	{
		private String computation;
		private double payoutRate;
		private int quantityOfWonNumbers;
		private int quantityOfWonStarNumbers;
		private boolean withJoker;

		EuroMillionsWinCategoryBuilder()
		{
		}

		public EuroMillionsWinCategory build()
		{
			return new EuroMillionsWinCategory(computation, payoutRate, quantityOfWonNumbers,
				quantityOfWonStarNumbers, withJoker);
		}

		public EuroMillionsWinCategory.EuroMillionsWinCategoryBuilder computation(
			String computation)
		{
			this.computation = computation;
			return this;
		}

		public EuroMillionsWinCategory.EuroMillionsWinCategoryBuilder payoutRate(double payoutRate)
		{
			this.payoutRate = payoutRate;
			return this;
		}

		public EuroMillionsWinCategory.EuroMillionsWinCategoryBuilder quantityOfWonNumbers(
			int quantityOfWonNumbers)
		{
			this.quantityOfWonNumbers = quantityOfWonNumbers;
			return this;
		}

		public EuroMillionsWinCategory.EuroMillionsWinCategoryBuilder quantityOfWonStarNumbers(
			int quantityOfWonStarNumbers)
		{
			this.quantityOfWonStarNumbers = quantityOfWonStarNumbers;
			return this;
		}

		@Override
		public String toString()
		{
			return "EuroMillionsWinCategory.EuroMillionsWinCategoryBuilder(computation="
				+ this.computation + ", payoutRate=" + this.payoutRate + ", quantityOfWonNumbers="
				+ this.quantityOfWonNumbers + ", quantityOfWonStarNumbers="
				+ this.quantityOfWonStarNumbers + ", withJoker=" + this.withJoker + ")";
		}

		public EuroMillionsWinCategory.EuroMillionsWinCategoryBuilder withJoker(boolean withJoker)
		{
			this.withJoker = withJoker;
			return this;
		}
	}

	public static EuroMillionsWinCategoryBuilder builder()
	{
		return new EuroMillionsWinCategoryBuilder();
	}

	/** The computation. */
	private final String computation;

	/** The payout rate of this winning category. */
	private final double payoutRate;

	/** The quantity of winning numbers. */
	private final int quantityOfWonNumbers;

	/** The quantity of winning star numbers. */
	private final int quantityOfWonStarNumbers;

	/** The flag if the joker is selected. */
	private final boolean withJoker;

	public EuroMillionsWinCategory(String computation, double payoutRate, int quantityOfWonNumbers,
		int quantityOfWonStarNumbers, boolean withJoker)
	{
		this.computation = computation;
		this.payoutRate = payoutRate;
		this.quantityOfWonNumbers = quantityOfWonNumbers;
		this.quantityOfWonStarNumbers = quantityOfWonStarNumbers;
		this.withJoker = withJoker;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof EuroMillionsWinCategory;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		EuroMillionsWinCategory clone = EuroMillionsWinCategory.builder()
			.computation(this.computation).payoutRate(this.payoutRate).withJoker(this.withJoker)
			.quantityOfWonNumbers(this.quantityOfWonNumbers)
			.quantityOfWonStarNumbers(this.quantityOfWonStarNumbers).build();
		return clone;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof EuroMillionsWinCategory))
			return false;
		final EuroMillionsWinCategory other = (EuroMillionsWinCategory)o;
		if (!other.canEqual(this))
			return false;
		final Object this$computation = this.getComputation();
		final Object other$computation = other.getComputation();
		if (this$computation == null
			? other$computation != null
			: !this$computation.equals(other$computation))
			return false;
		if (Double.compare(this.getPayoutRate(), other.getPayoutRate()) != 0)
			return false;
		if (this.getQuantityOfWonNumbers() != other.getQuantityOfWonNumbers())
			return false;
		if (this.getQuantityOfWonStarNumbers() != other.getQuantityOfWonStarNumbers())
			return false;
		if (this.isWithJoker() != other.isWithJoker())
			return false;
		return true;
	}

	public String getComputation()
	{
		return this.computation;
	}

	public double getPayoutRate()
	{
		return this.payoutRate;
	}

	public int getQuantityOfWonNumbers()
	{
		return this.quantityOfWonNumbers;
	}

	public int getQuantityOfWonStarNumbers()
	{
		return this.quantityOfWonStarNumbers;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $computation = this.getComputation();
		result = result * PRIME + ($computation == null ? 43 : $computation.hashCode());
		final long $payoutRate = Double.doubleToLongBits(this.getPayoutRate());
		result = result * PRIME + (int)($payoutRate >>> 32 ^ $payoutRate);
		result = result * PRIME + this.getQuantityOfWonNumbers();
		result = result * PRIME + this.getQuantityOfWonStarNumbers();
		result = result * PRIME + (this.isWithJoker() ? 79 : 97);
		return result;
	}

	public boolean isWithJoker()
	{
		return this.withJoker;
	}

	public EuroMillionsWinCategoryBuilder toBuilder()
	{
		return new EuroMillionsWinCategoryBuilder().computation(this.computation)
			.payoutRate(this.payoutRate).quantityOfWonNumbers(this.quantityOfWonNumbers)
			.quantityOfWonStarNumbers(this.quantityOfWonStarNumbers).withJoker(this.withJoker);
	}

	@Override
	public String toString()
	{
		return "EuroMillionsWinCategory(computation=" + this.getComputation() + ", payoutRate="
			+ this.getPayoutRate() + ", quantityOfWonNumbers=" + this.getQuantityOfWonNumbers()
			+ ", quantityOfWonStarNumbers=" + this.getQuantityOfWonStarNumbers() + ", withJoker="
			+ this.isWithJoker() + ")";
	}
}
