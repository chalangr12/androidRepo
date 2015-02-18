package View;

import android.hardware.SensorEvent;
import android.location.Location;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

import com.example.chalang.testapplication.MainActivity;
import com.example.chalang.testapplication.R;

import java.util.ArrayList;

import Utilities.AndroidUtilities;
import Utilities.PrayerTime;

/**
 * Created by Chalang on 12/23/2014.
 */
public class View {
    private MainActivity mainActivity;
    private Location loc;
    private AndroidUtilities utils;
    private float currentDegree = 0f;


    public View(MainActivity activity, AndroidUtilities utils) {
        this.mainActivity = activity;
        this.loc = loc;
        this.utils = utils;
    }

    public void hideNotificationBar() {
        mainActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    public void setTimes(Location loc) {

        TextView view = (TextView) mainActivity.findViewById(R.id.textView);
        TextView view2 = (TextView) mainActivity.findViewById(R.id.textView2);
        TextView view3 = (TextView) mainActivity.findViewById(R.id.textView3);


//        TextView view4= (TextView) mainActivity.findViewById(R.id.textView4);
//        TextView view5= (TextView) mainActivity.findViewById(R.id.textView5);
//        TextView view6= (TextView) mainActivity.findViewById(R.id.textView6);
//        TextView view7= (TextView) mainActivity.findViewById(R.id.textView7);
//        TextView view8= (TextView) mainActivity.findViewById(R.id.textView8);
//        TextView view9= (TextView) mainActivity.findViewById(R.id.textView9);
//        TextView view10= (TextView) mainActivity.findViewById(R.id.textView10);

//        view3.setText("GPS METHOD: " + loc.getProvider());
//        view.setText("Latitude: " + loc.getLatitude());
//        view2.setText("Longitude: " + loc.getLongitude());
        PrayerTime times = new PrayerTime();

        ArrayList<String> listTimes = times.getTimes(loc.getLatitude(), loc.getLongitude(), 7);

//        view4.setText("Fajr " +utils.removeAMandPm(listTimes.get(0))+"am");
//        view5.setText("Sunrise " +utils.removeAMandPm(listTimes.get(1))+"am");
//        view6.setText("Duhr " +utils.removeAMandPm(listTimes.get(2))+"pm");
//        view7.setText("Asr " +utils.removeAMandPm(listTimes.get(3))+"pm");
//        view8.setText("Sunset " +utils.removeAMandPm(listTimes.get(4))+"pm");
//        view9.setText("Maghrib  " +utils.removeAMandPm(listTimes.get(5))+"pm");
//        view10.setText("Eisha " +utils.removeAMandPm(listTimes.get(6))+"pm");
//        view10.setAlpha((float)25.000);
    }

    public void setImageButtons() {
        ImageButton fajr = (ImageButton) mainActivity.findViewById(R.id.fajrImageButton);


    }

    public void changeCompass(SensorEvent event){

        float degree = Math.round(event.values[0]);
        TextView tvHeading = (TextView)this.mainActivity.findViewById(R.id.tvHeading);
        ImageView image = (ImageView)this.mainActivity.findViewById(R.id.imageViewCompass);

        tvHeading.setText("Heading: " + Float.toString(degree) + " degrees");

        // create a rotation animation (reverse turn degree degrees)
        RotateAnimation ra = new RotateAnimation(currentDegree,-degree, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        // how long the animation will take place
        ra.setDuration(210);

        // set the animation after the end of the reservation status
        ra.setFillAfter(true);

        // Start the animation
        image.startAnimation(ra);
        currentDegree = -degree;
    }
    public void setToPrayerTimes()
    {
        this.mainActivity.setContentView(R.layout.compass);

    }
    public void setToCompass()
    {
        this.mainActivity.setContentView(R.layout.prayertimes);
    }
}
