package com.example.vaccinationschedule.PopUps;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.example.vaccinationschedule.R;

public class pop extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchpopup);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));
    }

}
