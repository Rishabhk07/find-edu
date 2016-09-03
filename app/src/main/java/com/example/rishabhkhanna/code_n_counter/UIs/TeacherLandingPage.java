package com.example.rishabhkhanna.code_n_counter.UIs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.rishabhkhanna.code_n_counter.R;

public class TeacherLandingPage extends AppCompatActivity {

    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_landing_page);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Create new Eve" , R.drawable.ic_account_circle_grey_700_18dp , R.color.colorPrimaryDark);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("users" , R.drawable.ic_account_circle_grey_700_18dp , R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Topics" ,R.drawable.ic_account_circle_grey_700_18dp, R.color.colorAccent);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("find" ,R.drawable.ic_account_circle_grey_700_18dp, R.color.colorBottomNavigationNotification);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
    }
}
