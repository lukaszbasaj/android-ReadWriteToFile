package com.example.readwrite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.*;

public class ReadWrite extends AppCompatActivity {

    private Button writeText, readText;
    private EditText enterText;
    private TextView showText;
    private String FILE = "myfile";

    private String fileContent;

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
                fileContent = enterText.getText().toString();
                ReadWriteHandler.WriteToInternalStorage(getApplicationContext(), FILE, fileContent);
            }
        });
        readText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultText = ReadWriteHandler.ReadFromInternalStorage(getApplicationContext(), FILE);
                if (resultText != null) {
                    showText.setText(resultText);
                } else {
                    Toast.makeText(getApplicationContext(), ReadWriteHandler.errorText, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
