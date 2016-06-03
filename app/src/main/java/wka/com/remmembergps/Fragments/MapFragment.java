package wka.com.remmembergps.Fragments;

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

import java.util.List;

import wka.com.remmembergps.R;
import wka.com.remmembergps.Utils.Constants;
import wka.com.remmembergps.Utils.Constants.MapConstants;
import wka.com.remmembergps.data.Position;
import wka.com.remmembergps.data.PositionsDB;

/**
 * Created by slave00 on 6/1/16.
 */
public class MapFragment extends Fragment {
    private BroadcastReceiver mReceiver;
    private WebView mMap;
    PositionsDB mPdb;

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
                MapConstants.MARK_NOW_CONFIGURATION +
                String.valueOf(latitude) + ", " + String.valueOf(longitude) +
                MapConstants.ZOOM +
                MapConstants.SCALE +
                MapConstants.MAP_SIZE +
                MapConstants.MAP_TYPE +
                MapConstants.MAP_IMAGE_FORMAT +
                MapConstants.VISUAL_REFRESH + loadBookmarks();
    }

    @Override
    public void onResume() {
        super.onResume();

        mPdb = new PositionsDB(getActivity());

        IntentFilter intentFilter = new IntentFilter(
                Constants.BROADCAST_LOCATION_SIGNATURE);

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String x = getUrlBase(intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_LATITUDE, 0.0), intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_LONGITUDE, 0.0));
                mMap.loadUrl(x);
            }
        };

        getActivity().registerReceiver(mReceiver, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();

        mPdb.Close();

        getActivity().unregisterReceiver(this.mReceiver);
    }

    private String loadBookmarks() {
        String bookMarkUrl = "";
        List<Position> bookMarkPositions = mPdb.getPositions();

        for(Position p : bookMarkPositions) {
            bookMarkUrl += MapConstants.MARK_FAV_CONFIGURATION + p.toString();
        }

        return bookMarkUrl;
    }
}
