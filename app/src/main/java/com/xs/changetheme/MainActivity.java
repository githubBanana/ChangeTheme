package com.xs.changetheme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Arrays;
import java.util.List;

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
            themeChange();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 主题选择切换Dialog
     */
    private void themeChange() {
        Integer[] res = new Integer[] {R.drawable.red_shape,R.drawable.pink_shape,R.drawable.brown_shape};
        final List<Integer> mList = Arrays.asList(res);
        ColorListAdapter mAdapter = new ColorListAdapter(MainActivity.this);
        final GridView mGv = (GridView) LayoutInflater.from(MainActivity.this).inflate(R.layout.gridview_layout,null);
        mGv.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        mGv.setNumColumns(3);
        mGv.setCacheColorHint(0);
        mGv.setAdapter(mAdapter);
        mAdapter.addAll(mList);
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        new AlertDialog.Builder(MainActivity.this).setTitle("主题选择")
                .setView(mGv)
                .show();

    }
}
