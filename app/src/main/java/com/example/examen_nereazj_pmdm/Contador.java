package com.example.examen_nereazj_pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Contador extends AppCompatActivity {


    TextView crono;
    Button play;
    Boolean pausar;
    Button record;

    //Valores del Cronometro
int numero = 0;
   int valor =  1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        //Contador a cero
        crono = (TextView) findViewById(R.id.cronometro);

        //Botones
        play = (Button) findViewById(R.id.play);
        Button pausar = (Button) findViewById(R.id.pausar);
        record = (Button) findViewById(R.id.record);

        //RecyclerView
        RecyclerView rv = (RecyclerView) findViewById(R.id.timermarcas);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<Segundos> sg = Arrays.asList(
                new Segundos("0 segundos"),
                new Segundos(" ")

        );
        rv.setAdapter(new RecyclerAdapter(sg));
    }

    public void play (View v){
        crono.setText(numero);
        CronoHilo();
    }

    public void CronoHilo(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while(pausar == false){
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                numero = valor;
                //Background work here
                handler.post(() -> {
                    //UI Thread work here

                    crono.setText(numero);
                });}

        });
        if (pausar==true){
            pausar = false;
        }


    }
public void pausar (View v){
        pausar = true;
}


    //END APP
}