package wka.com.remmembergps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by slave00 on 6/1/16.
 */
public class GpsStatusFragment extends Fragment implements LocationListener {
    TextView latitude;
    TextView longitude;
    TextView speed;
    TextView altitude;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);

        latitude = (TextView) v.findViewById(R.id.textView);
        longitude = (TextView) v.findViewById(R.id.textView2);
        speed = (TextView) v.findViewById(R.id.textView3);
        altitude = (TextView) v.findViewById(R.id.textView4);

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return v;
        }

        locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, 0, 0, this );
        locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, this);

        return v;
    }

    public static GpsStatusFragment newInstance() {

        GpsStatusFragment f = new GpsStatusFragment();
        Bundle b = new Bundle();

        return f;
    }

    @Override
    public void onLocationChanged(Location location) {
        String latitudeStr = String.valueOf(location.getLatitude());
        String longitudeStr = String.valueOf(location.getLongitude());
        String velocidadeStr = String.valueOf(location.getSpeed());
        String altitudeStr = String.valueOf(location.getAltitude());

        latitude.setText(latitudeStr);
        longitude.setText(longitudeStr);
        speed.setText(velocidadeStr);
        altitude.setText(altitudeStr);
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

    @Override
    public void onResume() {
        super.onResume();
        //getActivity().registerReceiver();
    }
}