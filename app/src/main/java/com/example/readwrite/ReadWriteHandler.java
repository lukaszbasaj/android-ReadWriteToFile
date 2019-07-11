package com.example.readwrite;

import android.content.Context;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static android.content.Context.MODE_PRIVATE;

public class ReadWriteHandler {

    public static String errorText;

    public static void WriteToInternalStorage(Context context, String file, String fileContent) {
        try {
            File fileDir = new File(context.getFilesDir(), file);
            FileOutputStream fOut = context.openFileOutput(file, MODE_PRIVATE);
            fOut.write(fileContent.getBytes());
            fOut.close();
        } catch (FileNotFoundException e) {
            errorText = e.getMessage();
            e.printStackTrace();
        } catch (IOException IOe) {
            errorText = IOe.getMessage();
            IOe.printStackTrace();
        }
    }

    public static String ReadFromInternalStorage(Context context, String file) {
        String temp = "";
        try {
            FileInputStream fIn = context.openFileInput(file);
            int c;
            while ((c = fIn.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
        } catch (FileNotFoundException e) {
            errorText = e.getMessage();
            e.printStackTrace();
            return null;
        } catch (IOException IOe) {
            errorText = IOe.getMessage();
            IOe.printStackTrace();
            return null;
        }
        return temp;
    }
}
