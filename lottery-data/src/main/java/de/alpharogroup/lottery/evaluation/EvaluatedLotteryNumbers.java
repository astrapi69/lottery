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
package de.alpharogroup.lottery.evaluation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import de.alpharogroup.collections.map.MapFactory;
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
 * The class {@link EvaluatedLotteryNumbers} contains the evaluated result of the drawn lottery
 * numbers and the played numbers of a player.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EvaluatedLotteryNumbers
{

	/** The id. */
	Integer id;

	/** The evaluated game seventy seven. */
	Integer wonGameSeventySevenNumber;

	/** The played lottery numbers. */
	@Builder.Default
	Map<LotteryGameType, List<Collection<Integer>>> wonLotteryNumbers = MapFactory.newHashMap();

	/** The evaluated super number. */
	Integer wonSuperNumber;

	/** The evaluated super six number. */
	Integer wonSuperSixNumber;

}
