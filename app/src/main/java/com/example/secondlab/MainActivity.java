package com.example.secondlab;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Spinner spinner;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setText(R.string.button_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                String selectedOption = spinner.getSelectedItem().toString();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_empty_sentence, Toast.LENGTH_SHORT).show();
                } else {
                    int count = WordCharacterCounter.getCount(inputText, selectedOption);
                    textView.setText(getString(R.string.result_prefix) + count);
                }
            }
        });
    }
}

