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

import java.util.List;
import java.util.Map;
import java.util.Set;

import de.alpharogroup.lottery.enums.LotteryGameType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link LotteryPlayedNumbers} contains the data of the lottery player.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LotteryPlayedNumbers implements Cloneable
{

	/** The id. */
	Integer id;

	/** The played lottery numbers. */
	Map<LotteryGameType, List<Set<Integer>>> playedLotteryNumbers;

	/** The super number. */
	Integer superNumber;

	/** The super six number. */
	Integer superSixNumber;

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return LotteryPlayedNumbers.builder().id(id).playedLotteryNumbers(playedLotteryNumbers)
			.superSixNumber(superSixNumber).superNumber(superNumber).build();
	}
}
