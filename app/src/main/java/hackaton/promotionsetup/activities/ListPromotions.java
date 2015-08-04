package hackaton.promotionsetup.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import hackaton.promotionsetup.R;
import hackaton.promotionsetup.entities.Promotion;
import hackaton.promotionsetup.entities.PromotionStatus;

public class ListPromotions extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_list_promotions);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setListAdapter(mListAdapter);
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

        // TODO: complete implementation
        return promotions;
    }

    private Promotion createPromotion(String description, PromotionStatus currentStatus, double bonusAmount, double minAmount) {
        // TODO: complete implementation
        Promotion promo = new Promotion();


        return null;
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
}
