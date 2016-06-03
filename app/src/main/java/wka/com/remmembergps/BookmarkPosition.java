package wka.com.remmembergps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wka.com.remmembergps.Utils.Constants;
import wka.com.remmembergps.data.Position;
import wka.com.remmembergps.data.PositionsDB;

/**
 * Created by slave00 on 6/2/16.
 */
public class BookmarkPosition extends Activity {
    private TextView mlatitude;
    private TextView mLongitude;
    private TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activiry_bookmark_layout);

        mlatitude = (TextView) findViewById( R.id.latitude_bookmark);
        mlatitude.setText(String.valueOf(getIntent().getStringExtra(Constants.Intents.LOCATION_STATUS_LATITUDE)));

        mLongitude = (TextView) findViewById( R.id.longitude_bookmark);
        mLongitude.setText(String.valueOf(getIntent().getStringExtra(Constants.Intents.LOCATION_STATUS_LONGITUDE)));

        mDescription = (TextView) findViewById( R.id.description_bookmark);

        Button button = (Button) findViewById(R.id.button_save_bookmark);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PositionsDB pdb = new PositionsDB(getApplicationContext());
                Position p = new Position();
                p.setLatitude(mlatitude.getText().toString());
                p.setLongitude(mLongitude.getText().toString());
                p.setDescription(mDescription.getText().toString());

                pdb.addPosition(p);

                finish();
            }
        });
    }
}
