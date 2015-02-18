package Controller;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Utilities.AndroidUtilities;
import com.example.chalang.testapplication.MainActivity;
import com.example.chalang.testapplication.R;
import View.View;
import com.example.chalang.testapplication.SimpleGestureFilter;
import com.example.chalang.testapplication.SimpleGestureFilter.SimpleGestureListener;

/**
 * Created by Chalang on 12/23/2014.
 */
public class Controller extends ActionBarActivity implements LocationListener, SimpleGestureListener, SensorEventListener {


    private SimpleGestureFilter detector;
    private SensorManager mSensorManager;
    private float currentDegree = 0f;
    private AndroidUtilities utils;
    private MainActivity mainActivity;
//    private Activity activity;
    private View view;
    private Location loc;



    public Controller(MainActivity activity)
    {
        mainActivity = activity;
        this.utils = new AndroidUtilities(activity);
        view = new View(activity,utils);
        view.hideNotificationBar();
        detector = new SimpleGestureFilter(this.mainActivity,this);
        getLocation();
        setupCompass();


    }

    private void setupCompass() {
        mSensorManager = (SensorManager) mainActivity.getSystemService(SENSOR_SERVICE);
    }

    private void getLocation() {

        Location loc;
        if (utils.getGPSLocation() != null)
            loc = utils.getGPSLocation();
        else if (utils.getNetLocation() != null)
            loc = utils.getNetLocation();
        else
            loc = utils.getPassLocations();
        view.setTimes(loc);
    }


    @Override
    public void onDoubleTap() {
//          Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {

    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this.mainActivity, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

//

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }
    @Override
    public void onSwipe(int direction) {
        String str = "";
        switch (direction) {
            case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
                view.setToCompass();
                break;
            case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
                view.setToPrayerTimes();
                break;
        }
        //Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // to stop the listener and save battery
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

       view.changeCompass(event);
    }
}
