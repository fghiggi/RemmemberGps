package wka.com.remmembergps;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import wka.com.remmembergps.Utils.Constants;

/**
 * Created by slave00 on 6/1/16.
 */
public class GpsManager extends FragmentActivity implements LocationListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_status);

        ViewPager vp = (ViewPager) findViewById(R.id.viewPager);

        vp.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return;
        }

        locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, 0, 0, this );
        locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    public void onLocationChanged(Location location) {
        Intent i = new Intent(Constants.BROADCAST_LOCATION_SIGNATURE).
                putExtra(Constants.Intents.LOCATION_STATUS_LATITUDE, location.getLatitude()).
                putExtra(Constants.Intents.LOCATION_STATUS_LONGITUDE, location.getLongitude()).
                putExtra(Constants.Intents.LOCATION_STATUS_ALTITUDE, location.getAltitude()).
                putExtra(Constants.Intents.LOCATION_STATUS_SPEED, location.getSpeed());

        this.sendBroadcast(i);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
