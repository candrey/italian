package home.andrey.italian;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
//import home.andrey.italian.Db;

public class LessonsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout lMain;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    private Db mDbAdapter;
    private int mCursor;

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
            if (mDbAdapter.getLessons().get(i).getComplete() == 0) {
                button.setEnabled(false);
            }
            else {
                button.setEnabled(true);
            }
            button.setOnClickListener(this);
            button.setId(i);
            lMain.addView(button, -1, 150);
        }

    }
        //View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((Button) view).setText(Integer.toString(view.getId()));
        }
}
