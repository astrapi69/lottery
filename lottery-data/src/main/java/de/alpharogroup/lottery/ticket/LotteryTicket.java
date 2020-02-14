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
package de.alpharogroup.lottery.ticket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import de.alpharogroup.lottery.box.LotteryBox;
import de.alpharogroup.lottery.gameseventyseven.GameSeventySeven;

/**
 * The class {@link LotteryTicket} represents a played lottery ticket.
 */
public class LotteryTicket
{
	public static class LotteryTicketBuilder
	{
		private GameSeventySeven gameSeventySeven;
		private String id;
		private ArrayList<LotteryBox> lotteryBoxes;
		private Integer superNumber;
		private Integer superSixNumber;

		LotteryTicketBuilder()
		{
		}

		public LotteryTicket build()
		{
			Set<LotteryBox> lotteryBoxes;
			switch (this.lotteryBoxes == null ? 0 : this.lotteryBoxes.size())
			{
				case 0 :
					lotteryBoxes = java.util.Collections.emptySet();
					break;
				case 1 :
					lotteryBoxes = java.util.Collections.singleton(this.lotteryBoxes.get(0));
					break;
				default :
					lotteryBoxes = new java.util.LinkedHashSet<LotteryBox>(
						this.lotteryBoxes.size() < 1073741824
							? 1 + this.lotteryBoxes.size() + (this.lotteryBoxes.size() - 3) / 3
							: Integer.MAX_VALUE);
					lotteryBoxes.addAll(this.lotteryBoxes);
					lotteryBoxes = java.util.Collections.unmodifiableSet(lotteryBoxes);
			}

			return new LotteryTicket(gameSeventySeven, id, lotteryBoxes, superNumber,
				superSixNumber);
		}

		public LotteryTicket.LotteryTicketBuilder clearLotteryBoxes()
		{
			if (this.lotteryBoxes != null)
				this.lotteryBoxes.clear();
			return this;
		}

		public LotteryTicket.LotteryTicketBuilder gameSeventySeven(
			GameSeventySeven gameSeventySeven)
		{
			this.gameSeventySeven = gameSeventySeven;
			return this;
		}

		public LotteryTicket.LotteryTicketBuilder id(String id)
		{
			this.id = id;
			return this;
		}

		public LotteryTicket.LotteryTicketBuilder lotteryBox(LotteryBox lotteryBox)
		{
			if (this.lotteryBoxes == null)
				this.lotteryBoxes = new ArrayList<LotteryBox>();
			this.lotteryBoxes.add(lotteryBox);
			return this;
		}

		public LotteryTicket.LotteryTicketBuilder lotteryBoxes(
			Collection<? extends LotteryBox> lotteryBoxes)
		{
			if (this.lotteryBoxes == null)
				this.lotteryBoxes = new ArrayList<LotteryBox>();
			this.lotteryBoxes.addAll(lotteryBoxes);
			return this;
		}

		public LotteryTicket.LotteryTicketBuilder superNumber(Integer superNumber)
		{
			this.superNumber = superNumber;
			return this;
		}

		public LotteryTicket.LotteryTicketBuilder superSixNumber(Integer superSixNumber)
		{
			this.superSixNumber = superSixNumber;
			return this;
		}

		@Override
		public String toString()
		{
			return "LotteryTicket.LotteryTicketBuilder(gameSeventySeven=" + this.gameSeventySeven
				+ ", id=" + this.id + ", lotteryBoxes=" + this.lotteryBoxes + ", superNumber="
				+ this.superNumber + ", superSixNumber=" + this.superSixNumber + ")";
		}
	}

	public static LotteryTicketBuilder builder()
	{
		return new LotteryTicketBuilder();
	}

	/** The game seventy seven. */
	private GameSeventySeven gameSeventySeven;

	/** The id. */
	private String id;

	/** The played lottery boxes. */
	private Set<LotteryBox> lotteryBoxes;

	/** The super number. */
	private Integer superNumber;

	/** The super six number. */
	private Integer superSixNumber;

	public LotteryTicket()
	{
	}

	public LotteryTicket(GameSeventySeven gameSeventySeven, String id, Set<LotteryBox> lotteryBoxes,
		Integer superNumber, Integer superSixNumber)
	{
		this.gameSeventySeven = gameSeventySeven;
		this.id = id;
		this.lotteryBoxes = lotteryBoxes;
		this.superNumber = superNumber;
		this.superSixNumber = superSixNumber;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof LotteryTicket;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof LotteryTicket))
			return false;
		final LotteryTicket other = (LotteryTicket)o;
		if (!other.canEqual(this))
			return false;
		final Object this$gameSeventySeven = this.getGameSeventySeven();
		final Object other$gameSeventySeven = other.getGameSeventySeven();
		if (this$gameSeventySeven == null
			? other$gameSeventySeven != null
			: !this$gameSeventySeven.equals(other$gameSeventySeven))
			return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id))
			return false;
		final Object this$lotteryBoxes = this.getLotteryBoxes();
		final Object other$lotteryBoxes = other.getLotteryBoxes();
		if (this$lotteryBoxes == null
			? other$lotteryBoxes != null
			: !this$lotteryBoxes.equals(other$lotteryBoxes))
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

	public GameSeventySeven getGameSeventySeven()
	{
		return this.gameSeventySeven;
	}

	public String getId()
	{
		return this.id;
	}

	public Set<LotteryBox> getLotteryBoxes()
	{
		return this.lotteryBoxes;
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
		final Object $gameSeventySeven = this.getGameSeventySeven();
		result = result * PRIME + ($gameSeventySeven == null ? 43 : $gameSeventySeven.hashCode());
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $lotteryBoxes = this.getLotteryBoxes();
		result = result * PRIME + ($lotteryBoxes == null ? 43 : $lotteryBoxes.hashCode());
		final Object $superNumber = this.getSuperNumber();
		result = result * PRIME + ($superNumber == null ? 43 : $superNumber.hashCode());
		final Object $superSixNumber = this.getSuperSixNumber();
		result = result * PRIME + ($superSixNumber == null ? 43 : $superSixNumber.hashCode());
		return result;
	}

	public void setGameSeventySeven(GameSeventySeven gameSeventySeven)
	{
		this.gameSeventySeven = gameSeventySeven;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setLotteryBoxes(Set<LotteryBox> lotteryBoxes)
	{
		this.lotteryBoxes = lotteryBoxes;
	}

	public void setSuperNumber(Integer superNumber)
	{
		this.superNumber = superNumber;
	}

	public void setSuperSixNumber(Integer superSixNumber)
	{
		this.superSixNumber = superSixNumber;
	}

	public LotteryTicketBuilder toBuilder()
	{
		return new LotteryTicketBuilder().gameSeventySeven(this.gameSeventySeven).id(this.id)
			.lotteryBoxes(
				this.lotteryBoxes == null ? java.util.Collections.emptySet() : this.lotteryBoxes)
			.superNumber(this.superNumber).superSixNumber(this.superSixNumber);
	}

	@Override
	public String toString()
	{
		return "LotteryTicket(gameSeventySeven=" + this.getGameSeventySeven() + ", id="
			+ this.getId() + ", lotteryBoxes=" + this.getLotteryBoxes() + ", superNumber="
			+ this.getSuperNumber() + ", superSixNumber=" + this.getSuperSixNumber() + ")";
	}
}
