package com.example.rishabhkhanna.code_n_counter.UIs;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.rishabhkhanna.code_n_counter.Fragments.TeacherFragments.Create_new_event;
import com.example.rishabhkhanna.code_n_counter.R;

public class TeacherLandingPage extends AppCompatActivity {

    AHBottomNavigation bottomNavigation;
    FrameLayout teacherFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_landing_page);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigationTeacher);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Create new Eve" , R.drawable.ic_account_circle_grey_700_18dp , R.color.colorPrimaryDark);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("users" , R.drawable.ic_account_circle_grey_700_18dp , R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Topics" ,R.drawable.ic_account_circle_grey_700_18dp, R.color.colorAccent);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("find" ,R.drawable.ic_account_circle_grey_700_18dp, R.color.colorBottomNavigationNotification);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

                teacherFrame = (FrameLayout) findViewById(R.id.TeacherLandingFrame);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Create_new_event new_event =  new Create_new_event();

        fragmentTransaction.replace(R.id.TeacherLandingFrame , new_event, null);
        fragmentTransaction.commit();

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                switch (position){
                    case 0:

                      Create_new_event new_event =  new Create_new_event();
                      fragmentTransaction.replace(R.id.TeacherLandingFrame , new_event, null);
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;


                }

                return true;
            }
        });






    }
}
