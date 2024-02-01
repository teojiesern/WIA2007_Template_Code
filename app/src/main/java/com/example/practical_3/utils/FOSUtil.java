package com.example.practical_3.utils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSUtil {
    private String FILE_NAME;
    private Context context;
    private String fileContent = "";

    public FOSUtil(Context context, String FILE_NAME, String fileContent){
        this.context = context;
        this.FILE_NAME = FILE_NAME;
        this.fileContent = fileContent;
    }
    public void write(){
        try (FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fos.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
