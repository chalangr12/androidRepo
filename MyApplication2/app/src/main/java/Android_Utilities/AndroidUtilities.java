package Android_Utilities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.MediaStore;
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
    Location location;

public AndroidUtilities(MainActivity main)
{
    this.main = main;
    initializeLocation();
}


    public double getLatitude()
    {
        return location.getLatitude();
    }

    public double getLongitude()
    {
        return location.getLongitude();
    }

    public Date getTimeAndDate()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public void initializeLocation()
    {
        LocationManager lm = (LocationManager)main.getSystemService(Context.LOCATION_SERVICE);
        this.location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    public void getCamera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.main.startActivityForResult(intent, 1);
    }

}
