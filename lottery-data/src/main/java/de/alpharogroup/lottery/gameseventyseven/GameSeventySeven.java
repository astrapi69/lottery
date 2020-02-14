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
package de.alpharogroup.lottery.gameseventyseven;

/**
 * The class {@link GameSeventySeven}.
 */
public class GameSeventySeven
{
	public static class GameSeventySevenBuilder
	{
		private Integer number;

		GameSeventySevenBuilder()
		{
		}

		public GameSeventySeven build()
		{
			return new GameSeventySeven(number);
		}

		public GameSeventySeven.GameSeventySevenBuilder number(Integer number)
		{
			this.number = number;
			return this;
		}

		@Override
		public String toString()
		{
			return "GameSeventySeven.GameSeventySevenBuilder(number=" + this.number + ")";
		}
	}

	public static GameSeventySevenBuilder builder()
	{
		return new GameSeventySevenBuilder();
	}

	/** The game seventy seven number. */
	private Integer number;

	public GameSeventySeven()
	{
	}

	public GameSeventySeven(Integer number)
	{
		this.number = number;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof GameSeventySeven;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof GameSeventySeven))
			return false;
		final GameSeventySeven other = (GameSeventySeven)o;
		if (!other.canEqual(this))
			return false;
		final Object this$number = this.getNumber();
		final Object other$number = other.getNumber();
		if (this$number == null ? other$number != null : !this$number.equals(other$number))
			return false;
		return true;
	}

	public Integer getNumber()
	{
		return this.number;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $number = this.getNumber();
		result = result * PRIME + ($number == null ? 43 : $number.hashCode());
		return result;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}

	public GameSeventySevenBuilder toBuilder()
	{
		return new GameSeventySevenBuilder().number(this.number);
	}

	@Override
	public String toString()
	{
		return "GameSeventySeven(number=" + this.getNumber() + ")";
	}
}
