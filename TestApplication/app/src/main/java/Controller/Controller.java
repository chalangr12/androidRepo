package Controller;

import android.location.Location;
import android.widget.TextView;

import Utilities.AndroidUtilities;
import com.example.chalang.testapplication.MainActivity;
import com.example.chalang.testapplication.R;
import View.View;
/**
 * Created by Chalang on 12/23/2014.
 */
public class Controller {

    private MainActivity mainActivity;
    private AndroidUtilities utils;
    private View view;
    public Controller(MainActivity activity)
    {
        mainActivity = activity;
        this.utils = new AndroidUtilities(activity);
        view = new View(activity,utils);
        getLocation();
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


}
