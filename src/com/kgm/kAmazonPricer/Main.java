package com.kgm.kAmazonPricer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * Created by goga on 7/3/14.
 */
public class Main extends Activity 
{
    kViewBase base = null;

    public Main()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        Button btn = null;
        
        super.onCreate(savedInstanceState);

        //base = new kViewBase(this);
        //setContentView(base);
        
        setContentView(R.layout.lstart);
        
        btn = (Button) findViewById(R.id.btn_lstart_start);
        
        if(btn != null)
        {
            btn.setOnClickListener(new OnClickListener()
            {
                public void onClick(View v)
                {
                    Button btn = null;
                    
                    setContentView(R.layout.lay_menu);
                    
                    btn = (Button) findViewById(R.id.btn_lmenu_add_new);

                    if(btn != null)
                    {
                        btn.setOnClickListener(new OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                setContentView(R.layout.lay_new_product);
                            }
                        });
                    }

                    btn = (Button) findViewById(R.id.btn_lmenu_show_products);

                    if(btn != null)
                    {
                        btn.setOnClickListener(new OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                setContentView(R.layout.lay_products);
                            }
                        });
                    }
                }
            });
        }        
    }
}
