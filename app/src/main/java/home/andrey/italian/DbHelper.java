package home.andrey.italian;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.hardware.camera2.params.StreamConfigurationMap;

public class DbHelper extends SQLiteOpenHelper {

    //private static final String LOG_TAG = "my_tag";

    /*public static final String TABLE_NAME = "lessons";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_COMPLETE = "complete";
*/
    static final String dbName="italian";
    private static final int dbVersion = 1;
    static final String lessonsTable="lessons";
    static final String lessonTable="lesson";
    static final String colID="id";
    static final String colName="name";
    static final String colComplete="complete";
        //static final String colLessonID="id";
    //static final String colLessonName="name";
    static final String colDescription="description";
    static final String colContent="content";
    static final String colLessonsID="lessons_id";

    //static final String viewLesson="ViewLesson";

    //private static final String DATABASE_NAME = "italian";
    //private static final int DATABASE_VERSION = 4;

    public DbHelper(Context  context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + lessonTable + " (" +
                        colID + " integer primary key autoincrement, " +
                        colDescription + " text, " +
                        colContent + " text, " +
                        colLessonsID + " integer not null )");

        db.execSQL("create table " + lessonsTable + " (" +
                colID + " integer primary key, " +
                colName + " text, " +
                colComplete + " integer )"
        );

        ContentValues cv = new ContentValues();

        cv.put(colID, 1);
        cv.put(colName, "Урок 1");
        cv.put(colComplete, 1);
        db.insert(lessonsTable, null, cv);

        cv.put(colID, 2);
        cv.put(colName, "Урок 2");
        cv.put(colComplete, 0);
        db.insert(lessonsTable, null, cv);

        cv.put(colID, 3);
        cv.put(colName, "Урок 3");
        cv.put(colComplete, 0);
        db.insert(lessonsTable, null, cv);

        cv.put(colDescription, "Это урок 1");
        cv.put(colContent, "Здесь много текста");
        cv.put(colLessonsID, 1);
        db.insert(lessonTable, null, cv);

        cv.put(colDescription, "Это урок 2");
        cv.put(colContent, "И здесь много текста");
        cv.put(colLessonsID, 2);
        db.insert(lessonTable, null, cv);

        cv.put(colDescription, "Это урок 3");
        cv.put(colContent, "Здесь ещё больше текста");
        cv.put(colLessonsID, 3);
        db.insert(lessonTable, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + lessonsTable);
        db.execSQL("DROP TABLE IF EXISTS " + lessonTable);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + lessonsTable);
        db.execSQL("DROP TABLE IF EXISTS " + lessonTable);
        onCreate(db);
    }

}
