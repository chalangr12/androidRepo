package View;

import android.location.Location;
import android.widget.TextView;

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



    public View(MainActivity activity,AndroidUtilities utils)
    {
        this.mainActivity = activity;
        this.loc = loc;
        this.utils = utils;
    }




    public void setTimes(Location loc)
    {

        TextView view =  (TextView) mainActivity.findViewById(R.id.textView);
        TextView view2 = (TextView) mainActivity.findViewById(R.id.textView2);
        TextView view3 = (TextView) mainActivity.findViewById(R.id.textView3);


        TextView view4= (TextView) mainActivity.findViewById(R.id.textView4);
        TextView view5= (TextView) mainActivity.findViewById(R.id.textView5);
        TextView view6= (TextView) mainActivity.findViewById(R.id.textView6);
        TextView view7= (TextView) mainActivity.findViewById(R.id.textView7);
        TextView view8= (TextView) mainActivity.findViewById(R.id.textView8);
        TextView view9= (TextView) mainActivity.findViewById(R.id.textView9);
        TextView view10= (TextView) mainActivity.findViewById(R.id.textView10);

        view3.setText("GPS METHOD: " + loc.getProvider());
        view.setText("Latitude: " + loc.getLatitude());
        view2.setText("Longitude: " + loc.getLongitude());
        PrayerTime times = new PrayerTime();

        ArrayList<String> listTimes = times.getTimes(loc.getLatitude(),loc.getLongitude(), 7);

        view4.setText("Fajr " +utils.removeAMandPm(listTimes.get(0))+"am");
        view5.setText("Sunrise " +utils.removeAMandPm(listTimes.get(1))+"am");
        view6.setText("Duhr " +utils.removeAMandPm(listTimes.get(2))+"pm");
        view7.setText("Asr " +utils.removeAMandPm(listTimes.get(3))+"pm");
        view8.setText("Sunset " +utils.removeAMandPm(listTimes.get(4))+"pm");
        view9.setText("Maghrib  " +utils.removeAMandPm(listTimes.get(5))+"pm");
        view10.setText("Eisha " +utils.removeAMandPm(listTimes.get(6))+"pm");
    }
}
