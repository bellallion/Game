package com.example.game;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.databinding.ActivityEndBinding;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEndBinding binding = ActivityEndBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
