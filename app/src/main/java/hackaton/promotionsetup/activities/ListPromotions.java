package hackaton.promotionsetup.activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import hackaton.promotionsetup.R;
import hackaton.promotionsetup.entities.Promotion;
import hackaton.promotionsetup.entities.PromotionStatus;
import hackaton.promotionsetup.utils.PromotionComparator;
import hackaton.promotionsetup.views.PromotionViewHolder;

public class ListPromotions extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_list_promotions);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Promotion> promotions = createTestPromotions();
        Collections.sort(promotions, new PromotionComparator());
        PromotionListAdapter listAdapter = new PromotionListAdapter(this, R.id.list_item, promotions);

        //setListAdapter(mListAdapter);
        setListAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_list_promotions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.Logoff) {
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);

                    return true;
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Promotion> createTestPromotions() {
        List<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(createPromotion("P003", "Spend 100$ and get 50$ off", PromotionStatus.ACTIVE, 10.0d, 100.0d, "2015-08-04", "2015-08-04"));
        promotions.add(createPromotion("P005", "Spend 50$ and get 5$ off", PromotionStatus.EXPIRED, 5.0d, 50.0d, "2015-05-30", "2015-05-31"));
        promotions.add(createPromotion("P006", "Spend 50$ and get 5$ off", PromotionStatus.EXPIRED, 5.0d, 50.0d, "2015-06-06", "2015-06-07"));
        promotions.add(createPromotion("P007", "Spend 50$ and get 5$ off", PromotionStatus.EXPIRED, 5.0d, 50.0d, "2015-06-13", "2015-06-14"));
        promotions.add(createPromotion("P008", "Spend 50$ and get 5$ off", PromotionStatus.EXPIRED, 5.0d, 50.0d, "2015-06-20", "2015-06-21"));
        promotions.add(createPromotion("P009", "Spend 50$ and get 5$ off", PromotionStatus.EXPIRED, 5.0d, 50.0d, "2015-06-27", "2015-06-28"));
        promotions.add(createPromotion("P010", "Spend 50$ and get 5$ off", PromotionStatus.EXPIRED, 5.0d, 50.0d, "2015-07-04", "2015-07-05"));
        promotions.add(createPromotion("P011", "Spend 50$ and get 5$ off", PromotionStatus.EXPIRED, 5.0d, 50.0d, "2015-07-11", "2015-07-12"));
        promotions.add(createPromotion("P012", "Spend 10$ and get 1$ off", PromotionStatus.EXPIRED, 1.0d, 10.0d, "2015-07-18", "2015-07-19"));
        promotions.add(createPromotion("P013", "Spend 100$ and get 10$ off", PromotionStatus.DRAFT, 10.0d, 100.0d, "2015-08-06", "2015-08-07"));

        return promotions;
    }

    private Promotion createPromotion(String id, String title, PromotionStatus currentStatus, double bonusAmount, double minAmount, String start, String end) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Promotion promo = new Promotion();
        promo.setTitle(title);
        promo.setCurrentStatus(currentStatus);
        promo.setBonusAmount(bonusAmount);
        promo.setMinAmount(minAmount);
        promo.setId(id);

        try {
            promo.setStart(df.parse(start));
            promo.setEnd(df.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return promo;
    }

    private BaseAdapter mListAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position + 1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
            }

            // Because the list item contains multiple touch targets, you should not override
            // onListItemClick. Instead, set a click listener for each target individually.

            convertView.findViewById(R.id.secondary_action).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(ListPromotions.this,
                                    R.string.item_tooltip,
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

            return convertView;
        }
    };

    public class PromotionListAdapter extends ArrayAdapter<Promotion> {
        private List<Promotion> promotions;

        public PromotionListAdapter(Context context, int layoutFileId, List<Promotion> promotions) {
            super(context, layoutFileId, promotions);

            this.promotions = new ArrayList<Promotion>();
            this.promotions.addAll(promotions);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            PromotionViewHolder viewHolder = new PromotionViewHolder();

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false);
            }

            // set view holder with UI widget references
            viewHolder.setRowLayout((LinearLayout) convertView.findViewById(R.id.promo_row));
            viewHolder.setTitleText((TextView) convertView.findViewById(R.id.promo_title));
            viewHolder.setDurationText((TextView) convertView.findViewById(R.id.promo_desc));
            viewHolder.setViewButton((ImageButton) convertView.findViewById(R.id.secondary_action));
            viewHolder.setStatusButton((ImageButton) convertView.findViewById(R.id.img_status));
            viewHolder.setStatusText((TextView) convertView.findViewById(R.id.lbl_status));

            // set UI widget content
            final Promotion promotion = promotions.get(position);
            viewHolder.getTitleText().setText(promotion.getTitle());
            viewHolder.getDurationText().setText(formatDurationText(promotion.getStart(), promotion.getEnd()));

            // set UI widget style
            switch (promotion.getCurrentStatus()) {
                case ACTIVE:
                    viewHolder.getRowLayout().setBackgroundColor(0xFFFFEB3B);
                    viewHolder.getViewButton().refreshDrawableState();
                    viewHolder.getViewButton().setImageResource(R.drawable.ic_equalizer_white_24dp);
                    viewHolder.getStatusButton().setImageResource(R.drawable.ic_av_timer_white_24dp);
                    viewHolder.getStatusText().setText(getResources().getString(R.string.item_status_active));
                    viewHolder.getViewButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), PromotionSummary.class);
                            i.putExtra("current_promotion", promotion);
                            startActivity(i);
                        }
                    });
                    viewHolder.getViewButton().refreshDrawableState();
                    break;
                case EXPIRED:
                    viewHolder.getRowLayout().setBackgroundColor(0x0FF9FA8DA);
                    viewHolder.getViewButton().refreshDrawableState();
                    viewHolder.getViewButton().setImageResource(R.drawable.ic_equalizer_white_24dp);
                    viewHolder.getStatusButton().setImageResource(R.drawable.ic_history_white_24dp);
                    viewHolder.getStatusText().setText(getResources().getString(R.string.item_status_expired));
                    viewHolder.getViewButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), PromotionSummary.class);
                            i.putExtra("current_promotion", promotion);
                            startActivity(i);
                        }
                    });
                    viewHolder.getViewButton().refreshDrawableState();
                    break;
                case DRAFT:
                    viewHolder.getViewButton().setImageResource(R.drawable.ic_settings_white_24dp);
                    viewHolder.getStatusButton().setImageResource(R.drawable.ic_build_white_24dp);
                    viewHolder.getStatusText().setText(getResources().getString(R.string.item_status_draft));
                    viewHolder.getViewButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), PromotionSetup.class);
                            i.putExtra("current_promotion", promotion);
                            startActivity(i);
                        }
                    });
                    viewHolder.getViewButton().refreshDrawableState();
                    break;
                default:
                    viewHolder.getStatusText().setText(getResources().getString(R.string.item_status_expired));
                    viewHolder.getViewButton().refreshDrawableState();
            }

            // set UI widget listeners
            //viewHolder.getViewButton().setOnClickListener(new View.OnClickListener() {
            //    @Override
            //public void onClick(View view) {
                    //Toast.makeText(ListPromotions.this,
                    //        R.string.item_tooltip,
                    //        Toast.LENGTH_SHORT).show();
            //        String tooltip = getResources().getString(R.string.item_tooltip);

            //        Toast.makeText(ListPromotions.this, String.format(tooltip, promotion.getId()), Toast.LENGTH_SHORT).show();
            //    }
            //});

            return convertView;
        }

        private String formatDurationText(Date start, Date end) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            StringBuilder sb = new StringBuilder();
            sb.append("From ").append(df.format(start)).append(" to ").append(df.format(end));

            return sb.toString();
        }
    };
}
