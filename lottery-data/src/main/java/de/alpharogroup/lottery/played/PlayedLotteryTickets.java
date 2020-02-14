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

import java.util.Set;

import de.alpharogroup.lottery.ticket.LotteryTicket;

/**
 * The class {@link PlayedLotteryTickets} contains the played lottery tickets of a lottery player.
 */
public class PlayedLotteryTickets
{

	public static class PlayedLotteryTicketsBuilder
	{
		private Set<LotteryTicket> lotteryTickets;
		private String user;

		PlayedLotteryTicketsBuilder()
		{
		}

		public PlayedLotteryTickets build()
		{
			return new PlayedLotteryTickets(lotteryTickets, user);
		}

		public PlayedLotteryTickets.PlayedLotteryTicketsBuilder lotteryTickets(
			Set<LotteryTicket> lotteryTickets)
		{
			this.lotteryTickets = lotteryTickets;
			return this;
		}

		@Override
		public String toString()
		{
			return "PlayedLotteryTickets.PlayedLotteryTicketsBuilder(lotteryTickets="
				+ this.lotteryTickets + ", user=" + this.user + ")";
		}

		public PlayedLotteryTickets.PlayedLotteryTicketsBuilder user(String user)
		{
			this.user = user;
			return this;
		}
	}

	public static PlayedLotteryTicketsBuilder builder()
	{
		return new PlayedLotteryTicketsBuilder();
	}

	/** The lottery tickets. */
	private Set<LotteryTicket> lotteryTickets;

	/** The user. */
	private String user;

	public PlayedLotteryTickets()
	{
	}

	public PlayedLotteryTickets(Set<LotteryTicket> lotteryTickets, String user)
	{
		this.lotteryTickets = lotteryTickets;
		this.user = user;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof PlayedLotteryTickets;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof PlayedLotteryTickets))
			return false;
		final PlayedLotteryTickets other = (PlayedLotteryTickets)o;
		if (!other.canEqual(this))
			return false;
		final Object this$lotteryTickets = this.getLotteryTickets();
		final Object other$lotteryTickets = other.getLotteryTickets();
		if (this$lotteryTickets == null
			? other$lotteryTickets != null
			: !this$lotteryTickets.equals(other$lotteryTickets))
			return false;
		final Object this$user = this.getUser();
		final Object other$user = other.getUser();
		if (this$user == null ? other$user != null : !this$user.equals(other$user))
			return false;
		return true;
	}

	public Set<LotteryTicket> getLotteryTickets()
	{
		return this.lotteryTickets;
	}

	public String getUser()
	{
		return this.user;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $lotteryTickets = this.getLotteryTickets();
		result = result * PRIME + ($lotteryTickets == null ? 43 : $lotteryTickets.hashCode());
		final Object $user = this.getUser();
		result = result * PRIME + ($user == null ? 43 : $user.hashCode());
		return result;
	}

	public void setLotteryTickets(Set<LotteryTicket> lotteryTickets)
	{
		this.lotteryTickets = lotteryTickets;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public PlayedLotteryTicketsBuilder toBuilder()
	{
		return new PlayedLotteryTicketsBuilder().lotteryTickets(this.lotteryTickets)
			.user(this.user);
	}

	@Override
	public String toString()
	{
		return "PlayedLotteryTickets(lotteryTickets=" + this.getLotteryTickets() + ", user="
			+ this.getUser() + ")";
	}
}
