package com.group11.novec;

import java.util.Stack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
 
public class FruitsPage2 extends Fragment {
    static EditText write;
	ImageButton strawberry, grapes, clear;
	Stack<String> st = new Stack<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.activity_main_fruits_page2, container, false);
        
	    write = (EditText) getActivity().findViewById(R.id.speak_text);
        strawberry = (ImageButton)rootView.findViewById(R.id.strawberry);
        strawberry.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				refreshStack(st);
				pushItem(st, strawberry.getTag().toString() + " ");
				int pos = write.getText().length();
				write.setSelection(pos);
			}
		});
        grapes = (ImageButton)rootView.findViewById(R.id.grapes);
        grapes.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				refreshStack(st);
				pushItem(st, grapes.getTag().toString() + " ");
				int pos = write.getText().length();
				write.setSelection(pos);
			}
		});
        clear = (ImageButton) getActivity().findViewById(R.id.clear_button);
        clear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				refreshStack(st);
				popItem(st);
			}
		});
        return rootView;
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
    static void refreshStack(Stack<String> stack){
    	if(write.toString().equals("")){
    		
    	}
    	else{
    		stack.clear();
        	String[] temp = write.getText().toString().split(" ");
        	for(int i=0;i<temp.length;i++){
        		stack.push(temp[i] + " ");
        	}
    	}
    	
    }

	
}