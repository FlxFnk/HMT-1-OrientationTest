package de.kutschertec.orientationtest;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("OrientationTest", "onCreate: Orientation changed");

        int deviceRotation = getWindowManager().getDefaultDisplay().getRotation();
        TextView t = findViewById(R.id.orientation);
        t.setText(Integer.toString(deviceRotation) + "   " + new Date());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int deviceRotation = getWindowManager().getDefaultDisplay().getRotation();
        TextView t = findViewById(R.id.orientation);
        t.setText(Integer.toString(deviceRotation) + "   " + new Date());

        Log.i("OrientationTest", "onConfigurationChanged: Orientation changed");

        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
