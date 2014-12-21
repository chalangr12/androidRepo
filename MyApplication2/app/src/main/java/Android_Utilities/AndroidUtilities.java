package Android_Utilities;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.chalang.myapplication.MainActivity;
import com.example.chalang.myapplication.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chalang on 12/19/2014.
 */
public class AndroidUtilities {
    MainActivity main;
    Location loc;

public AndroidUtilities(MainActivity main)
{
    this.main = main;
    initializeLocation();
}


    public double getLatitude()
    {
        return loc.getLatitude();
    }

    public double getLongitude()
    {
        return loc.getLongitude();
    }

    public Date getTimeAndDate()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


    public void initializeLocation()
    {
        LocationManager lm = (LocationManager)main.getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }
}
