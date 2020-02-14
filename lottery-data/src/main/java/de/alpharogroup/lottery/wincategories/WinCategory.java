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
 * The class {@link WinCategory} represents an win category for a lottery like lottery.
 */
public class WinCategory implements Cloneable
{

	public static class WinCategoryBuilder
	{
		private int quantityOfWonNumbers;
		private boolean withSuperNumber;

		WinCategoryBuilder()
		{
		}

		public WinCategory build()
		{
			return new WinCategory(quantityOfWonNumbers, withSuperNumber);
		}

		public WinCategory.WinCategoryBuilder quantityOfWonNumbers(int quantityOfWonNumbers)
		{
			this.quantityOfWonNumbers = quantityOfWonNumbers;
			return this;
		}

		@Override
		public String toString()
		{
			return "WinCategory.WinCategoryBuilder(quantityOfWonNumbers="
				+ this.quantityOfWonNumbers + ", withSuperNumber=" + this.withSuperNumber + ")";
		}

		public WinCategory.WinCategoryBuilder withSuperNumber(boolean withSuperNumber)
		{
			this.withSuperNumber = withSuperNumber;
			return this;
		}
	}

	public static WinCategoryBuilder builder()
	{
		return new WinCategoryBuilder();
	}

	/** The quantity of winning numbers. */
	private final int quantityOfWonNumbers;

	/** The flag if the played super number is selected. */
	private final boolean withSuperNumber;

	public WinCategory(int quantityOfWonNumbers, boolean withSuperNumber)
	{
		this.quantityOfWonNumbers = quantityOfWonNumbers;
		this.withSuperNumber = withSuperNumber;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof WinCategory;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		WinCategory clone = WinCategory.builder().withSuperNumber(this.withSuperNumber)
			.quantityOfWonNumbers(this.quantityOfWonNumbers).build();
		return clone;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof WinCategory))
			return false;
		final WinCategory other = (WinCategory)o;
		if (!other.canEqual(this))
			return false;
		if (this.getQuantityOfWonNumbers() != other.getQuantityOfWonNumbers())
			return false;
		if (this.isWithSuperNumber() != other.isWithSuperNumber())
			return false;
		return true;
	}

	public int getQuantityOfWonNumbers()
	{
		return this.quantityOfWonNumbers;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		result = result * PRIME + this.getQuantityOfWonNumbers();
		result = result * PRIME + (this.isWithSuperNumber() ? 79 : 97);
		return result;
	}

	public boolean isWithSuperNumber()
	{
		return this.withSuperNumber;
	}

	public WinCategoryBuilder toBuilder()
	{
		return new WinCategoryBuilder().quantityOfWonNumbers(this.quantityOfWonNumbers)
			.withSuperNumber(this.withSuperNumber);
	}

	@Override
	public String toString()
	{
		return "WinCategory(quantityOfWonNumbers=" + this.getQuantityOfWonNumbers()
			+ ", withSuperNumber=" + this.isWithSuperNumber() + ")";
	}
}
