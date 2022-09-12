package com.example.sqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper db;
    EditText name, surname, marks, stdId;
    Button insert, update, delete, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(MainActivity.this);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        marks = findViewById(R.id.marks);
        stdId = findViewById(R.id.stdId);

        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean IsInserted = db.InsertData(name.getText().toString(), surname.getText().toString(),
                                                    marks.getText().toString());
                if(IsInserted)
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer updatedRows = db.UpdateData(stdId.getText().toString(), name.getText().toString(),
                                                    surname.getText().toString(), marks.getText().toString());
                if(updatedRows > 0)
                    Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRows = db.DeleteRecord(stdId.getText().toString());
                if(deletedRows>0)
                    Toast.makeText(MainActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.GetAllRecords();
                if(res.getCount()==0)
                {
                    ShowMessage("Student Records", "Nothing found");
                }
                else
                {
                    StringBuffer buffer = new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("Id: " + res.getString(0) + "\n");
                        buffer.append("Name: " + res.getString(1) + "\n");
                        buffer.append("Surname: " + res.getString(2) + "\n");
                        buffer.append("Marks: " + res.getString(3) + "\n\n");
                    }
                    ShowMessage("Student Records", buffer.toString());
                }
            }
        });
    }

    public void ShowMessage(String title, String message){
//        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}