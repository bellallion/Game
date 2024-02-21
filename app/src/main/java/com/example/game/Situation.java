package com.example.game;

import java.io.Serializable;

public class Situation implements Serializable{
//      ситуация
//      наследуется от Serializable чтобы была после возможна Передача сложных объектов
    Situation[] direction; //
    String text, var1, var2, var3;
    int[] dR, dH, dM;
    Student student;
    public Situation(String subject, String text, String var1, String var2, String var3, int variants, int[] dR,int[] dH,int[] dM, Student student){
//                this.dR = new int[dR.length];
//                for(int i = 0; i < dR.length; i++){
//                    this.dR[i] = dR[i];
//                }
//                this.dH = new int[dH.length];
//                for(int i = 0; i < dH.length; i++){
//                    this.dH[i] = dH[i];
//                }
//                this.dM = new int[dM.length];
//                for(int i = 0; i < dM.length; i++){
//                    this.dM[i] = dM[i];
//                }
        this.student = student;
        this.dR = dR;
        this.dH = dH;
        this.dM = dM;
        this.text = text;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        direction = new Situation[variants]; // возможные варианты развития событий
    }
}
