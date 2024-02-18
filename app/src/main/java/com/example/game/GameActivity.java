package com.example.game;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.databinding.ActivityMainBinding;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        персонаж
        class Charaster {
            private int T;
            private int S;
            private int H;
            public Charaster(){
                T = 18;
                S = 100;
                H = 30;
            }
        }
//    ситуация
        class Situation{
            Situation[] direction;
            String subject, text;
            int dT, dS, dH;
            public Situation(String subject, String text, int variants, int dT,int dH,int dS){
                this.dH = dH;
                this.dS = dS;
                this.dT = dT;
                this.text = text;
                direction = new Situation[variants];
            }
        }
//    сюжет
        class Story {
            private Situation start_story;
            public Situation current_situation;

            Story() {
                start_story = new Situation(///);
            }
        }

    }

}
