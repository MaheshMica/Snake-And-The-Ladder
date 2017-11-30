package com.example.mahesh.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    int myActivePlayer = 0;
    // 0 for cross and1 for cirle

    //My game state

    int[] mygameState = {2,2,2,2,2,2,2,2,2,};



    public void imageTapped(View view){

        ImageView myTapped = (ImageView) view;


        //Log.i("tag is","Image Number is"  + myTapped.getTag().toString());
        int tappedImageTag = Integer.parseInt(myTapped.getTag().toString());

        if(mygameState[tappedImageTag] == 2){
            mygameState[tappedImageTag] = myActivePlayer;

            if(myActivePlayer == 0){

                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;

            } else {
                myTapped.setImageResource(R.drawable.circle);
                myTapped.animate().alpha(500).setDuration(1000);
                myActivePlayer = 0;

            }

        }else{
            Log.i("msg","This place is filled already");
            //REplace with the tost message
        }



    }


    public void playAgain(View view){
        //Log.i("msg","play again Tapped");

        //Change game state to 2

        for(int i=0;i < mygameState.length;i++){

            mygameState[i] = 2;
        }


        //Make active player zero again
        myActivePlayer = 0;

        //change allimages to ic_launcher

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.line1);


        for(int i =0;i<linearLayout.getChildCount();i++){

            ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.drawable.ic_launcher_foreground);
        }

        LinearLayout linearLayoutone = (LinearLayout)findViewById(R.id.line2);
        for(int i =0;i<linearLayoutone.getChildCount();i++){

            ((ImageView)linearLayoutone.getChildAt(i)).setImageResource(R.drawable.ic_launcher_foreground);
        }

        LinearLayout linearLayouttwo = (LinearLayout)findViewById(R.id.line3);
        for(int i =0;i<linearLayouttwo.getChildCount();i++){

            ((ImageView)linearLayouttwo.getChildAt(i)).setImageResource(R.drawable.ic_launcher_foreground);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
