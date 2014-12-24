package Utilities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.example.chalang.testapplication.MainActivity;
import com.example.chalang.testapplication.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chalang on 12/19/2014.
 */
public class AndroidUtilities implements LocationListener {
    MainActivity main;
    Location locNet;
    Location locGps;
    Location locPass;

    public AndroidUtilities(MainActivity main) {
        this.main = main;
        initializeLocation();
    }


    public Date getTimeAndDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public void initializeLocation() {
        LocationManager lm = (LocationManager) main.getSystemService(Context.LOCATION_SERVICE);
        this.locNet = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        this.locGps = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        this.locPass = lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        LocationListener ll = this.main;

        // LocationRequest lr;
//        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
        lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, ll);
        //        lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, ll);


        double latitude;
        double longitude;


        TextView text = (TextView) main.findViewById(R.id.textView);
        TextView text2 = (TextView) main.findViewById(R.id.textView2);
        try {
            latitude = this.locGps.getLatitude();
            longitude = this.locGps.getLongitude();
        } catch (Exception E) {
        }
        try {
            latitude = locNet.getLatitude();
            longitude = locNet.getLongitude();
        } catch (Exception E) {
        }
        try {
            latitude = locPass.getLatitude();
            longitude = locPass.getLongitude();
        } catch (Exception E) {
        }


    }
    public String removeAMandPm(String time)
    {
        return time.substring(0,time.length()-2);
    }
    public void getCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.main.startActivityForResult(intent, 1);
    }

    @Override
    public void onLocationChanged(Location location) {
        this.locPass = location;
        this.locNet = location;
        this.locPass = location;
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

    public Location getNetLocation() {
        return this.locNet;
    }

    public Location getGPSLocation() {
        return this.locGps;
    }

    public Location getPassLocations() {
        return this.locPass;
    }

}
