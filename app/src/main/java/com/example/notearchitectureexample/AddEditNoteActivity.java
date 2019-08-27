package com.example.notearchitectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {
    private EditText mEditTitle;
    private EditText mEditDesciption;
    private NumberPicker mNumberPickerPriority;
    public static final String EXTRA_ID="com.example.notearchitectureexample.EXTRA_ID";
    public static final String EXTRA_TITLE = " com.example.notearchitectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = " com.example.notearchitectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORATY = " com.example.notearchitectureexample.EXTRA_PRIORATY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        mEditTitle = findViewById(R.id.edit_text_title);
        mEditDesciption = findViewById(R.id.edit_text_description);
        mNumberPickerPriority = findViewById(R.id.number_picker_prioraty);
        mNumberPickerPriority.setMinValue(1);
        mNumberPickerPriority.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        Intent intent = getIntent();
        if (intent.hasExtra((EXTRA_ID))){
            setTitle("Edit note");
            mEditTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            mEditDesciption.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            mNumberPickerPriority.setValue(     intent.getIntExtra(EXTRA_PRIORATY,1));
    }else{


        setTitle("Add Note");
    }}
    private void saveNote() {
        String title = mEditTitle.getText().toString();
        String description = mEditDesciption.getText().toString();
        int priority = mNumberPickerPriority.getValue();
        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert Title and Description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORATY,priority);
        int id =getIntent().getIntExtra(EXTRA_ID,-1);
        if (id!=-1){
            data.putExtra(EXTRA_ID,id);
        }

        setResult(RESULT_OK,data);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
