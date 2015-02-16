package com.group11.novec;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
//import android.widget.Toast;
import android.speech.tts.TextToSpeech;

public class Categories extends Activity{
	 TextToSpeech ttobj;
	 EditText write;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_category);
	        
	     ttobj=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
	    	 @Override
	    	 public void onInit(int status) {
	    		 if(status != TextToSpeech.ERROR){
	    			 ttobj.setLanguage(Locale.US);
	    	     }				
	    	 }
	     });
	     write = (EditText)findViewById(R.id.speak_text);
	     ImageButton speak = (ImageButton)findViewById(R.id.speak_button);
	     ImageButton clear = (ImageButton)findViewById(R.id.clear_button);
	     ImageButton btnFruits = (ImageButton)findViewById(R.id.imageButton1);
	     ImageButton btnGadgets = (ImageButton)findViewById(R.id.imageButton2);
	     ImageButton btnToys = (ImageButton)findViewById(R.id.imageButton3); 
	     ImageButton btnVehicles = (ImageButton)findViewById(R.id.imageButton4);
	     
	     speak.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					String toSpeak = write.getText().toString();
			        //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
			        ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
				}
			});
	     clear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v){
					//Toast.makeText(getApplicationContext(), "Textbox Cleared", Toast.LENGTH_SHORT).show();
					write.setText("");
				}
			});
	     btnFruits.setOnClickListener(new View.OnClickListener() {
			 public void onClick(View v) {
				 //Toast.makeText(Categories.this, "Fruits", Toast.LENGTH_LONG).show();
				 Intent i = new Intent(Categories.this, CategoryItems.class);
				 i.putExtra("category", "Fruits");
	             startActivity(i);
			 }
		 });
	     btnGadgets.setOnClickListener(new View.OnClickListener() {
			 public void onClick(View v) {
			 	// Toast.makeText(Categories.this, "Gadgets", Toast.LENGTH_LONG).show();
			 	 Intent i = new Intent(Categories.this, CategoryItems.class);
				 i.putExtra("category", "Gadgets");
	             startActivity(i);
			 }
		 });
	     btnToys.setOnClickListener(new View.OnClickListener() {
			 public void onClick(View v) {
				 //Toast.makeText(Categories.this, "Toys", Toast.LENGTH_LONG).show();
				 Intent i = new Intent(Categories.this, CategoryItems.class);
				 i.putExtra("category", "Toys");
	             startActivity(i);
			 }
		 });
	     btnVehicles.setOnClickListener(new View.OnClickListener() {
	    	 public void onClick(View v) {
				 //Toast.makeText(Categories.this, "Vehicles", Toast.LENGTH_LONG).show();
				 Intent i = new Intent(Categories.this, CategoryItems.class);
				 i.putExtra("category", "Vehicles");
	             startActivity(i);
			 }
		 });
	 }
}
