package com.kgm.kAmazonPricer;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by goga on 7/3/14.
 */
public class Main extends Activity {
    kViewBase base = null;

    public Main()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        base = new kViewBase(this);

        setContentView(base);
    }
}
