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
import android.widget.TextView;

import wka.com.remmembergps.Utils.Constants;

/**
 * Created by slave00 on 6/1/16.
 */
public class GpsStatusFragment extends Fragment {
    private BroadcastReceiver mReceiver;
    private TextView mLatitude;
    private TextView mLongitude;
    private TextView mSpeed;
    private TextView mAltitude;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);

        mLatitude = (TextView) v.findViewById(R.id.textView);
        mLongitude = (TextView) v.findViewById(R.id.textView2);
        mSpeed = (TextView) v.findViewById(R.id.textView3);
        mAltitude = (TextView) v.findViewById(R.id.textView4);

        return v;
    }

    public static GpsStatusFragment newInstance() {
        GpsStatusFragment f = new GpsStatusFragment();

        return f;
    }

    @Override
    public void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter(
                Constants.BROADCAST_LOCATION_SIGNATURE);

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mLatitude.setText(String.valueOf(intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_LATITUDE, 0.0)));
                mLongitude.setText(String.valueOf(intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_LONGITUDE, 0.0)));
                mSpeed.setText(String.valueOf(intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_SPEED, 0.0)));
                mAltitude.setText(String.valueOf(intent.getDoubleExtra(Constants.Intents.LOCATION_STATUS_ALTITUDE, 0.0)));
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