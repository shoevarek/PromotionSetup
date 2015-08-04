package hackaton.promotionsetup.views;

import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by vatermann on 8/3/2015.
 */
public class PromotionViewHolder {
    private TextView titleText;
    private TextView durationText;
    private ImageButton viewButton;
    private ImageButton statusButton;

    public TextView getTitleText() {
        return titleText;
    }

    public void setTitleText(TextView titleText) {
        this.titleText = titleText;
    }

    public TextView getDurationText() {
        return durationText;
    }

    public void setDurationText(TextView durationText) {
        this.durationText = durationText;
    }

    public ImageButton getViewButton() {
        return viewButton;
    }

    public void setViewButton(ImageButton viewButton) {
        this.viewButton = viewButton;
    }

    public ImageButton getStatusButton() {
        return statusButton;
    }

    public void setStatusButton(ImageButton statusButton) {
        this.statusButton = statusButton;
    }
}
