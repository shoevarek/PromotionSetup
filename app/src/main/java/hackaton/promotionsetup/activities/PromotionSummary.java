package hackaton.promotionsetup.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import hackaton.promotionsetup.R;
import hackaton.promotionsetup.entities.Promotion;

public class PromotionSummary extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_summary);

        Button btnCancel = (Button) findViewById(R.id.view_cancel_button);
        btnCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListPromotions.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        Promotion promotion = (Promotion) getIntent().getExtras().get("current_promotion");

        TextView offerText = (TextView) findViewById(R.id.view_offerText);
        offerText.setText(promotion.getTitle());

        TextView bonusText = (TextView) findViewById(R.id.view_bonusAmount);
        bonusText.setText(String.format(getResources().getString(R.string.view_bonus_amount), promotion.getBonusAmount()));

        TextView transText = (TextView) findViewById(R.id.view_transactionAmount);
        transText.setText(String.format(getResources().getString(R.string.view_trans_amount), promotion.getMinAmount()));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        TextView startText = (TextView) findViewById(R.id.view_offerStartDate);
        startText.setText(String.format(getResources().getString(R.string.view_start_dt), df.format(promotion.getStart())));

        TextView endText = (TextView) findViewById(R.id.view_offerEndDate);
        endText.setText(String.format(getResources().getString(R.string.view_end_dt), df.format(promotion.getEnd())));

        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_promotions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Logoff) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}