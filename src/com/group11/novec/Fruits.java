package com.group11.novec;

import java.util.Locale;

import com.group11.novec.adapter.TabsPagerAdapter;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;


public class Fruits extends FragmentActivity implements ActionBar.TabListener {

	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Page 1", "Page 2", "Page 3" };
    static EditText write;
    TextToSpeech ttobj;
    ImageButton strawberry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fruits);
 
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        ImageButton speak = (ImageButton)findViewById(R.id.speak_button);
	    
	    //ImageButton sample = (ImageButton)findViewById(R.id.);
	    
	    
	    write = (EditText)findViewById(R.id.speak_text);
	    speak.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String toSpeak = write.getText().toString();
		        //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
		        ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
			}
		});
	    ttobj=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
	    	 @Override
	    	 public void onInit(int status) {
	    		 if(status != TextToSpeech.ERROR){
	    			 ttobj.setLanguage(Locale.US);
	    	     }				
	    	 }
	     });
        
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        	 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }
}