package com.group11.novec;

import java.util.Locale;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;


public class Fruits extends Activity{
	   TextToSpeech ttobj;
	   private EditText write;
	   String wordsToSpeak = "";
	   public static final String KEY_PARAM_UTTERANCE_ID = "utteranceid";
	   protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_fruits2);
	        
	        write = (EditText)findViewById(R.id.speak_text);
	        ImageButton strawberry = (ImageButton)findViewById(R.id.imageButton1);
	        strawberry.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					wordsToSpeak += "Strawberry ";
					write.setText(wordsToSpeak);
				}
			});
	        
	        ImageButton grapes = (ImageButton)findViewById(R.id.imageButton2);
	        grapes.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					wordsToSpeak += "Grapes ";
					write.setText(wordsToSpeak);
				}
			});
	        ttobj=new TextToSpeech(getApplicationContext(), 
	        new TextToSpeech.OnInitListener() {
	        @Override
	        public void onInit(int status) {
	           if(status != TextToSpeech.ERROR){
	               ttobj.setLanguage(Locale.US);
	              }				
	           }
	        });
	        
	        Button speak = (Button)findViewById(R.id.speak_button);
			  speak.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						String toSpeak = write.getText().toString();
				        Toast.makeText(getApplicationContext(), toSpeak, 
				        Toast.LENGTH_SHORT).show();
				        ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
					}
				});
	     }
	     @Override
	     public void onPause(){
	        if(ttobj !=null){
	           ttobj.stop();
	           ttobj.shutdown();
	        }
	        super.onPause();
	     }
	     /*
	     @Override
	     public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	     }
	     */
	  public void speakText(View view){
	        String toSpeak = write.getText().toString();
	        Toast.makeText(getApplicationContext(), toSpeak, 
	        Toast.LENGTH_SHORT).show();
	        ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

	     }
	  
	     public void onUtteranceCompleted() 
	     {
	         Toast.makeText(this, "onUtteranceCompleted", Toast.LENGTH_SHORT).show();
	     }
	  }