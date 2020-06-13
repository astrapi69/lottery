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

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link WinCategory} represents an win category for a lottery like lottery.
 *
 * For calculate the win categories see the description on the
 * <a href="https://github.com/astrapi69/lottery/wiki/compute-the-win-categories">
 *     wiki page
 * </a>
 *
 */
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WinCategory implements Cloneable
{

	/** The quantity of winning numbers. */
	int quantityOfWonNumbers;

	/** The flag if the played super number is selected. */
	boolean withSuperNumber;

	/** The quota of the profit in this win category */
	double quotaOfProfit;

	/** The fixed winning units is for win categories that have fixed winning units */
	@Builder.Default
	int fixedWinningUnits = 0;

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		WinCategory clone = WinCategory.builder().withSuperNumber(this.withSuperNumber)
			.quantityOfWonNumbers(this.quantityOfWonNumbers)
			.quotaOfProfit(this.quotaOfProfit)
			.fixedWinningUnits(this.fixedWinningUnits)
			.build();
		return clone;
	}
}
