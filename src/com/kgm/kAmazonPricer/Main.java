package com.kgm.kAmazonPricer;

import com.kgm.kLibAmazon.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by goga on 7/3/14.
 */
public class Main extends Activity {
	kViewBase base = null;

	public Main() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Button btn = null;

		super.onCreate(savedInstanceState);

		setContentView(R.layout.lstart);

		btn = (Button) findViewById(R.id.btn_lstart_start);

		if (btn != null) {
			btn.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Button btn = null;

					setContentView(R.layout.lay_menu);

					btn = (Button) findViewById(R.id.btn_lmenu_add_new);

					if (btn != null) {
						btn.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								setContentView(R.layout.lay_new_product);

								Button btn = (Button) findViewById(R.id.btn_lnew_amazon);

								if (btn != null) {
									btn.setOnClickListener(new OnClickListener() {
										public void onClick(View v) {
											setContentView(R.layout.lay_add_bid);

											Button btn = (Button) findViewById(R.id.btn_lnew_amazon);

											if (btn != null) {
												btn.setOnClickListener(new OnClickListener() {
													public void onClick(View v) {
														TextView tv = (TextView) findViewById(R.id.tv_bid_warning);

														System.out.println("Clearing text view");

														if (tv != null) {
															tv.setText("");
														}

														EditText et = (EditText) findViewById(R.id.editLabBidOrLink);

														String url = et.getText().toString();

														System.out.println("Checking url: " + url);
														
														kASINReader asin = new kASINReader(url);
														
														System.out.println("Checking url page asin: " + asin.getASIN());														
														
														if (url.length() < 1 || !kUrlCheck.isValid(url)) {
															if (tv != null) {
																tv.setText("Not valid url!");
															}
														}
													}
												});
											}
										}
									});
								}
							}
						});
					}

					btn = (Button) findViewById(R.id.btn_lmenu_show_products);

					if (btn != null) {
						btn.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								setContentView(R.layout.lay_products);
							}
						});
					}
				}
			});
		}
	}
}
