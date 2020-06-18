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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link EuroMillionsWinCategory} represents an win category for the EuroMillion lottery.
 */
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EuroMillionsWinCategory implements Cloneable, WinningOpportunity
{

	/** The computation. */
	String computation;

	/** The payout rate of this winning category. */
	double payoutRate;

	/** The quantity of winning numbers. */
	int quantityOfWonNumbers;

	/** The quantity of winning star numbers. */
	int quantityOfWonStarNumbers;

	/** The flag if the joker is selected. */
	boolean withJoker;

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		EuroMillionsWinCategory clone = EuroMillionsWinCategory.builder()
			.computation(this.computation).payoutRate(this.payoutRate).withJoker(this.withJoker)
			.quantityOfWonNumbers(this.quantityOfWonNumbers)
			.quantityOfWonStarNumbers(this.quantityOfWonStarNumbers).build();
		return clone;
	}
}
