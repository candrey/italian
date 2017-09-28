package home.andrey.italian;

import java.util.ArrayList;
import java.util.List;
import home.andrey.italian.Lessons;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Db {

    private static final String LOG_TAG = "my_tag";
    DbHelper dbHelper;
    Context context;
    Cursor cursor;
    SQLiteDatabase db;
    List<Lessons> mLessonsList;

    public Db(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }
    // возвращает количество записей в таблице
    public int getItemCount() {

        db = dbHelper.getReadableDatabase();

        cursor = db.query(DbHelper.TABLE_NAME, null, null, null, null, null, null);
        int cnt = cursor.getCount();
        cursor.close();

        return cnt;
    }

    // метод для обновления email
    public void updateComplete(String name, String newEmail){
        db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.KEY_COMPLETE, 0);
        String[] args = new String[]{name};
        db.update(DbHelper.TABLE_NAME, cv, "name = ?", args);
    }
    // метод для удаления строки по id
    public void deleteItem(int id) {
        db = dbHelper.getWritableDatabase();
        db.delete(DbHelper.TABLE_NAME, DbHelper.KEY_ID + "=" + id, null);
    }

    // метод возвращающий коллекцию всех данных
    public List<Lessons> getLessons() {
        cursor = db.query(DbHelper.TABLE_NAME, null, null, null, null, null, null);
        mLessonsList = new ArrayList<Lessons>();

        if (cursor.moveToFirst()) {

            int idColInd = cursor.getColumnIndex(DbHelper.KEY_ID);
            int nameColInd = cursor.getColumnIndex(DbHelper.KEY_NAME);
            int completeColInd = cursor.getColumnIndex(DbHelper.KEY_COMPLETE);

            do {
                Lessons friend = new Lessons(cursor.getInt(idColInd),
                        cursor.getString(nameColInd), cursor.getInt(completeColInd));
                mLessonsList.add(friend);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В базе нет данных!");
        }

        cursor.close();

        return mLessonsList;

    }
    // здесь закрываем все соединения с базой и класс-помощник
    public void close() {
        dbHelper.close();
        db.close();
    }

}