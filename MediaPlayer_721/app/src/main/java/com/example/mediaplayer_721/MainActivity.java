package com.example.mediaplayer_721;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_click,btn_stop,btn_resume;
    private ImageView img_roation;
    private ObjectAnimator animator;  //这里用的是属性动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initview();

        //设置属性动画
        initAnimator();

        //设置点击事件
        initclick();

    }

    private void initclick() {
        btn_resume.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_click.setOnClickListener(this);
    }

    private void initAnimator() {
        //这里离定义图片  旋转  角度  F是因为是浮点数
        animator = ObjectAnimator.ofFloat(img_roation,"rotation",0,360.0F);
        animator.setDuration(10000);  //这里设置动画时长，单位为毫秒，这里设置了10秒转一圈
        animator.setInterpolator(new LinearInterpolator()); //旋转时间函数为线性，以为匀速旋转
        animator.setRepeatCount(-1);   //设置转动圈数  -1 为一直转
    }


    private void initview() {
        btn_click = findViewById(R.id.btn_click);
        img_roation = findViewById(R.id.img_roation);
        btn_stop = findViewById(R.id.btn_stop);
        btn_resume = findViewById(R.id.btn_resume);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_click:
                animator.start();
                break;
            case R.id.btn_stop:
                animator.pause();
                break;
            case R.id.btn_resume:
                animator.resume();
                break;
        }
    }
}