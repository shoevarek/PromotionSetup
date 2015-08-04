package hackaton.promotionsetup.entities;

import java.util.Date;

/**
 * Created by vatermann on 8/3/2015.
 */
public class Promotion {
    private String id;
    private String title;
    private Date start;
    private Date end;
    private int percentage;
    private double bonusAmount;
    private double minAmount;
    private PromotionStatus currentStatus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    public PromotionStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(PromotionStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
