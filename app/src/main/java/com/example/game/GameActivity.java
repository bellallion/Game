package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.databinding.ActivityGameBinding;

import java.io.Serializable;

public class GameActivity extends AppCompatActivity {

    Story story = new Story();
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameBinding binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Bundle arguments = getIntent().getExtras();

        if(arguments!=null) {
            story.current_situation = (Situation) arguments.getSerializable(Situation.class.getSimpleName());
        }
        handler = new Handler(Looper.getMainLooper()) {
            // Looper – запускает цикл обработки сообщений
            // getMainLooper – цикл в главном потоке обработки (UI)
            @Override
            public void handleMessage(@NonNull Message msg){
                super.handleMessage(msg);
                char[] chars = (char[]) msg.obj;
                String str = String.valueOf(chars);
                binding.TEXT.setText(str);
            }
        };
        MyThread myThreads = new MyThread(story.current_situation.text, handler);
        myThreads.start();

//        текст на кнопках
        binding.BT1.setText(story.current_situation.var1);
        binding.BT2.setText(story.current_situation.var2);
        binding.BT3.setText(story.current_situation.var3);

//        характеристика студента

        binding.dR.setText(String.valueOf(story.current_situation.student.R));
        binding.dH.setText(String.valueOf(story.current_situation.student.H));
        binding.dM.setText(String.valueOf(story.current_situation.student.M));

        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                демонстрация изменения характеристик
                String strdR = binding.dR.getText().toString();
                binding.dR.setText(strdR + "+" + String.valueOf(story.current_situation.dR[0]));
                String strdH = binding.dH.getText().toString();
                binding.dH.setText(strdH + "+" + String.valueOf(story.current_situation.dH[0]));
                String strdM = binding.dM.getText().toString();
                binding.dM.setText(strdM + "+" + String.valueOf(story.current_situation.dM[0]));

                story.current_situation.student.R += story.current_situation.dR[0];
                story.current_situation.student.H += story.current_situation.dH[0];
                story.current_situation.student.M += story.current_situation.dM[0];
//              Передача сложных объектов через Intent
                Intent intent;
                if(story.current_situation.direction.length > 0) {
                    Situation next_situation = story.current_situation.direction[0];
                    intent = new Intent(GameActivity.this, GameActivity.class);
//                    Situation.class.getSimpleName() по сути возвращает название класса
                    intent.putExtra(Situation.class.getSimpleName(), next_situation);
                }
                else intent = new Intent(GameActivity.this, EndActivity.class);
                startActivity(intent);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                демонстрация изменения характеристик
                String strdR = binding.dR.getText().toString();
                binding.dR.setText(strdR + "+" + String.valueOf(story.current_situation.dR[1]));
                String strdH = binding.dH.getText().toString();
                binding.dH.setText(strdH + "+" + String.valueOf(story.current_situation.dH[1]));
                String strdM = binding.dM.getText().toString();
                binding.dM.setText(strdM + "+" + String.valueOf(story.current_situation.dM[1]));

                story.current_situation.student.R += story.current_situation.dR[1];
                story.current_situation.student.H += story.current_situation.dH[1];
                story.current_situation.student.M += story.current_situation.dM[1];
//              Передача сложных объектов через Intent
                Intent intent;
                if(story.current_situation.direction.length > 0) {
                    Situation next_situation = story.current_situation.direction[1];
                    intent = new Intent(GameActivity.this, GameActivity.class);
                    intent.putExtra(Situation.class.getSimpleName(), next_situation);
                }
                else intent = new Intent(GameActivity.this, EndActivity.class);
                startActivity(intent);
            }
        });
        binding.BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                демонстрация изменения характеристик
                String strdR = binding.dR.getText().toString();
                binding.dR.setText(strdR + "+" + String.valueOf(story.current_situation.dR[2]));
                String strdH = binding.dH.getText().toString();
                binding.dH.setText(strdH + "+" + String.valueOf(story.current_situation.dH[2]));
                String strdM = binding.dM.getText().toString();
                binding.dM.setText(strdM + "+" + String.valueOf(story.current_situation.dM[2]));

                story.current_situation.student.R += story.current_situation.dR[2];
                story.current_situation.student.H += story.current_situation.dH[2];
                story.current_situation.student.M += story.current_situation.dM[2];

//                Передача сложных объектов через Intent
                Intent intent;
                if(story.current_situation.direction.length > 0) {
                    Situation next_situation = story.current_situation.direction[2];
                    intent = new Intent(GameActivity.this, GameActivity.class);
                    intent.putExtra(Situation.class.getSimpleName(), next_situation);
                }
                else intent = new Intent(GameActivity.this, EndActivity.class);
                startActivity(intent);
//                new Thread(()->{ // -> отделяет параметры от реализации
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }).run();
            }
        });

    }
}
