package hackaton.promotionsetup.views;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.LinearLayout;

/**
 * Created by vatermann on 8/3/2015.
 */
public class PromotionViewHolder {
    private LinearLayout rowLayout;
    private TextView statusText;
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

    public LinearLayout getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(LinearLayout rowlayout) {
        this.rowLayout = rowlayout;
    }

    public TextView getStatusText() {
        return statusText;
    }

    public void setStatusText(TextView statusText) {
        this.statusText = statusText;
    }
}
