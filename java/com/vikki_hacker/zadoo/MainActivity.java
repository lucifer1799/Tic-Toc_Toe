package com.vikki_hacker.zadoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 1;
    ImageView count;
    int active=0;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    boolean gameisactive = true;
    boolean gameOver = false;

    public void result(View view)
    {
        int res = 0;
        count = (ImageView)view;
        int tapcounter = Integer.parseInt(count.getTag().toString());
        int[][]winposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        if( gameState[tapcounter]==2 && gameisactive) {
            gameState[tapcounter]=active;
            if (active == 0) {
                counter++;
                count.setTranslationY(-1000f);
                active = 1;
                count.setImageResource(R.drawable.red);
                count.animate().translationYBy(1000f).rotation(360).setDuration(300);
            } else {
                counter++;
                count.setTranslationY(1000f);
                active = 0;
                count.setImageResource(R.drawable.yellow);
                count.animate().translationYBy(-1000f).rotation(360).setDuration(300);
            }

            for( int[] position : winposition )
            {
                if((gameState[position[0]] == gameState[position[1]]) &&
                        (gameState[position[1]] == gameState[position[2]])&&
                        (gameState[position[0]]!= 2))
                {
                    res = 1;
                    gameisactive= false;

                    String win="Yellow";

                    if(gameState[position[0]]==0)
                    {
                        win="Red";
                    }
                    TextView message = (TextView)findViewById(R.id.winner);
                    message.setText(win+" "+"Has Won!");
                    LinearLayout layout = (LinearLayout)findViewById(R.id.playagainlayout);
                    layout.setVisibility(View.VISIBLE);
                    counter = 1;
                }

            }
            if( counter%10==0 && res == 0 )
            {
                TextView message = (TextView)findViewById(R.id.winner);
                message.setText("It's a Draw!");
                LinearLayout layout = (LinearLayout)findViewById(R.id.playagainlayout);
                layout.setVisibility(View.VISIBLE);
                counter = 1;
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button obj = (Button)findViewById(R.id.playagainbutton);
        obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = (LinearLayout)findViewById(R.id.playagainlayout);
                layout.setVisibility(View.INVISIBLE);
                active=0;
                gameisactive = true;
                for(int i=0; i<9; i++)
                {
                    gameState[i]=2;
                }
                ImageView one =(ImageView)findViewById(R.id.img1);
                ImageView two =(ImageView)findViewById(R.id.img2);
                ImageView three =(ImageView)findViewById(R.id.img3);
                ImageView four =(ImageView)findViewById(R.id.img4);
                ImageView five =(ImageView)findViewById(R.id.img5);
                ImageView six =(ImageView)findViewById(R.id.img6);
                ImageView seven =(ImageView)findViewById(R.id.img7);
                ImageView eight =(ImageView)findViewById(R.id.img8);
                ImageView nine =(ImageView)findViewById(R.id.img9);
                one.setImageResource(R.drawable.white);
                two.setImageResource(R.drawable.white);
                three.setImageResource(R.drawable.white);
                four.setImageResource(R.drawable.white);
                five.setImageResource(R.drawable.white);
                six.setImageResource(R.drawable.white);
                seven.setImageResource(R.drawable.white);
                eight.setImageResource(R.drawable.white);
                nine.setImageResource(R.drawable.white);

            }
        });
    }
}
