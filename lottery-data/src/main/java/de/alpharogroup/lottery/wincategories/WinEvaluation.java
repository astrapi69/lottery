package de.alpharogroup.lottery.wincategories;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	double evaluationOfUnitsResult;
	C winCategory;
}
