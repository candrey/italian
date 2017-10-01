package home.andrey.italian;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.StreamConfigurationMap;

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
    static final String colLessonsID="id";
    static final String colLessonsName="name";
    static final String colLessonsComplete="complete";

    static final String lessonTable="lesson";
    static final String colLessonID="id";
    static final String colLessonName="name";
    static final String colLessonDescription="description";
    static final String colLessonContent="content";
    static final String colForegID="foreg_id";

    static final String viewLesson="ViewLesson";

    //private static final String DATABASE_NAME = "italian";
    //private static final int DATABASE_VERSION = 4;

    public DbHelper(Context  context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + lessonTable + " (" +
                colLessonID + " integer primary key autoincrement, " +
                colLessonName + " text, " +
                colLessonDescription + " text, " +
                colLessonContent + " text, " +
                colForegID + " integer not null, " +
                "foreign key(" + colForegID + ") references " +
                lessonsTable + "(" + colLessonsID +") " +
                "on update action");"
        );

        db.execSQL("create table " + lessonsTable + " (" +
                colLessonsID + " integer primary key autoincrement, " +
                colLessonsName + " text, " +
                colLessonsComplete + " integer );"
        );

        db.execSQL(""
        );
    }

/*
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table lessons  ( "
                + "_id integer primary key autoincrement, "
                + "name text, "
                + "complete integer );");

        ContentValues cv = new ContentValues();

        cv.put("name", "Урок 1");
        cv.put("complete", 1);
        db.insert("lessons", null, cv);

        cv.put("name", "Урок 2");
        cv.put("complete", 0);
        db.insert("lessons", null, cv);

        cv.put("name", "Урок 3");
        cv.put("complete", 0);
        db.insert("lessons", null, cv);

        db.execSQL("create table lesson  ( "
                + "_id integer primary key autoincrement, "
                + "lessons_id integer, "
                + "name text, "
                + "description text, "
                + "content text);");

        cv.put("lessons_id", 1);
        cv.put("name", "Урок 1");
        cv.put("description", "Это урок 1");
        cv.put("content", "Здесь много ткаста\nДа да да");
        db.insert("lesson", null, cv);
    }
*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS lessons; "
        + "DROP TABLE IF EXISTS lesson;");
        this.onCreate(db);
    }

}
