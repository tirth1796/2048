package com.tirthcshahgmail.trc2048;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class GameScreen extends Activity {
    LinearLayout l3,l4,l6,l8;
    Spinner selectGrid;
    ArrayAdapter<CharSequence> adapter;
    private static int presentView=8;
    static Matrix m4 = new Matrix(4);
    static Matrix m3=new Matrix(3);
    static Matrix m6=new Matrix(6);
    static Matrix m8=new Matrix(8);
    private boolean o3=false,o4=false,o6=false,o8=false;
    private static int score3=0,score4=0,score6=0,score8=0;
    private static int highScore3=0,highScore4=0,highScore6=0,highScore8=0;
    Button restart;
    TextView[] t4=new TextView[16];
    TextView[] t3=new TextView[9];
    TextView[] t6=new TextView[36];
    TextView[] t8=new TextView[64];
    TextView  tvScore, tvBest,go3,go4,go6,go8;
    private float x1, x2, y1, y2;
    static final int MIN_DISTANCE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        l3=(LinearLayout)findViewById(R.id.t3);
        l4=(LinearLayout)findViewById(R.id.t4);
        l6=(LinearLayout)findViewById(R.id.t6);
        l8=(LinearLayout)findViewById(R.id.t8);
        restart = (Button) findViewById(R.id.restart);t4[0]= (TextView) findViewById(R.id.t41);
        selectGrid=(Spinner)findViewById(R.id.spinner);
        setSpinAdapter();
        setT4();
        setT3();
        setT6();
        setT8();
        tvScore = (TextView) findViewById(R.id.score);
        tvBest = (TextView) findViewById(R.id.highScore);
        go3=(TextView)findViewById(R.id.go3);
        go4=(TextView)findViewById(R.id.go4);
        go6=(TextView)findViewById(R.id.go6);
        go8=(TextView)findViewById(R.id.go8);
        setData();
        switch (presentView){
            case 3:{
                selectGrid.setSelection(0);
                break;
            }
            case 4:{
                selectGrid.setSelection(1);
                break;
            }
            case 6:{
                selectGrid.setSelection(2);
                break;
            }
            case 8:{
                selectGrid.setSelection(3);
                break;
            }
        }
        display();
    }

    private void setSpinAdapter() {
        adapter=ArrayAdapter.createFromResource(this,R.array.options,R.layout.spin_text);
        selectGrid.setAdapter(adapter);
        selectGrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        l3.setVisibility(View.VISIBLE);
                        l4.setVisibility(View.GONE);
                        l6.setVisibility(View.GONE);
                        l8.setVisibility(View.GONE);
                        presentView=3;
                        break;
                    case 1:
                        l4.setVisibility(View.VISIBLE);
                        l3.setVisibility(View.GONE);
                        l6.setVisibility(View.GONE);
                        l8.setVisibility(View.GONE);
                        presentView=4;
                        break;
                    case 2:
                        l6.setVisibility(View.VISIBLE);
                        l4.setVisibility(View.GONE);
                        l3.setVisibility(View.GONE);
                        l8.setVisibility(View.GONE);
                        presentView=6;
                        break;
                    case 3:
                        l8.setVisibility(View.VISIBLE);
                        l4.setVisibility(View.GONE);
                        l6.setVisibility(View.GONE);
                        l3.setVisibility(View.GONE);
                        presentView=8;
                        break;
                    case 4:
                        break;
                }
                display();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void setT4(){
        t4[1]= (TextView) findViewById(R.id.t42);
        t4[2]= (TextView) findViewById(R.id.t43);
        t4[3]= (TextView) findViewById(R.id.t44);
        t4[4]= (TextView) findViewById(R.id.t45);
        t4[5]= (TextView) findViewById(R.id.t46);
        t4[6]= (TextView) findViewById(R.id.t47);
        t4[7]= (TextView) findViewById(R.id.t48);
        t4[8]= (TextView) findViewById(R.id.t49);
        t4[9]= (TextView) findViewById(R.id.t410);
        t4[10]= (TextView) findViewById(R.id.t411);
        t4[11]= (TextView) findViewById(R.id.t412);
        t4[12]= (TextView) findViewById(R.id.t413);
        t4[13]= (TextView) findViewById(R.id.t414);
        t4[14]= (TextView) findViewById(R.id.t415);
        t4[15]= (TextView) findViewById(R.id.t416);

    }
    public void setT3(){
        t3[0]= (TextView) findViewById(R.id.t31);
        t3[1]= (TextView) findViewById(R.id.t32);
        t3[2]= (TextView) findViewById(R.id.t33);
        t3[3]= (TextView) findViewById(R.id.t34);
        t3[4]= (TextView) findViewById(R.id.t35);
        t3[5]= (TextView) findViewById(R.id.t36);
        t3[6]= (TextView) findViewById(R.id.t37);
        t3[7]= (TextView) findViewById(R.id.t38);
        t3[8]= (TextView) findViewById(R.id.t39);
    }
    public void setT6(){
        t6[0]= (TextView) findViewById(R.id.t61);
        t6[1]= (TextView) findViewById(R.id.t62);
        t6[2]= (TextView) findViewById(R.id.t63);
        t6[3]= (TextView) findViewById(R.id.t64);
        t6[4]= (TextView) findViewById(R.id.t65);
        t6[5]= (TextView) findViewById(R.id.t66);
        t6[6]= (TextView) findViewById(R.id.t67);
        t6[7]= (TextView) findViewById(R.id.t68);
        t6[8]= (TextView) findViewById(R.id.t69);
        t6[9]= (TextView) findViewById(R.id.t610);
        t6[10]= (TextView) findViewById(R.id.t611);
        t6[11]= (TextView) findViewById(R.id.t612);
        t6[12]= (TextView) findViewById(R.id.t613);
        t6[13]= (TextView) findViewById(R.id.t614);
        t6[14]= (TextView) findViewById(R.id.t615);
        t6[15]= (TextView) findViewById(R.id.t616);
        t6[16]= (TextView) findViewById(R.id.t617);
        t6[17]= (TextView) findViewById(R.id.t618);
        t6[18]= (TextView) findViewById(R.id.t619);
        t6[19]= (TextView) findViewById(R.id.t620);
        t6[20]= (TextView) findViewById(R.id.t621);
        t6[21]= (TextView) findViewById(R.id.t622);
        t6[22]= (TextView) findViewById(R.id.t623);
        t6[23]= (TextView) findViewById(R.id.t624);
        t6[24]= (TextView) findViewById(R.id.t625);
        t6[25]= (TextView) findViewById(R.id.t626);
        t6[26]= (TextView) findViewById(R.id.t627);
        t6[27]= (TextView) findViewById(R.id.t628);
        t6[28]= (TextView) findViewById(R.id.t629);
        t6[29]= (TextView) findViewById(R.id.t630);
        t6[30]= (TextView) findViewById(R.id.t631);
        t6[31]= (TextView) findViewById(R.id.t632);
        t6[32]= (TextView) findViewById(R.id.t633);
        t6[33]= (TextView) findViewById(R.id.t634);
        t6[34]= (TextView) findViewById(R.id.t635);
        t6[35]= (TextView) findViewById(R.id.t636);
    }
    public void setT8(){
        t8[0]= (TextView) findViewById(R.id.t81);
        t8[1]= (TextView) findViewById(R.id.t82);
        t8[2]= (TextView) findViewById(R.id.t83);
        t8[3]= (TextView) findViewById(R.id.t84);
        t8[4]= (TextView) findViewById(R.id.t85);
        t8[5]= (TextView) findViewById(R.id.t86);
        t8[6]= (TextView) findViewById(R.id.t87);
        t8[7]= (TextView) findViewById(R.id.t88);
        t8[8]= (TextView) findViewById(R.id.t89);
        t8[9]= (TextView) findViewById(R.id.t810);
        t8[10]= (TextView) findViewById(R.id.t811);
        t8[11]= (TextView) findViewById(R.id.t812);
        t8[12]= (TextView) findViewById(R.id.t813);
        t8[13]= (TextView) findViewById(R.id.t814);
        t8[14]= (TextView) findViewById(R.id.t815);
        t8[15]= (TextView) findViewById(R.id.t816);
        t8[16]= (TextView) findViewById(R.id.t817);
        t8[17]= (TextView) findViewById(R.id.t818);
        t8[18]= (TextView) findViewById(R.id.t819);
        t8[19]= (TextView) findViewById(R.id.t820);
        t8[20]= (TextView) findViewById(R.id.t821);
        t8[21]= (TextView) findViewById(R.id.t822);
        t8[22]= (TextView) findViewById(R.id.t823);
        t8[23]= (TextView) findViewById(R.id.t824);
        t8[24]= (TextView) findViewById(R.id.t825);
        t8[25]= (TextView) findViewById(R.id.t826);
        t8[26]= (TextView) findViewById(R.id.t827);
        t8[27]= (TextView) findViewById(R.id.t828);
        t8[28]= (TextView) findViewById(R.id.t829);
        t8[29]= (TextView) findViewById(R.id.t830);
        t8[30]= (TextView) findViewById(R.id.t831);
        t8[31]= (TextView) findViewById(R.id.t832);
        t8[32]= (TextView) findViewById(R.id.t833);
        t8[33]= (TextView) findViewById(R.id.t834);
        t8[34]= (TextView) findViewById(R.id.t835);
        t8[35]= (TextView) findViewById(R.id.t836);
        t8[36]= (TextView) findViewById(R.id.t837);
        t8[37]= (TextView) findViewById(R.id.t838);
        t8[38]= (TextView) findViewById(R.id.t839);
        t8[39]= (TextView) findViewById(R.id.t840);
        t8[40]= (TextView) findViewById(R.id.t841);
        t8[41]= (TextView) findViewById(R.id.t842);
        t8[42]= (TextView) findViewById(R.id.t843);
        t8[43]= (TextView) findViewById(R.id.t844);
        t8[44]= (TextView) findViewById(R.id.t845);
        t8[45]= (TextView) findViewById(R.id.t846);
        t8[46]= (TextView) findViewById(R.id.t847);
        t8[47]= (TextView) findViewById(R.id.t848);
        t8[48]= (TextView) findViewById(R.id.t849);
        t8[49]= (TextView) findViewById(R.id.t850);
        t8[50]= (TextView) findViewById(R.id.t851);
        t8[51]= (TextView) findViewById(R.id.t852);
        t8[52]= (TextView) findViewById(R.id.t853);
        t8[53]= (TextView) findViewById(R.id.t854);
        t8[54]= (TextView) findViewById(R.id.t855);
        t8[55]= (TextView) findViewById(R.id.t856);
        t8[56]= (TextView) findViewById(R.id.t857);
        t8[57]= (TextView) findViewById(R.id.t858);
        t8[58]= (TextView) findViewById(R.id.t859);
        t8[59]= (TextView) findViewById(R.id.t860);
        t8[60]= (TextView) findViewById(R.id.t861);
        t8[61]= (TextView) findViewById(R.id.t862);
        t8[62]= (TextView) findViewById(R.id.t863);
        t8[63]= (TextView) findViewById(R.id.t864);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("event", "event");

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                Log.d("down", "down" + x1 + " " + y1);
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                Log.d("up", "up" + x2 + " " + y2);
                float deltaX = x2 - x1;
                float deltaY = y2 - y1;

                Log.d("length", deltaX + " " + deltaY);

                if (Math.abs(deltaX) > MIN_DISTANCE && Math.abs(deltaX) > Math.abs(deltaY)) {
                    // Right
                    if (x2 > x1) {
                        Log.d("right", "right");
                        switch(presentView){
                            case 3:
                                m3.right();
                                break;

                            case 4:
                                m4.right();
                                break;
                            case 6:
                                m6.right();
                                break;
                            case 8:
                                m8.right();
                                break;

                        }
                        display();
                    }

                    // Left
                    else {
                        switch(presentView) {
                            case 3:
                                m3.left();
                                break;

                            case 4:
                                m4.left();
                                break;
                            case 6:
                                m6.left();
                                break;
                            case 8:
                                m8.left();
                                break;

                        }
                        display();
                    }

                } else if (Math.abs(deltaY) > MIN_DISTANCE && Math.abs(deltaX) < Math.abs(deltaY)) {
                    //Down
                    if (y2 > y1) {
                        switch(presentView){
                            case 3:
                                m3.down();
                                break;

                            case 4:
                                m4.down();
                                break;
                            case 6:
                                m6.down();
                                break;
                            case 8:
                                m8.down();
                                break;

                        }
                        display();
                    }

                    // Up
                    else {
                        switch(presentView){
                            case 3:
                                m3.up();
                                break;
                            case 4:
                                m4.up();
                                break;
                            case 6:
                                m6.up();
                                break;
                            case 8:
                                m8.up();
                                break;

                        }
                        display();
                    }

                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void restart(View v) {
        switch(presentView){
            case 3:
                m3.gameOver=false;
                go3.setVisibility(View.GONE);
                m3=new Matrix(3);
                break;
            case 4:
                m4.gameOver=false;
                go4.setVisibility(View.GONE);
                m4=new Matrix(4);
                break;
            case 6:
                m6.gameOver=false;
                go6.setVisibility(View.GONE);
                m6=new Matrix(6);
                break;
            case 8:
                m8.gameOver=false;
                go8.setVisibility(View.GONE);
                m8=new Matrix(8);
                break;

        }
        score3 = 0;
        score4 = 0;
        score6 = 0;
        score8 = 0;
        display();
    }

    public void display() {
        int[][] g;
        Log.d("present View display", presentView + "");
        switch (presentView){
            case 3:
                if(!m3.gameOver) {
                    score3 = m3.getScore();
                    tvScore.setText("SCORE\n" + score3);

                    if (score3 > highScore3) {
                        highScore3 = score3;
                    }
                    tvBest.setText("BEST\n" + highScore3);
                    g = m3.getGrid();
                    for (int i = 0; i < 9; i++) {
                        setDisplay(t3[i], g[i / 3][i % 3]);
                    }
                }else{
                    go3.setVisibility(View.VISIBLE);
                }
                break;
            case 4:
                if(!m4.gameOver) {
                    score4 = m4.getScore();
                    tvScore.setText("SCORE\n" + score4);

                    if (score4 > highScore4) {
                        highScore4 = score4;
                    }
                    tvBest.setText("BEST\n" + highScore4);
                    g = m4.getGrid();
                    for (int i = 0; i < 16; i++) {
                        setDisplay(t4[i], g[i / 4][i % 4]);
                    }
                }else{
                    go4.setVisibility(View.VISIBLE);
                }
                break;
            case 6:
                if(!m6.gameOver) {
                    score6 = m6.getScore();
                    tvScore.setText("SCORE\n" + score6);

                    if (score6 > highScore6) {
                        highScore6 = score6;
                    }
                    tvBest.setText("BEST\n" + highScore6);
                    g = m6.getGrid();
                    for (int i = 0; i < 36; i++) {
                        setDisplay(t6[i], g[i / 6][i % 6]);
                    }
                }else{
                    go6.setVisibility(View.VISIBLE);
                }
                break;
            case 8:
                if(!m8.gameOver) {
                    score8 = m8.getScore();
                    tvScore.setText("SCORE\n" + score8);

                    if (score8 > highScore8) {
                        highScore8 = score8;
                    }
                    tvBest.setText("BEST\n" + highScore8);
                    g = m8.getGrid();
                    for (int i = 0; i < 64; i++) {
                        setDisplay(t8[i], g[i / 8][i % 8]);
                    }
                }else{
                    go8.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public void setDisplay(TextView v, int n) {
        switch (n) {
            case 0:
                v.setTextColor(Color.parseColor("#FF272727"));
                v.setText("");
                v.setBackgroundResource(R.drawable.rounded_0);
                break;
            case 2:
                v.setTextColor(Color.parseColor("#FF272727"));
                v.setText("2");
                v.setBackgroundResource(R.drawable.round2);
                break;
            case 4:
                v.setTextColor(Color.parseColor("#FF272727"));
                v.setText("4");
                v.setBackgroundResource(R.drawable.round4);
                break;
            case 8:
                v.setText("8");
                v.setBackgroundResource(R.drawable.round8);
                break;
            case 16:
                v.setText("16");
                v.setBackgroundResource(R.drawable.round16);
                break;
            case 32:
                v.setText("32");
                v.setBackgroundResource(R.drawable.round32);
                break;
            case 64:
                v.setText("64");
                v.setBackgroundResource(R.drawable.round64);
                break;
            case 128:
                v.setText("128");
                v.setBackgroundResource(R.drawable.round128);
                break;
            case 256:
                v.setText("256");
                v.setBackgroundResource(R.drawable.round256);
                break;
            case 512:
                v.setText("512");
                v.setBackgroundResource(R.drawable.round512);
                break;
            case 1024:
                v.setText("1024");
                v.setBackgroundResource(R.drawable.round1024);
                break;
            case 2048:
                v.setText("2048");
                v.setBackgroundResource(R.drawable.round2);
                break;
            case 4096:
                v.setText("4096");
                v.setBackgroundResource(R.drawable.round4);
                break;
            case 8192:
                v.setText("8192");
                v.setBackgroundResource(R.drawable.round8);
                break;
            case 16384:
                v.setText("16384");
                v.setBackgroundResource(R.drawable.round16);
                break;
            case 32768:
                v.setText("32768");
                v.setBackgroundResource(R.drawable.round32);
                break;
            case 65536:
                v.setText("65536");
                v.setBackgroundResource(R.drawable.round64);
                break;
            case 131072:
                v.setText("131072");
                v.setBackgroundResource(R.drawable.round128);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        setData();
    }

    public void setData(){
        SharedPreferences file = getSharedPreferences("info", MODE_PRIVATE);
        if (file.getInt("highScore4", 0) != 0) {
            m3.fromString(file.getString("m3d",null));
            m4.fromString(file.getString("m4d",null));
            m6.fromString(file.getString("m6d",null));
            m8.fromString(file.getString("m8d",null));

            highScore3 = file.getInt("highScore3", 0);
            score3 = file.getInt("score3", 0);
            highScore4 = file.getInt("highScore4", 0);
            score4 = file.getInt("score4", 0);
            highScore6 = file.getInt("highScore6", 0);
            score6 = file.getInt("score6", 0);
            highScore8 = file.getInt("highScore8", 0);
            score8 = file.getInt("score8", 0);

            presentView=file.getInt("presentView",0);
            Log.d("present View get data",presentView+"");

            m3.gameOver=file.getBoolean("o3",false);
            m4.gameOver=file.getBoolean("o4",false);
            m6.gameOver=file.getBoolean("o6",false);
            m8.gameOver=file.getBoolean("o8",false);

            m3.setScore(score3);
            Log.d("score get data", score3+ "");
            m4.setScore(score4);
            m6.setScore(score6);
            m8.setScore(score8);
            display();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","putting data");
        SharedPreferences file = getSharedPreferences("info", MODE_PRIVATE);
        SharedPreferences.Editor editor = file.edit();
        o3=m3.gameOver;
        o4=m4.gameOver;
        o6=m6.gameOver;
        o8=m8.gameOver;
        go3.setVisibility(View.GONE);
        go4.setVisibility(View.GONE);
        go6.setVisibility(View.GONE);
        go8.setVisibility(View.GONE);
        editor.putBoolean("o3",o3);
        editor.putBoolean("o4",o4);
        editor.putBoolean("o6",o6);
        editor.putBoolean("o8",o8);
        editor.putInt("highScore3", highScore3);
        editor.putInt("score3", m3.getScore());
        editor.putInt("highScore4", highScore4);
        editor.putInt("score4", m4.getScore());
        editor.putInt("highScore6", highScore6);
        editor.putInt("score6", m6.getScore());
        editor.putInt("highScore8", highScore8);
        editor.putInt("score8", m8.getScore());
        editor.putInt("presentView", presentView);
        String m3d=m3.toString();
        String m4d=m4.toString();
        String m6d=m6.toString();
        String m8d=m8.toString();
        editor.putString("m3d",m3d);
        editor.putString("m4d",m4d);
        editor.putString("m6d",m6d);
        editor.putString("m8d",m8d);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
