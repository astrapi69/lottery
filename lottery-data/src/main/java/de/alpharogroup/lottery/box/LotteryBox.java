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
package de.alpharogroup.lottery.box;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import de.alpharogroup.lottery.enums.LotteryGameType;
import de.alpharogroup.lottery.wincategories.LotteryWinCategory;

/**
 * The class {@link LotteryBox} represents exactly one lottery box in a lottery ticket
 */
public class LotteryBox
{

	public static class LotteryBoxBuilder
	{
		private LotteryGameType gameType;
		private Integer index;
		private ArrayList<Integer> selectedNumbers;
		private LotteryWinCategory winCategory;

		LotteryBoxBuilder()
		{
		}

		public LotteryBox build()
		{
			Set<Integer> selectedNumbers;
			switch (this.selectedNumbers == null ? 0 : this.selectedNumbers.size())
			{
				case 0 :
					selectedNumbers = java.util.Collections.emptySet();
					break;
				case 1 :
					selectedNumbers = java.util.Collections.singleton(this.selectedNumbers.get(0));
					break;
				default :
					selectedNumbers = new java.util.LinkedHashSet<Integer>(
						this.selectedNumbers.size() < 1073741824
							? 1 + this.selectedNumbers.size()
								+ (this.selectedNumbers.size() - 3) / 3
							: Integer.MAX_VALUE);
					selectedNumbers.addAll(this.selectedNumbers);
					selectedNumbers = java.util.Collections.unmodifiableSet(selectedNumbers);
			}

			return new LotteryBox(gameType, index, selectedNumbers, winCategory);
		}

		public LotteryBox.LotteryBoxBuilder clearSelectedNumbers()
		{
			if (this.selectedNumbers != null)
				this.selectedNumbers.clear();
			return this;
		}

		public LotteryBox.LotteryBoxBuilder gameType(LotteryGameType gameType)
		{
			this.gameType = gameType;
			return this;
		}

		public LotteryBox.LotteryBoxBuilder index(Integer index)
		{
			this.index = index;
			return this;
		}

		public LotteryBox.LotteryBoxBuilder selectedNumber(Integer selectedNumber)
		{
			if (this.selectedNumbers == null)
				this.selectedNumbers = new ArrayList<Integer>();
			this.selectedNumbers.add(selectedNumber);
			return this;
		}

		public LotteryBox.LotteryBoxBuilder selectedNumbers(
			Collection<? extends Integer> selectedNumbers)
		{
			if (this.selectedNumbers == null)
				this.selectedNumbers = new ArrayList<Integer>();
			this.selectedNumbers.addAll(selectedNumbers);
			return this;
		}

		@Override
		public String toString()
		{
			return "LotteryBox.LotteryBoxBuilder(gameType=" + this.gameType + ", index="
				+ this.index + ", selectedNumbers=" + this.selectedNumbers + ", winCategory="
				+ this.winCategory + ")";
		}

		public LotteryBox.LotteryBoxBuilder winCategory(LotteryWinCategory winCategory)
		{
			this.winCategory = winCategory;
			return this;
		}
	}

	public static LotteryBoxBuilder builder()
	{
		return new LotteryBoxBuilder();
	}

	/** The lottery game type. */
	private LotteryGameType gameType;

	/** The index of this box in the lottery ticket */
	private Integer index;

	/** The selected numbers. */
	private Set<Integer> selectedNumbers;

	/** The lottery win category. */
	private LotteryWinCategory winCategory;

	public LotteryBox()
	{
	}

	public LotteryBox(LotteryGameType gameType, Integer index, Set<Integer> selectedNumbers,
		LotteryWinCategory winCategory)
	{
		this.gameType = gameType;
		this.index = index;
		this.selectedNumbers = selectedNumbers;
		this.winCategory = winCategory;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof LotteryBox;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof LotteryBox))
			return false;
		final LotteryBox other = (LotteryBox)o;
		if (!other.canEqual(this))
			return false;
		final Object this$gameType = this.getGameType();
		final Object other$gameType = other.getGameType();
		if (this$gameType == null ? other$gameType != null : !this$gameType.equals(other$gameType))
			return false;
		final Object this$index = this.getIndex();
		final Object other$index = other.getIndex();
		if (this$index == null ? other$index != null : !this$index.equals(other$index))
			return false;
		final Object this$selectedNumbers = this.getSelectedNumbers();
		final Object other$selectedNumbers = other.getSelectedNumbers();
		if (this$selectedNumbers == null
			? other$selectedNumbers != null
			: !this$selectedNumbers.equals(other$selectedNumbers))
			return false;
		final Object this$winCategory = this.getWinCategory();
		final Object other$winCategory = other.getWinCategory();
		if (this$winCategory == null
			? other$winCategory != null
			: !this$winCategory.equals(other$winCategory))
			return false;
		return true;
	}

	public LotteryGameType getGameType()
	{
		return this.gameType;
	}

	public Integer getIndex()
	{
		return this.index;
	}

	public Set<Integer> getSelectedNumbers()
	{
		return this.selectedNumbers;
	}

	public LotteryWinCategory getWinCategory()
	{
		return this.winCategory;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $gameType = this.getGameType();
		result = result * PRIME + ($gameType == null ? 43 : $gameType.hashCode());
		final Object $index = this.getIndex();
		result = result * PRIME + ($index == null ? 43 : $index.hashCode());
		final Object $selectedNumbers = this.getSelectedNumbers();
		result = result * PRIME + ($selectedNumbers == null ? 43 : $selectedNumbers.hashCode());
		final Object $winCategory = this.getWinCategory();
		result = result * PRIME + ($winCategory == null ? 43 : $winCategory.hashCode());
		return result;
	}

	public void setGameType(LotteryGameType gameType)
	{
		this.gameType = gameType;
	}

	public void setIndex(Integer index)
	{
		this.index = index;
	}

	public void setSelectedNumbers(Set<Integer> selectedNumbers)
	{
		this.selectedNumbers = selectedNumbers;
	}

	public void setWinCategory(LotteryWinCategory winCategory)
	{
		this.winCategory = winCategory;
	}

	public LotteryBoxBuilder toBuilder()
	{
		return new LotteryBoxBuilder().gameType(this.gameType).index(this.index).selectedNumbers(
			this.selectedNumbers == null ? java.util.Collections.emptySet() : this.selectedNumbers)
			.winCategory(this.winCategory);
	}

	@Override
	public String toString()
	{
		return "LotteryBox(gameType=" + this.getGameType() + ", index=" + this.getIndex()
			+ ", selectedNumbers=" + this.getSelectedNumbers() + ", winCategory="
			+ this.getWinCategory() + ")";
	}
}
