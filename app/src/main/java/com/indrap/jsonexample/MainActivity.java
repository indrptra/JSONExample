package com.indrap.jsonexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView tv_name = (TextView)findViewById(R.id.tv_name_nine);
        TextView tv_city = (TextView)findViewById(R.id.tv_city_nine);
        TextView tv_province = (TextView)findViewById(R.id.tv_province_nine);

        //create new JSON object
        //this code for declare object

        JSONObject student_json = new JSONObject();
        JSONObject address_json = new JSONObject();
        try {
            student_json.put("name", "Indra Putra");
            address_json.put("city", "Bandung");
            address_json.put("province", "West Java");
            student_json.put("address", address_json);
            //this for handle set value to text view
            tv_name.setText("Name : "+ student_json.getString("name"));
            JSONObject jo_address = (JSONObject) student_json.get("address");
            tv_city.setText("City : "+ jo_address.getString("city"));
            tv_province.setText("Province : "+ jo_address.getString("province"));
        }catch (JSONException e){
            Log.i("info", String.valueOf(e));
        }
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
}
