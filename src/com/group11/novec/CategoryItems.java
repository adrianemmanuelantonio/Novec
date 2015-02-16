package com.group11.novec;

import java.util.Locale;

import android.app.Activity;
//import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
//import android.widget.Toast;
import java.util.*;

public class CategoryItems extends Activity{
	TextToSpeech ttobj;
	private static EditText write;
	ImageButton categoryItem1;
	ImageButton categoryItem2;
	String categoryItemName1;
	String categoryItemName2;
	String wordsToSpeak = "";
	static List<String> items = new ArrayList<String>();
	static String itemArray[] = {};
	Stack<String> st = new Stack<String>();
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_subitems);
		
		Bundle categoryFromClick=getIntent().getExtras();
		String categoryName = categoryFromClick.getString("category");
		write = (EditText)findViewById(R.id.speak_text);
		
		//Instatiate texttospeech object
		ttobj=new TextToSpeech(getApplicationContext(), 
		        new TextToSpeech.OnInitListener() {
		        @Override
		        public void onInit(int status) {
		           if(status != TextToSpeech.ERROR){
		               ttobj.setLanguage(Locale.US);
		              }				
		           }
		        });
		categoryItem1 = (ImageButton)findViewById(R.id.imageButton1);
		categoryItem2 = (ImageButton)findViewById(R.id.imageButton2);
		if(categoryName.equalsIgnoreCase("Fruits")){
			categoryItem1.setImageResource(R.drawable.strawberry);
			categoryItem1.setTag("Strawberry");
			
			categoryItem2.setImageResource(R.drawable.grapes);
			categoryItem2.setTag("Grapes");
		}
		else if(categoryName.equalsIgnoreCase("Gadgets")){
			categoryItem1.setImageResource(R.drawable.phone);
			categoryItem1.setTag("Mobile Phone");
			
			categoryItem2.setImageResource(R.drawable.musicplayer);
			categoryItem2.setTag("Music Player");
		}
		else if(categoryName.equalsIgnoreCase("Toys")){
			categoryItem1.setImageResource(R.drawable.teddybear);
			categoryItem1.setTag("Teddy Bear");
			
			categoryItem2.setImageResource(R.drawable.doll);
			categoryItem2.setTag("Doll");
		}
		else if(categoryName.equalsIgnoreCase("Vehicles")){
			categoryItem1.setImageResource(R.drawable.car);
			categoryItem1.setTag("Car");
			
			categoryItem2.setImageResource(R.drawable.airplane);
			categoryItem2.setTag("Airplane");
		}
		
		//Creating events when pictures are clicked
		categoryItem1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//categoryItemName1 = categoryItem1.getTag().toString();
				//items.add(categoryItem1.getTag().toString() + " ");
				//wordsToSpeak += categoryItemName1 + " ";
				//itemArray = (String[]) items.toArray();
				String temp = categoryItem1.getTag().toString() + " ";
				pushItem(st, temp);
				//wordsToSpeak = itemValue(itemArray);
				//write.setText(wordsToSpeak);
			}
		});
		categoryItem2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				//categoryItemName2 = categoryItem2.getTag().toString();
				//wordsToSpeak += categoryItemName2 + " ";
				//items.add(categoryItem2.getTag().toString() + " ");
				//itemArray = (String[]) items.toArray();
				//wordsToSpeak = itemValue(itemArray);
				//write.setText(wordsToSpeak);
				String temp = categoryItem2.getTag().toString() + " ";
				pushItem(st, temp);
			}
		});
		
		//Declarations of Buttons speak and clear
		ImageButton speak = (ImageButton)findViewById(R.id.speak_button);
		//speak.setBackgroundColor(Color.GREEN);
		//speak.setHeight(42);
		//speak.setWidth(80);
		//speak.setTextColor(Color.parseColor("#ec3c1d"));
		speak.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String toSpeak = write.getText().toString();
			    //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
			    ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
			}
		});
		ImageButton clear = (ImageButton)findViewById(R.id.clear_button);
		//clear.setBackgroundColor(Color.RED);
		//clear.setHeight(42);
		//clear.setTextColor(Color.parseColor("#FFFFFF"));
		clear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
			    //Toast.makeText(getApplicationContext(), st.peek() + " Removed", Toast.LENGTH_SHORT).show();
				//wordsToSpeak = "";
				//write.setText("");
				popItem(st);
			}
		});
	}
	public String itemValue(String items[]){
		String concatString = "";
		for(int i=0; i<items.length;i++){
			concatString += items[i] + " ";
		}
		return concatString;
	}
	static void pushItem(Stack<String> stack, String newItem) {
	      stack.push(new String(newItem));
	      String textValue = "";
	      
	      for(int i=0; i< stack.size();i++){
	    	  textValue += stack.elementAt(i);
	      }
	      write.setText(textValue);
	   }

	   static void popItem(Stack<String> stack) {
	      //Integer a = (Integer) st.pop();
	     // System.out.println(a);
	      //System.out.println("stack: " + st);
		   if(stack.isEmpty()){
			   //Nothing to do if empty
		   }
		   else{
			   stack.pop();
			   String textValue = "";
			      
			      for(int i=0; i< stack.size();i++){
			    	  textValue += stack.elementAt(i);
			      }

			      write.setText(textValue);
		   }
		   
	   }
	static void setEidtText(Stack<String> stack){
		String textValue = stack.peek();
		write.setText(textValue);
		
	}
}
	   
