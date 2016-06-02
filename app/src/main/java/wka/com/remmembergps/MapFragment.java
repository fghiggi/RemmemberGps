package wka.com.remmembergps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import wka.com.remmembergps.Utils.Constants;
import wka.com.remmembergps.Utils.Constants.MapConstants;

/**
 * Created by slave00 on 6/1/16.
 */
public class MapFragment extends Fragment {
    private BroadcastReceiver mReceiver;
    private WebView mMap;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_frag, container, false);

        mMap = (WebView) v.findViewById(R.id.mapa);
        mMap.setWebViewClient(new WebViewClient());

        mMap.getSettings().setJavaScriptEnabled(true);
        mMap.getSettings().setSupportZoom(true);

        return v;
    }

    public static MapFragment newInstance() {
        MapFragment f = new MapFragment();

        return f;
    }

    private String getUrlBase(Double latitude, Double longitude) {
        return MapConstants.MAP_URL +
                MapConstants.CENTER_LOCATION +
                String.valueOf(latitude) + String.valueOf(longitude) +
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
    public void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter(
                Constants.BROADCAST_LOCATION_SIGNATURE);

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mMap.loadUrl(getUrlBase(intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_LATITUDE, 0.0), intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_LONGITUDE, 0.0)));
            }
        };

        getActivity().registerReceiver(mReceiver, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();

        getActivity().unregisterReceiver(this.mReceiver);
    }
}
