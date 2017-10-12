package home.andrey.italian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LessonActivity extends AppCompatActivity {

    TextView tName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        tName = (TextView) findViewById(R.id.textTitle);
        Intent intent = getIntent();
        Db.getLesson();
        int lessonid = intent.getIntExtra("lessonsid", 1);
        tName.setText(String.valueOf(lessonid));
    }
}
