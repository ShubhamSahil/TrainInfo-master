package com.sundroid.traininfo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sundroid.traininfo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    ActionBarDrawerToggle drawerToggle;
    @BindView(R.id.nvView)
    NavigationView nvDrawer;
    @BindView(R.id.flContent)
    FrameLayout flContent;
    @BindView(R.id.gridview_menu)
    GridView gridview_menu;


    List<Integer> list_item_images=new ArrayList<>();
    List<String> list_item_text=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setUpLeftNavigationDrawer();

        setUpGridContent();
    }
    public void setUpGridContent(){
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);
        list_item_images.add(R.drawable.ic_launcher);

        list_item_text.add("Live Train Status");
        list_item_text.add("PNR status");
        list_item_text.add("Train Route");
        list_item_text.add("Seat Availability");
        list_item_text.add("Train Between Station");
        list_item_text.add("Train Name/Number");
        list_item_text.add("Train Fair Enquiry");
        list_item_text.add("Train Arrival at station");
        list_item_text.add("Cancelled Train");
        list_item_text.add("Station Name To Code");
        list_item_text.add("Station Code To Name");
        list_item_text.add("Station AutoComplete");
        list_item_text.add("Train AutoComplete");

        GridAdapter adapter = new GridAdapter(this, list_item_images, list_item_text);

        gridview_menu.setAdapter(adapter);
        gridview_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(HomeActivity.this, "You Clicked at "+position , Toast.LENGTH_SHORT).show();
                GridItemClick(position);
            }
        });
    }
    public void GridItemClick(int position){
        switch (position){
            case 0:
                startActivity(new Intent(HomeActivity.this,LiveTrainStatusActivity.class));
                break;
            case 1:
                startActivity(new Intent(HomeActivity.this,PNRStatusActivity.class));
                break;
            case 2:
                startActivity(new Intent(HomeActivity.this,TrainRouteActivity.class));
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;

        }
    }


    public void setUpLeftNavigationDrawer() {
        setupDrawerContent(nvDrawer);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        nvDrawer.setItemIconTintList(null);
        setFirstItemNavigationView();
//        drawerToggle.setDrawerIndicatorEnabled(false);
        setUpLeftHeaderLayout();
    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }
    public void setUpLeftHeaderLayout(){
        View headerLayout = nvDrawer.inflateHeaderView(R.layout.inflate_home_left_header);

        CircleImageView ic_left_profile= (CircleImageView) headerLayout.findViewById(R.id.ic_left_profile);
        TextView tv_profile_name= (TextView) headerLayout.findViewById(R.id.tv_profile_name);

    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
    private void setFirstItemNavigationView() {
        nvDrawer.setCheckedItem(R.id.menu_home);
        nvDrawer.getMenu().performIdentifierAction(R.id.menu_home, 0);
    }
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                break;
            case R.id.menu_about:
                break;
            case R.id.menu_help:
                break;
            case R.id.menu_settings:
                break;
            default:
        }

        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawer.openDrawer(nvDrawer);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    class GridAdapter extends BaseAdapter{

        Activity activity;
        List<Integer> list_images;
        List<String> list_item_string;
        public GridAdapter(Activity context, List<Integer> list_images,List<String> list_item_text) {
            this.activity = context;
            this.list_images=list_images;
            this.list_item_string=list_item_text;
        }

        @Override
        public int getCount() {
            return list_images.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View grid;
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {

                grid = new View(activity);
                grid = inflater.inflate(R.layout.inflate_home_grid_items, null);
                TextView textView = (TextView) grid.findViewById(R.id.grid_text);
                ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
                textView.setText(list_item_string.get(i));
                imageView.setImageResource(list_images.get(i));
            } else {
                grid = (View) convertView;
            }

            return grid;
        }
    }

}
