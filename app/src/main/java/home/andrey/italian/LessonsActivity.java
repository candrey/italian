package home.andrey.italian;

//import android.database.Cursor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
//import home.andrey.italian.Db;

public class LessonsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout lMain;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    Db mDbAdapter;
    int mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons);

        lMain = (LinearLayout) findViewById(R.id.lMain);

        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                wrapContent, wrapContent);
        //getItemCount();
        mDbAdapter = new Db(this);
        mCursor = mDbAdapter.getItemCount();

        for(int i = 0; i < mCursor; i++){
            Button button = new Button(this);
            button.setText(mDbAdapter.getLessons().get(i).getName()); //getComplete().toString());
            //button.setId(i);
           /* if (mDbAdapter.getLessons().get(i).getComplete() == 0) {
                button.setEnabled(false);
            }
            else {
                button.setEnabled(true);
            }*/
            button.setId(i+1);
            button.setOnClickListener(this);
            lMain.addView(button, -1, 150);
            mDbAdapter.getLesson();
        }

    }
        //View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //((Button) view).setText(Integer.toString(view.getId()));
            Intent intent = new Intent(this, LessonActivity.class);
            intent.putExtra("lessonsid",view.getId());
            startActivity(intent);
        }
}
