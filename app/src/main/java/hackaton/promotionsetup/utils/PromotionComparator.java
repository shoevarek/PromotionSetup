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
                return -1;
            } else {
                if (PromotionStatus.DRAFT.equals(lhs.getCurrentStatus())) {
                    return -1;
                }

                return 1;
            }
        } else {
            int i = compareDates(lhs, rhs);

            if (i == 0) {
                i = compareTitles(lhs, rhs);
            }

            return i;
        }
    }

    private int compareTitles(Promotion lhs, Promotion rhs) {
        return lhs.getTitle().compareTo(rhs.getTitle());
    }

    private int compareDates(Promotion lhs, Promotion rhs) {
        return -1 * lhs.getEnd().compareTo(rhs.getEnd());
    }
}
