package hackaton.promotionsetup.entities;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by vatermann on 8/3/2015.
 */
public class PromotionList {
    private static List<Promotion> promotions;

    public static void addPromotion(Promotion promotion) {
        getPromotions().add(promotion);
    }

    public static List<Promotion> getPromotions() {
        if (PromotionList.promotions == null) {
            PromotionList.promotions = new ArrayList<Promotion>();
        }

        return PromotionList.promotions;
    }

    public static void setPromotions(List<Promotion> promotions) {
        PromotionList.promotions = promotions;
    }
}
