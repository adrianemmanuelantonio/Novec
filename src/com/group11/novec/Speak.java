package com.group11.novec;

import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.app.Activity;

public class Speak extends Activity implements TextToSpeech.OnInitListener{
	 TextToSpeech ttobj;
	 public static final String KEY_PARAM_UTTERANCE_ID = "utteranceid";
	 /*public Speak() {
	        Log.d("Una", "Una");
	        ttobj=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
     		@Override    
     		public void onInit(int status) {
			           if(status != TextToSpeech.ERROR){
			               ttobj.setLanguage(Locale.US);
			               Log.d("Error", "Mas Pumasok sa loob");
			              }				
			           }
			        });
			 
	 }*/
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 Log.d("Error","Makita kung pmasok nga ba");
		 ttobj=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
     		@Override    
     		public void onInit(int status) {
			           if(status != TextToSpeech.ERROR){
			               ttobj.setLanguage(Locale.US);
			               Log.d("Error", "Mas Pumasok sa loob");
			              }				
			           }
			        });
	 }
	 
	 public void Speaking(String words){
		 
		 Log.d("Error", "Pag speak");
		 //Toast.makeText(getApplicationContext(), words, Toast.LENGTH_SHORT).show();
		 ttobj.speak(words, TextToSpeech.QUEUE_FLUSH, null);
	 }
	 @Override
	   public void onPause(){
	      if(ttobj !=null){
	         ttobj.stop();
	         ttobj.shutdown();
	      }
	      super.onPause();
	   }
	 public void onUtteranceCompleted() 
     {
         //Toast.makeText(this, "onUtteranceCompleted", Toast.LENGTH_SHORT).show();
     }
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}

	
	
}
