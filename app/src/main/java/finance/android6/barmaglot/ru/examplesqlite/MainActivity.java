package finance.android6.barmaglot.ru.examplesqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd;
    Button buttonRead;
    Button buttonClear;
    EditText editName;
    EditText editEmail;


    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonRead = (Button) findViewById(R.id.buttonRead);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonAdd.setOnClickListener(this);
        buttonRead.setOnClickListener(this);
        buttonClear.setOnClickListener(this);


        editName = (EditText) findViewById(R.id.name);
        editEmail = (EditText) findViewById(R.id.email);


    }


    @Override
    public void onClick(View v) {
        dbHelper = new DBHelper(getApplicationContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String textName = editName.getText().toString();
        String textEmail = editEmail.getText().toString();

        switch (v.getId()) {
            case R.id.buttonAdd: {
                contentValues.put(DBHelper.KEY_NAME, textName);
                contentValues.put(DBHelper.KEY_EMAIL, textEmail);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;
            }
            case R.id.buttonRead: {
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);

                    do {
                        Log.i("Log",
                                        "ID = " + cursor.getString(idIndex) + "\n" +
                                        "NAME = " + cursor.getString(nameIndex) + "\n" +
                                        "EMAIL = " + cursor.getString(emailIndex) + "\n"


                        );
                    } while (cursor.moveToNext());
                }
                else {
                    Log.i("Log","0 rows");
                }
                cursor.close();
                break;
            }
            case R.id.buttonClear: {
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
            }
        }
        dbHelper.close();
    }
}
