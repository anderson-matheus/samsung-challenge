package android.curso.samsungchallenge.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.curso.samsungchallenge.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MonitoringFragment extends Fragment {

    View view;

    public MonitoringFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.monitoring_fragment, container, false);

        final Intent intentDeviceTest = new Intent("android.intent.action.MAIN");
        intentDeviceTest.setComponent(new ComponentName("com.example.android.appsmonitor","com.example.android.monitor.ui.MainActivity"));
        startActivity(intentDeviceTest);
        return view;
    }
}
