package hackaton.promotionsetup.utils;

import java.util.Comparator;

import hackaton.promotionsetup.entities.Promotion;
import hackaton.promotionsetup.entities.PromotionStatus;

/**
 * Created by vatermann on 8/3/2015.
 */
public class PromotionComparator implements Comparator<Promotion> {

    @Override
    public int compare(Promotion lhs, Promotion rhs) {
        if (!lhs.getCurrentStatus().equals(rhs.getCurrentStatus())) {
            if (PromotionStatus.ACTIVE.equals(lhs.getCurrentStatus())) {
                return 1;
            } else {
                return -1;
            }
        } else {
            int i = compareDates(lhs, rhs);

            if (i == 0) {
                i = compareDescriptions(lhs, rhs);
            }

            return i;
        }
    }

    private int compareDescriptions(Promotion lhs, Promotion rhs) {
        return lhs.getDescription().compareTo(rhs.getDescription());
    }

    private int compareDates(Promotion lhs, Promotion rhs) {
        return lhs.getEnd().compareTo(rhs.getEnd());
    }
}
