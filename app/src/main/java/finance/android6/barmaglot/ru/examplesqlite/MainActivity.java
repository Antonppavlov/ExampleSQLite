package finance.android6.barmaglot.ru.examplesqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import finance.android6.barmaglot.ru.examplesqlite.obj.Contact;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd;
    Button buttonRead;
    Button buttonClear;
    EditText editName;
    EditText editEmail;

    TextView textView;



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
        editEmail = (EditText) findViewById(R.id.mail);

        textView = (TextView) findViewById(R.id.textView);

    }


    @Override
    public void onClick(View v) {
         String textName = editName.getText().toString();
        String textEmail = editEmail.getText().toString();

        switch (v.getId()) {
            case R.id.buttonAdd: {
                Contact contact = new Contact(textEmail, textName);
                contact.save();
                break;
            }
            case R.id.buttonRead: {
                List<Contact> contactses = Contact.listAll(Contact.class);
                Log.i("Contact", contactses.toString());
                textView.setText(contactses.toString());
                break;
            }
            case R.id.buttonClear: {
                Contact.deleteAll(Contact.class);
                break;
            }
        }
    }
}
