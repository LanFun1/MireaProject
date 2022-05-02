package ru.mirea.vaydich.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

import java.util.Collections;


public class MyLoader extends AsyncTaskLoader<String> {
    private String mixString;
    public static final String ARG_WORD = "word";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            mixString = args.getString(ARG_WORD);

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        // emulate long-running operation
        SystemClock.sleep(5000);
        return mix(mixString);
    }

    static String mix(String str){
        ArrayList<Character> charList;
        charList = new ArrayList<>();
        for (char symbol : str.toCharArray()){
            charList.add(symbol);
        }
        Collections.shuffle(charList);
        str = charList.toString().replaceAll("^\\[|\\]$", "");
        str = str.replace(",","");
        return str;
    }

}