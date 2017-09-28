package home.andrey.italian;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = "my_tag";

    public static final String TABLE_NAME = "lessons";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_COMPLETE = "complete";

    private static final String DATABASE_NAME = "italian";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +" ("
                + KEY_ID + " integer primary key autoincrement,"
                + KEY_NAME + " text,"
                + KEY_COMPLETE + " integer" + ");");

        ContentValues cv = new ContentValues();

        cv.put(KEY_NAME, "Урок 1");
        cv.put(KEY_COMPLETE, 0);
        db.insert(TABLE_NAME, null, cv);

        cv.put(KEY_NAME, "Урок 2");
        cv.put(KEY_COMPLETE, 0);
        db.insert(TABLE_NAME, null, cv);

/*        cv.put(KEY_NAME, "Alex");
        cv.put(KEY_EMAIL, "email3@email.com");
        db.insert(TABLE_NAME, null, cv);
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

}
