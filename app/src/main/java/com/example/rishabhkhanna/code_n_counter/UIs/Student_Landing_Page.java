package com.example.rishabhkhanna.code_n_counter.UIs;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.rishabhkhanna.code_n_counter.Fragments.TeacherFragments.Create_new_event;
import com.example.rishabhkhanna.code_n_counter.Fragments.TeacherFragments.studentFragment.StudentFragmentEvents;
import com.example.rishabhkhanna.code_n_counter.R;

public class Student_Landing_Page extends AppCompatActivity {


    AHBottomNavigation bottomNavigation;
    FrameLayout  studentFrame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing__page);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Teachers" , R.drawable.ic_account_circle_grey_700_18dp , R.color.colorPrimaryDark);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Users" , R.drawable.ic_account_circle_grey_700_18dp , R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Topics" ,R.drawable.ic_account_circle_grey_700_18dp, R.color.colorAccent);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Find" ,R.drawable.ic_account_circle_grey_700_18dp, R.color.colorBottomNavigationNotification);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.setBackgroundColor(Color.parseColor("#FEFEFE"));


        studentFrame = (FrameLayout) findViewById(R.id.studentLandingPage);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        final StudentFragmentEvents frag = new StudentFragmentEvents();

        fragmentTransaction.replace(R.id.studentLandingPage , frag, null);
        fragmentTransaction.commit();

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                switch (position){
                    case 0:

                        Create_new_event new_event =  new Create_new_event();
                        fragmentTransaction.replace(R.id.studentLandingPage , frag, null);
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
