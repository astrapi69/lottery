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

import java.util.Set;

import de.alpharogroup.lottery.enums.LotteryGameType;
import de.alpharogroup.lottery.wincategories.LotteryWinCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link LotteryBox} represents exactly one lottery box in a lottery ticket
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LotteryBox
{

	/** The lottery game type. */
	LotteryGameType gameType;

	/** The index of this box in the lottery ticket */
	Integer index;

	/** The selected numbers. */
	@Singular
	Set<Integer> selectedNumbers;

	/** The lottery win category. */
	LotteryWinCategory winCategory;
}
