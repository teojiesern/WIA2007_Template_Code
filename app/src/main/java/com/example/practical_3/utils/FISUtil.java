package com.example.practical_3.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

// can be used for things like app-specific-storage
public class FISUtil {
    private String FILE_NAME;
    private Context context;
    private String FileContent = "";
    private FileInputStream FIS = null;

    public FISUtil(Context context, String FILE_NAME){
        this.FILE_NAME = FILE_NAME;
        this.context = context;
    }

    public String read(){
        try {
            FIS = context.openFileInput(FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(FIS, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileContent = stringBuilder.toString();
        }

        return FileContent;
    }
}
