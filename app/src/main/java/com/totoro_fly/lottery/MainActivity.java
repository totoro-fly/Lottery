package com.totoro_fly.lottery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.random_button)
    Button randomButton;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.red_text_view)
    TextView redTextView;
    @Bind(R.id.blue_text_view)
    TextView blueTextView;
    TreeSet treeSet;
    String redBallString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.random_button)
    public void onClick() {
        redBall();
        display(redBallString, blueBall());
        redBallString = "";
        treeSet.clear();
    }

    private void redBall() {
        treeSet = new TreeSet();
        for (int i = 0; i < 6; i++) {
            treeSet.add(randomNumber(33));
        }
        if (treeSet.size() == 6) {
            iteratorRadball();
            return;
        } else {
            for (; ; ) {
                treeSet.add(randomNumber(33));
                if (treeSet.size() == 6) {
                    break;
                }
            }
        }
        iteratorRadball();
    }

    private void iteratorRadball() {
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            redBallString = redBallString + " " + String.format("%02d", iterator.next());
        }
    }

    private String blueBall() {
        return String.format("%02d", randomNumber(16));
    }

    private int randomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number) + 1;
    }

    private void display(String red, String blue) {
        redTextView.setText(red);
        blueTextView.setText(blue);
    }
}
