package com.maugry.tabs_with_header;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPlaceContactFragment = new PlaceContactFragment();
        mPlaceDiscountsFragment = new PlaceDiscountFragment();
        mPlaceNewsFragment = new PlaceNewsFragment();
        adapter.addFragment(mPlaceContactFragment, "Контакты");
        adapter.addFragment(mPlaceDiscountsFragment, "Акции");
        adapter.addFragment(mPlaceNewsFragment, "Новости");

        mFragments = new ScrollProcessor[3];
        mFragments[0] = mPlaceContactFragment;
        mFragments[1] = mPlaceDiscountsFragment;
        mFragments[2] = mPlaceNewsFragment;

        viewPager.setAdapter(adapter);

        for(int i=2; i>=0; i--)
            mViewPager.setCurrentItem(i);



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
