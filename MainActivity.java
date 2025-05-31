package com.example.splashss;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabLayout);

        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,new FirstFragment() );//conteinerViewId মানে host এর id ,fragment (যেটাকে Transaction করাবো )
        fragmentTransaction.commit();

        //tab select unselect controler
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int tabPosition = tab.getPosition();
                String tabText=tab.getText().toString();
                Toast.makeText(MainActivity.this,tabText,Toast.LENGTH_SHORT).show();

                if(tabPosition==0){
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new FirstFragment() );//conteinerViewId মানে host এর id ,fragment (যেটাকে Transaction করাবো )
                    fragmentTransaction.commit();
                } else if (tabPosition==1) {
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new SecondFragment() );//conteinerViewId মানে host এর id ,fragment (যেটাকে Transaction করাবো )
                    fragmentTransaction.commit();
                } else if (tabPosition==2) {
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new FirstFragment() );//conteinerViewId মানে host এর id ,fragment (যেটাকে Transaction করাবো )
                    fragmentTransaction.commit();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        /*

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fManager.beginTransaction();
                fragmentTransaction.add(R.id.frameLayout,new SecondFragment() );//conteinerViewId মানে host এর id ,fragment (যেটাকে Transaction করাবো )
                fragmentTransaction.commit();

            }
        });

        */




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
