package com.example.davidllorca.sunshine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /** API KEY ac7cd7f409df802354e9b65f38ed351a */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceHolderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;

        public PlaceHolderFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // dummy data
            String [] forecastArray = {
                    "Today - sunny",
                    "Tomorrow - foggy",
                    "Wed - sunny",
                    "Thur - sunny",
                    "Fri - sunny",
                    "Sat - sunny",
                    "Sun - Cloudy"
            };

            ArrayList<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

            ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<String>(
                    // Context of fragment
                    getActivity(),
                    // ID list layout
                    R.layout.list_item_forecast,
                    // ID item list
                    R.id.list_item_forecast_textview,
                    // Data
                    weekForecast);

            // Get a reference to the ListView, and attach adapter
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }

}
