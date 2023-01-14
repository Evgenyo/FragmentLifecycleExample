package ru.synergy.fragmentlifecycleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.synergy.fragmentlifecycleexample.fragments.FirstFragment;
import ru.synergy.fragmentlifecycleexample.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    Button fragmentButton, fragmentButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentButton = (Button) findViewById(R.id.buttonFragment);
        fragmentButton2 = (Button) findViewById(R.id.buttonFragment2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();


        FirstFragment firstFragment = FirstFragment.newInstance("1", "2");
        fragmentTransaction.add(R.id.container, firstFragment);
        fragmentTransaction.commit();


        fragmentButton.setOnClickListener(onButtonClickListner);
        fragmentButton2.setOnClickListener(onButtonClickListner);

    }

    View.OnClickListener onButtonClickListner = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Fragment newFragment = null;

            if(v == fragmentButton){
                newFragment = new FirstFragment();
            }else {
                newFragment = new SecondFragment();
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();

        }
    };

}