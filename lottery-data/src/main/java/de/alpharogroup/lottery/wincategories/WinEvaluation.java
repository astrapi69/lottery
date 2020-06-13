package de.alpharogroup.lottery.wincategories;

import de.alpharogroup.lottery.ticket.LotteryTicket;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link WinEvaluation} represents a played lottery ticket.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WinEvaluation<C extends WinningOpportunity>
{
	C winCategory;
	double evaluationOfUnitsResult;
}
