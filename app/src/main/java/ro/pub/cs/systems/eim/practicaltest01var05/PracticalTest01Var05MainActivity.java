package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {
    private Button navigateToSecondaryActivity;
    private Button topLeft;
    private Button topRight;
    private Button center;
    private Button bottomLeft;
    private Button bottomRight;
    private EditText editText;
    private int total_number_of_clicks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);
        navigateToSecondaryActivity = findViewById(R.id.navigate_to_secondary_activity_button);
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        center = findViewById(R.id.center);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        editText = findViewById(R.id.editText1);
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total_number_of_clicks++;
                String text = editText.getText().toString();
                text += topLeft.getText().toString();
                text += ", ";
                editText.setText(text);
            }
        });

        topRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total_number_of_clicks++;
                String text = editText.getText().toString();
                text += topRight.getText().toString();
                text += ", ";
                editText.setText(text);
            }
        });

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total_number_of_clicks++;
                String text = editText.getText().toString();
                text += center.getText().toString();
                text += ", ";
                editText.setText(text);
            }
        });

        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total_number_of_clicks++;
                String text = editText.getText().toString();
                text += bottomLeft.getText().toString();
                text += ", ";
                editText.setText(text);
            }
        });

        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total_number_of_clicks++;
                String text = editText.getText().toString();
                text += bottomRight.getText().toString();
                text += ", ";
                editText.setText(text);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("number_of_clicks", total_number_of_clicks);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("number_of_clicks")) {
            total_number_of_clicks = savedInstanceState.getInt("number_of_clicks");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (total_number_of_clicks != 0) {
            Toast.makeText(this, "Total number of clicks: " + total_number_of_clicks, Toast.LENGTH_LONG).show();
        }
    }
}