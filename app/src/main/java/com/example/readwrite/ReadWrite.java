package com.example.readwrite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;

import android.view.View;
import android.widget.Toast;
import android.widget.*;


public class ReadWrite extends AppCompatActivity {

    private Button writeText, readText;
    private EditText enterText;
    private TextView showText;
    private String file = "myfile";
    private String fileContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeText = findViewById(R.id.writeText);
        readText = findViewById(R.id.readText);
        enterText = findViewById(R.id.enterText);
        showText = findViewById(R.id.showView);

        writeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileContents = enterText.getText().toString();

                try {
                    FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
                    fOut.write(fileContents.getBytes());
                    fOut.close();
                    File fileDir = new File(getFilesDir(), file);
//                    Toast.makeText(getBaseContext(), text:
//                    "File Saved at" + fileDir, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        readText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fIn = openFileInput(file);
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1) {
                        temp = temp + Character.toString((char) c);
                    }
                    showText.setText(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
