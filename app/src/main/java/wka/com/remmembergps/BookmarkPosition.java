package wka.com.remmembergps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import wka.com.remmembergps.Utils.Constants;

/**
 * Created by slave00 on 6/2/16.
 */
public class BookmarkPosition extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bookmark);

        TextView latitudeTextView = (TextView) findViewById( R.id.textView5 );
        latitudeTextView.setText(String.valueOf(getIntent().getStringExtra(Constants.Intents.LOCATION_STATUS_LATITUDE)));

        TextView longitudeTextView = (TextView) findViewById( R.id.textView6 );
        longitudeTextView.setText(String.valueOf(getIntent().getStringExtra(Constants.Intents.LOCATION_STATUS_LONGITUDE)));

    }
}
