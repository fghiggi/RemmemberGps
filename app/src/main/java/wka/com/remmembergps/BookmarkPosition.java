package wka.com.remmembergps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * Created by slave00 on 6/2/16.
 */
public class BookmarkPosition extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bookmark);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        if( b != null ) {
            Double latitude = b.getDouble( "latitude" );
            Double longitude = b.getDouble( "longitude" );

            TextView latitudeTextView = (TextView) findViewById( R.id.textView5 );
            latitudeTextView.setText( String.valueOf(latitude) );

            TextView longitudeTextView = (TextView) findViewById( R.id.textView6 );
            longitudeTextView.setText( String.valueOf(longitude) );
        }
    }
}
