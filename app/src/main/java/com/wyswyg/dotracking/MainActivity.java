package com.wyswyg.dotracking;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.wyswyg.dotracking.navigationBar.courierFragment;
import com.wyswyg.dotracking.navigationBar.homeFragment;
import com.wyswyg.dotracking.navigationBar.reportFragment;
import com.wyswyg.dotracking.navigationBar.syncFragment;
import com.wyswyg.dotracking.navigationBar.transactionFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new homeFragment());
        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }



    // method listener untuk logika pemilihan
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.courier:
                fragment = new courierFragment();
                break;
            case R.id.home:
                fragment = new homeFragment();
                break;
            case R.id.report:
                fragment = new reportFragment();
                break;
            case R.id.syncronize:
                fragment = new syncFragment();
                break;
            case R.id.transaction:
                fragment = new transactionFragment();
                break;
        }
        return loadFragment(fragment);
    }
    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
