package perimeter.test.com.peri2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


public class MyActivity extends Activity implements Animation.AnimationListener{
    int i;
    ImageView im;
    Animation animBlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        final int idList[]={R.id.imageView1,R.id.imageView,R.id.imageView23,R.id.imageView38,
                R.id.imageView12,R.id.imageView26,R.id.imageView49,R.id.imageView7,R.id.imageView16,
                R.id.imageView31,R.id.imageView18,R.id.imageView42,R.id.imageView35,R.id.imageView5,R.id.imageView20,
                R.id.imageView40,R.id.imageView36,R.id.imageView17,R.id.imageView22,R.id.imageView2,R.id.imageView50,
                R.id.imageView29,R.id.imageView19,R.id.imageView43,R.id.imageView4,R.id.imageView8,R.id.imageView11,
                R.id.imageView47,R.id.imageView37,R.id.imageView10,R.id.imageView33,R.id.imageView14,R.id.imageView48,
                R.id.imageView45,R.id.imageView24,R.id.imageView39,R.id.imageView9,R.id.imageView13,R.id.imageView46,
                R.id.imageView32,R.id.imageView21,R.id.imageView15,R.id.imageView34,R.id.imageView44,
                R.id.imageView25,R.id.imageView41,R.id.imageView33,R.id.imageView28,R.id.imageView3,R.id.imageView27,
                R.id.imageView6,R.id.imageView30,R.id.imageView50};

//        for(i=2;i<50; i++)
//        {
//
//            im = (ImageView)findViewById(idList[i]);
//            im.setVisibility(View.VISIBLE);
//            final Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    // Do something after 5s = 5000ms
//                    im.setVisibility(View.INVISIBLE);
//                }
//            }, 3000);
//        }
            for (i=2;i<4;i++)
            {
                im = (ImageView)findViewById(idList[i]);
                im.setVisibility(View.VISIBLE);
                animBlink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                animBlink.setAnimationListener(this);
                im.startAnimation(animBlink);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                @Override
                    public void run() {
                    // Do something after 5s = 5000ms
                        im.clearAnimation();
                    }
                }, 4000);
        //im.clearAnimation();
                im.setVisibility(View.INVISIBLE);
            }
        return true;
    }
    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fade in animation
        if (animation == animBlink) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

