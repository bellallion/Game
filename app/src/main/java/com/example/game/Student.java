package com.example.game;

import java.io.Serializable;

public class Student implements Serializable {
    //        персонаж
    public int R; // репутация
    public int M; // настроение
    public int H; // здоровье
    public Student(){
        R = 50;
        M = 70;
        H = 50; // нужно ли мне это писать?
    }
}
