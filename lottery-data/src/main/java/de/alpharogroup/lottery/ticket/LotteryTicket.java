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

import java.util.Set;

import de.alpharogroup.lottery.box.LotteryBox;
import de.alpharogroup.lottery.gameseventyseven.GameSeventySeven;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link LotteryTicket} represents a played lottery ticket.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LotteryTicket
{
	/** The game seventy seven. */
	GameSeventySeven gameSeventySeven;

	/** The id. */
	String id;

	/** The played lottery boxes. */
	@Singular
	Set<LotteryBox> lotteryBoxes;

	/** The super number. */
	Integer superNumber;

	/** The super six number. */
	Integer superSixNumber;
}
