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
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import wka.com.remmembergps.Utils.Constants.MapConstants;

/**
 * Created by slave00 on 6/1/16.
 */
public class MapFragment extends Fragment implements LocationListener {
    private WebView mapa;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_frag, container, false);

        mapa = (WebView) v.findViewById(R.id.mapa);
        mapa.setWebViewClient(new WebViewClient());

        mapa.getSettings().setJavaScriptEnabled(true);
        mapa.getSettings().setSupportZoom(true);

        mapa.loadUrl("http://maps.googleapis.com/maps/api/staticmap?center=campo+bom&zoom=13&scale=false&size=600x300&maptype=roadmap&format=png&visual_refresh=true");

        return v;
    }

    public static MapFragment newInstance() {
        MapFragment f = new MapFragment();

        return f;
    }

    private String getUrlBase(Double latitude, Double longitude) {
        return MapConstants.MAP_URL +
                MapConstants.CENTER_LOCATION +
                "-29.671529,-51.060181" +
                MapConstants.ZOOM +
                MapConstants.SCALE +
                MapConstants.MAP_SIZE +
                MapConstants.MAP_TYPE +
                MapConstants.MAP_IMAGE_FORMAT +
                MapConstants.VISUAL_REFRESH +
                MapConstants.MARK_NOW_CONFIGURATION + "-29.671529,-51.060181 +" +
                MapConstants.MARK_FAV_CONFIGURATION +"-29.671529,-51.080181";
    }


    @Override
    public void onLocationChanged(Location location) {

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
