package com.example.swiftmartco.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.swiftmartco.R;
import com.example.swiftmartco.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment = null;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        Drawable background = getResources().getDrawable(R.drawable.gradient_home,getTheme());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent,getTheme()));
        }
        getWindow().setBackgroundDrawable(background);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch(item.getItemId())
            {
                case R.id.home:

                    fragment = new Fragment();
                    switchfragment(fragment);

                    break;
                case R.id.cart:

                    break;
                case R.id.shopping_bag:

                    break;

                case R.id.message:

                    break;

                case R.id.user:

                    fragment = new User();
                    switchfragment(fragment);

                    break;

            }


            return false;
        });

        if (savedInstanceState == null)
        {
            bottomNavigationView.setSelectedItemId(R.id.home); // change to whichever id should be default
        }
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.all_categories:  all_category();   break;
            case R.id.orders:   my_orders();  break;
            case R.id.cart:   cart(); break;
            case R.id.wishlist:     break;
            case R.id.account:     break;
            case R.id.notifications:    break;
            case R.id.privacy_policy:    break;
            case R.id.legal: break;
            case R.id.report: break;
            case R.id.rate: break;
            case R.id.share: break;
            case R.id.logout: break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    void cart()
    {
        Intent intent = new Intent(this,CartActivity.class);
        startActivity(intent);
    }

    void all_category()
    {
        Intent intent = new Intent(this, AllCategoryActivity.class);
        startActivity(intent);
    }

    void my_orders()
    {
        Intent intent = new Intent(this, MyOrdersActivity.class);
        startActivity(intent);
    }

    void switchfragment(Fragment fragment)
    {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.framelayout,fragment).commit();
    }
}