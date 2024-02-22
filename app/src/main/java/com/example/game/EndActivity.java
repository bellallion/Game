package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.databinding.ActivityEndBinding;

public class EndActivity extends AppCompatActivity {

    Story story = new Story();
    static String HEALTH = "За сегодня вы страшно вымотались. Не забывайте о своём здоровье.\n";
    static String FRIEND = "Вы хорошо потрудились за весь день, но важно и правильно отдыхать. Не хотите провести время с друзьями?\n";
    static String STUDY = "Делу время - потехе час. В следующий раз стоит больше времени уделить учебе.";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEndBinding binding = ActivityEndBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null) {
            story.current_situation = (Situation) arguments.getSerializable(Situation.class.getSimpleName());
        }

//        характеристика студента

        binding.dR.setText("Репутация:\n" + String.valueOf(story.current_situation.student.R));
        binding.dH.setText("Состояние:\n" + String.valueOf(story.current_situation.student.H));
        binding.dM.setText("Настроение:\n" + String.valueOf(story.current_situation.student.M));

        binding.Res.setText("Ваш день прошёл хорошо.\n");
        if(story.current_situation.student.R <= 40) binding.Res.setText(binding.Res.getText().toString() + " " + STUDY);
        if(story.current_situation.student.H <= 40) binding.Res.setText(binding.Res.getText().toString() + " " + HEALTH);
        if(story.current_situation.student.M <= 40) binding.Res.setText(binding.Res.getText().toString() + " " + FRIEND);

        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
