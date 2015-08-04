package hackaton.promotionsetup.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import hackaton.promotionsetup.R;
import hackaton.promotionsetup.entities.Promotion;

public class PromotionSetup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_setup);

        Button submitBtn = (Button) findViewById(R.id.submit_button);
        submitBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListPromotions.class);
                // TODO: update promotion list
                startActivity(i);
            }
        });

        Button cancelBtn = (Button) findViewById(R.id.cancel_button);
        cancelBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListPromotions.class);
                // do  nothing
                startActivity(i);
            }
        });
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
