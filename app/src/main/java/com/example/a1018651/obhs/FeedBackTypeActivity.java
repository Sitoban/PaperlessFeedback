package com.example.a1018651.obhs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a1018651.obhs.beans.FeedbackBean;

import java.util.ArrayList;
import java.util.Arrays;


public class FeedBackTypeActivity extends AppCompatActivity {

    ListView feedBackTypeList ;
    FeedbackBean feedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_type);

        //invoking feedback singleton object
         feedBack = FeedbackBean.getInstance();

        //populating the listview
        // Get ListView object from xml
        feedBackTypeList = (ListView) findViewById(R.id.feedBackTypeList);
        String[] feedBackTypeValues = new String[] { "A/C Coach Passenger",
                "A/C Coach T.T.E",
                "Non A/C Coach Passenger",
                "Non A/C Coach T.T.E"
        };
        ArrayList<String> feedBackTypeArray = new ArrayList<String>();
        feedBackTypeArray.addAll( Arrays.asList(feedBackTypeValues) );
        // Create ArrayAdapter using the planet list.
        ArrayAdapter<String> feedBackTypeListAdapter = new ArrayAdapter<String>(this, R.layout.feed_back_type_item, feedBackTypeArray);
        feedBackTypeList.setAdapter(feedBackTypeListAdapter);

        feedBackTypeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Context context = view.getContext();
                Intent intent = new Intent(context, FeedbackFormActivity.class);
//                intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                context.startActivity(intent);

            }

        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        TextView feedBackCountTextView = (TextView)findViewById(R.id.feedBackCountText);
        feedBackCountTextView.setText(feedBack.getFeedBackCount());
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
