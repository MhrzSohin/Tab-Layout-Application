package edu.udemylearning.tablayoutwithviewpage;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private FragmentAdapter myAdapter;
    private ViewPager2 myViewPager;
    private TabLayout myTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewPager = findViewById(R.id.myViewPage);
        myTab = findViewById(R.id.tablayout);
        myAdapter = new FragmentAdapter(
                getSupportFragmentManager(), getLifecycle()
        );
        myAdapter.addFragment(new fragment1());
        myAdapter.addFragment(new fragment2());
        myAdapter.addFragment(new fragment3());
        myViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager.setAdapter(myAdapter);
        new TabLayoutMediator(
                myTab, myViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0){
                    tab.setText("Game Images");
                }if (position == 1) {
                    tab.setText(("Movie Images"));
                }if (position == 2){
                    tab.setText("G.O.A.T");
                }


            }
        }
        ).attach();
    }
}