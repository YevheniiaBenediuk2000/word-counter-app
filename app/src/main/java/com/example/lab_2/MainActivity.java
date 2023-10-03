package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edUserInput;
    private TextView tvResult;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResult = findViewById(R.id.tvResult);

        // Set a OnClickListener to clear text when clicked
        this.edUserInput.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
             edUserInput.setText(""); // Clear the text when clicked
            }
        });

        this.spinner = (Spinner) findViewById(R.id.spCountOption);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter. createFromResource (this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter (adapter) ;
    }

    public void btnCountClick(View view) {
        String selectionChars = getResources().getString(R.string.selection_chars);

        // Validate if the input is empty
        String userInputTrimmed = this.edUserInput.getText().toString().trim(); // Trim to remove leading/trailing spaces

        if(userInputTrimmed.isEmpty()){
            Toast.makeText(this,"Please enter the text", Toast.LENGTH_SHORT).show();
            this.tvResult.setText("0");
        }else {
            if (this.spinner.getSelectedItem().toString().equalsIgnoreCase(selectionChars)) {

                String userInput = this.edUserInput.getText().toString();
                Log.i("UserText", userInput);

                int count = WordCounter.getCharsCount(userInput);
                Log.i("UserTextCount", String.valueOf(count));

                this.tvResult.setText(String.valueOf(count));
            } else {
                // Implementing words count
                int count = WordCounter.getWordsCount(userInputTrimmed);
                this.tvResult.setText(String.valueOf(count));
            }
        }
    }
}