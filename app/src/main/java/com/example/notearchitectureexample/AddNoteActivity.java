package com.example.notearchitectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
private EditText mEditTitle;
private EditText mEditDesciption;
private NumberPicker mNumberPickerPriority;
public static final String EXTRA_
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        mEditTitle=findViewById(R.id.edit_text_title);
        mEditDesciption=findViewById(R.id.edit_text_description);
        mNumberPickerPriority=findViewById(R.id.number_picker_prioraty);
        mNumberPickerPriority.setMinValue(1);
        mNumberPickerPriority.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    private void saveNote() {
        String title=mEditTitle.getText().toString();
        String description=mEditDesciption.getText().toString();
        int Prioratity=mNumberPickerPriority.getValue();
if (title.trim().isEmpty()||description.trim().isEmpty()){
    Toast.makeText(this,"Please insert Title and Description",Toast.LENGTH_SHORT).show();
}
    }
}
