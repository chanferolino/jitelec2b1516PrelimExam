package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ToggleButton mBtnToggle;
    RadioGroup rg1;
    RadioButton mInc,mDec;
    SeekBar seekbar;
    TextView mtxtTime,mtxtMeasure;
    private Handler mHandler = new Handler();
    private int startTime,time=0;
    private int delay=0;
    String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mBtnToggle = (ToggleButton)findViewById(R.id.toggleButton);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        mInc = (RadioButton) findViewById(R.id.radBtnInc);
        mDec = (RadioButton)findViewById(R.id.radBtnDec);
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        mtxtTime = (TextView)findViewById(R.id.txtTime);
        mtxtMeasure = (TextView)findViewById(R.id.txtMeasure);
        x = (String) mtxtTime.getText();
        startTime =Integer.parseInt(x);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                delay = Integer.parseInt((String) mtxtMeasure.getText());

            }

        });


            mBtnToggle.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub
             mBtnToggle.toggle();
             if(mBtnToggle.isChecked()){
                 mHandler.postDelayed(mUpdateTimeTask,delay);
              mUpdateTimeTask.run();
             }
             else{
                 mHandler.removeCallbacks(mUpdateTimeTask);
             }

             }



    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            if (mInc.isChecked()) {
                time++;
                mtxtTime.setText(time);
            } else if (mDec.isChecked()) {
                time--;
                mtxtTime.setText(time);
            }

        }
    };});




    }
    }



