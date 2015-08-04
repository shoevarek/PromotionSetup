package hackaton.promotionsetup.entities;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by vatermann on 8/3/2015.
 */
public class PromotionList {
    private List<Promotion> promotions;

    public boolean hasActive() {
        for (Promotion promotion : promotions) {
            if (PromotionStatus.ACTIVE.equals(promotion.getCurrentStatus())) {
                return true;
            }
        }

        return false;
    }

    public void addPromotion(Promotion promotion) {
        getPromotions().add(promotion);
    }

    public List<Promotion> getPromotions() {
        if (promotions == null) {
            promotions = new ArrayList<Promotion>();
        }

        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
