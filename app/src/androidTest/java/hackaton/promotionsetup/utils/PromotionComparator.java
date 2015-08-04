package hackaton.promotionsetup.utils;

import java.util.Comparator;

import hackaton.promotionsetup.entities.Promotion;

/**
 * Created by vatermann on 8/3/2015.
 */
public class PromotionComparator implements Comparator<Promotion> {


    @Override
    public int compare(Promotion lhs, Promotion rhs) {
        if (!lhs.getCurrentStatus().equals(rhs.getCurrentStatus())) {

        } else {

        }

        return 0;
    }
}
