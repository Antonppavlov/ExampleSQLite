package finance.android6.barmaglot.ru.examplesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public final static int DATABASE_VERSION = 1;
    public final static String DATABASE_NAME = "contactDB";
    public final static String TABLE_CONTACTS = "contacts";

    public final static String KEY_ID = "_id";
    public final static String KEY_NAME = "name";
    public final static String KEY_EMAIL = "email";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //метод для создания таблицы если она еще не создана
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE_CONTACTS +
                        " (" + KEY_ID + " integer primary key," +
                        KEY_NAME + " text," +
                        KEY_EMAIL + " text)"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);

        onCreate(db);
    }
}
