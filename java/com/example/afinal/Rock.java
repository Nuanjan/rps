package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.util.*;

import java.util.Random;


public class Rock extends AppCompatActivity implements View.OnClickListener {
private AnimationDrawable thumbAni;
private long startTimes;
Runnable runnable;
int imgID;
Thread thread;
int img;
int userInput;
int index=0;
Handler handler;
private int currentIndex;
Button btn_rock,btn_paper,btn_scissor,btn_easy,btn_medium,btn_hard;
ImageView imgUser,imgCom;



int[] imgsUser = new int[]{

        R.drawable.rock,
        R.drawable.paper,
        R.drawable.scissor,
        R.drawable.rock_com,
        R.drawable.paper_com,
        R.drawable.scissor_com

};
int[] imgsCom = new int[]{
            R.drawable.rock_com,
            R.drawable.paper_com,
            R.drawable.scissor_com,
          //  R.drawable.rock_com2,
         //   R.drawable.paper_com1png,
        //    R.drawable.scissor_com3
    };



int comInput =0;
   // private Thread task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock);

        int[] imgsCom = new int[3];
        imgsCom[0] = R.drawable.rock_com;
        imgsCom[1] = R.drawable.paper_com;
        imgsCom[2]= R.drawable.scissor_com;

        btn_rock = (Button) findViewById(R.id.button6);
        btn_paper=(Button) findViewById(R.id.button7);
        btn_scissor=(Button)findViewById(R.id.button8);
        btn_easy = (Button)findViewById(R.id.button5);
        btn_medium =(Button)findViewById(R.id.button4);
        btn_hard = (Button)findViewById(R.id.button3);

        imgUser = (ImageView) findViewById(R.id.imageView2);
        imgCom = (ImageView)findViewById(R.id.imageView);

        btn_rock.setOnClickListener(this);
        btn_paper.setOnClickListener(this);
        btn_scissor.setOnClickListener(this);
        btn_easy.setOnClickListener(this);
        btn_medium.setOnClickListener(this);
        btn_hard.setOnClickListener(this);

        handler = new Handler();
    }


   public void onClick(View v){



        int id2 = v.getId();

            switch (id2) {
                case R.id.button5:
                   animate();
                   comInput=1;
                 //   handler.removeCallbacksAndMessages(null);
                    break;
                case R.id.button4:
                    animate();
                comInput=2;

                   // handler.removeCallbacksAndMessages(null);
                    break;
                case R.id.button3:
                   animate();
                   comInput=3;

                //    handler.removeCallbacksAndMessages(null);
                    break;
                    case R.id.button6:
                        userInput = 1;
                        imgUser.setImageResource(R.drawable.rock);
                        if(comInput==1) {
                            setEasy();
                        }else if(comInput==2){
                            setMedium();
                    }else if(comInput==3) {
                            setHard();
                        }
                        handler.removeCallbacksAndMessages(null);

                        break;
                    case R.id.button7:
                        userInput = 2;
                        imgUser.setImageResource(R.drawable.paper);
                        if(comInput==1) {
                            setEasy();
                        }else if(comInput==2){
                            setMedium();
                        }else if(comInput==3) {
                            setHard();
                        }
                        handler.removeCallbacksAndMessages(null);
                        break;
                    case R.id.button8:
                        userInput = 3;
                        imgUser.setImageResource(R.drawable.scissor);
                        if(comInput==1){
                            setEasy();
                        }else if(comInput==2){
                            setMedium();
                        }else if(comInput==3) {
                            setHard();
                        }
                        handler.removeCallbacksAndMessages(null);

                        break;

                }

            }






    private void setEasy(){
//handler.removeCallbacksAndMessages(null);
        for(int i=0;i<imgsCom.length;i++) {
            if (userInput == 1 &&i==imgsCom[1]) {
                //imgUser.setImageResource(R.drawable.rock);//User Rock,Computer choose scissor
                index = i;

                imgCom.setImageResource(imgsCom[index]);

            } else if (userInput == 2 && i ==imgsCom[0]) { //User choose paper,Computer rock
            //    imgUser.setImageResource(R.drawable.paper);

                index=i;
                imgCom.setImageResource(imgsCom[index]);

            } else if (userInput == 3&&i==imgsCom[2] ) { //User choose scissor,Computer paper
             //   imgUser.setImageResource(R.drawable.scissor);

                index = i;
                imgCom.setImageResource(imgsCom[index]);
            }


        }

    }

    private void setMedium() {
        //   handler.removeCallbacksAndMessages(null);
        for (int i = 0; i < imgsCom.length; i++) {
            if (userInput == 1 && i==imgsCom[0]) {     //User Rock,Computer choose rock
                index = i;
                imgCom.setImageResource(imgsCom[index]);
            } else if (userInput == 2 && i == imgsCom[1]) { //User choose paper,Computer  paper
                index = i;

                imgCom.setImageResource(imgsCom[index]);
            } else if (userInput == 3 && i==imgsCom[2]) { //User choose scissor,Computer scissor
                index = i;

                imgCom.setImageResource(imgsCom[index]);
            }
        }
    }


    private void setHard() {

            for (int i = 0; i < imgsCom.length; i++) {
                if (userInput == 1 && i==imgsCom[1]) {     //User Rock,Computer choose paper
                    index = i;
                    imgCom.setImageResource(imgsCom[index]);
                } else if (userInput == 2 && i==imgsCom[2]) { //User choose paper,Computer  scissor
                    index = i;
                    imgCom.setImageResource(imgsCom[index]);

                } else if (userInput == 3 && i==imgsCom[0]) { //User choose scissor,Computer rock
                    index = i;
                    imgCom.setImageResource(imgsCom[index]);

                }
            }
        }

//    private void showresult(int result) {
//        if (result == 0) {
//            Toast.makeText(getApplicationContext(), "Oh! You Lost :(", Toast.LENGTH_SHORT).show();
//        } else if (result == 1)
//            Toast.makeText(getApplicationContext(), "You Won! Yeah! :)", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(getApplicationContext(), "OOPS! It's a Tie! :P", Toast.LENGTH_SHORT).show();
//    }

    public void animate(){
        final int imgsAnimate[]={R.drawable.rock_com,
                R.drawable.paper_com,
                R.drawable.scissor_com,
                R.drawable.rock_com2,
                R.drawable.paper_com1png,
                 R.drawable.scissor_com3};

         runnable = new Runnable() {
            int i =0;
            @Override
            public void run() {
                imgCom.setImageResource(imgsAnimate[i]);
                i++;
                if(i > imgsAnimate.length-1){
                    i=0;
                }
                handler.postDelayed(this,300);
            }
        };
        handler.postDelayed(runnable,300);

    }

}
