package com.example.chalang.testapplication;
import Controller.Controller;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import Utilities.AndroidUtilities;
import Utilities.PrayerTime;

//import com.google.android.gms.location.LocationRequest;

public class MainActivity extends ActionBarActivity implements LocationListener {
    Location loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(android.R.layout.activity_main);
        setContentView(R.layout.activity_main);
        Controller controller = new Controller(this);
//        AndroidUtilities utils = new AndroidUtilities(this);
//        Location loc;
//        if (utils.getGPSLocation() != null)
//            loc = utils.getGPSLocation();
//        else if (utils.getNetLocation() != null)
//            loc = utils.getNetLocation();
//        else
//            loc = utils.getPassLocations();
//
//        TextView view = (TextView) findViewById(R.id.textView);
//        TextView view2 = (TextView) findViewById(R.id.textView2);
//        TextView view3 = (TextView) findViewById(R.id.textView3);
//
//
//        TextView view4= (TextView) findViewById(R.id.textView4);
//        TextView view5= (TextView) findViewById(R.id.textView5);
//        TextView view6= (TextView) findViewById(R.id.textView6);
//        TextView view7= (TextView) findViewById(R.id.textView7);
//        TextView view8= (TextView) findViewById(R.id.textView8);
//        TextView view9= (TextView) findViewById(R.id.textView9);
//        TextView view10= (TextView) findViewById(R.id.textView10);



//        view3.setText("GPS METHOD: " + loc.getProvider());
//        view.setText("Latitude: " + loc.getLatitude());
//        view2.setText("Longitude: " + loc.getLongitude());
//        PrayerTime times = new PrayerTime();
//
//        ArrayList<String> listTimes = times.getTimes(loc.getLatitude(),loc.getLongitude(), 7);
//
//        view4.setText("Fajr " +utils.removeAMandPm(listTimes.get(0))+"am");
//        view5.setText("Sunrise " +utils.removeAMandPm(listTimes.get(1))+"am");
//        view6.setText("Duhr " +utils.removeAMandPm(listTimes.get(2))+"pm");
//        view7.setText("Asr " +utils.removeAMandPm(listTimes.get(3))+"pm");
//        view8.setText("Sunset " +utils.removeAMandPm(listTimes.get(4))+"pm");
//        view9.setText("Maghrib  " +utils.removeAMandPm(listTimes.get(5))+"pm");
//        view10.setText("Eisha " +utils.removeAMandPm(listTimes.get(6))+"pm");

    }

    @Override
    public void onLocationChanged(Location location) {
        this.loc = location;
    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String porvider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
