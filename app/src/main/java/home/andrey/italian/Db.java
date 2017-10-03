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
    private static Cursor cursor;
    private static SQLiteDatabase db;
    DbHelper dbHelper;
    Context context;
    //Cursor cursor;
    //SQLiteDatabase db;
    List<Lessons> mLessonsList;

    Db(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }
    // возвращает количество записей в таблице
    int getItemCount() {

        db = dbHelper.getReadableDatabase();

        cursor = db.query(DbHelper.lessonsTable, null, null, null, null, null, null);
        int cnt = cursor.getCount();
        cursor.close();

        return cnt;
    }
/*
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
*/
    public static void getLesson() {

        Log.d(LOG_TAG, "---INNER JOIN with rawQuery---");
        String sqlQuery = "select lessons.name as Name, lesson.description as Description, "
                + "lesson.content as Content "
                + "from lessons "
                + "inner join lesson "
                + "on lesson.foreg_id = lessons.id;";
                //+ "where salary > ?";
//        select lessons.name as Name, lesson.description as Description,lesson.content as Content
//        from lessons inner join lesson on lesson.foreg_id = lessons.id;
        cursor = db.rawQuery(sqlQuery, null);//, new String[]{"40000"});
        //Log.d(cursor);
        logCursor(cursor);
        cursor.close();
        Log.d(LOG_TAG, "--- ---");
    }

    static void logCursor(Cursor cursor) {
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : cursor.getColumnNames()) {
                        str = str.concat(cn + " = " + cursor.getString(cursor.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(LOG_TAG, str);
                } while (cursor.moveToNext());
            }
        } else Log.d(LOG_TAG, "Cursor is null");
    }

    // метод возвращающий коллекцию всех данных
    public List<Lessons> getLessons() {
        cursor = db.query(DbHelper.lessonsTable, null, null, null, null, null, null);
        mLessonsList = new ArrayList<Lessons>();

        if (cursor.moveToFirst()) {

            int idColInd = cursor.getColumnIndex(DbHelper.colID);
            int nameColInd = cursor.getColumnIndex(DbHelper.colName);
            int completeColInd = cursor.getColumnIndex(DbHelper.colComplete);

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