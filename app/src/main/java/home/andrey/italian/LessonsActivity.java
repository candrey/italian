package home.andrey.italian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LessonsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout lMain;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons);

        lMain = (LinearLayout) findViewById(R.id.lMain);

        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                wrapContent, wrapContent);
        for(int i = 0; i < 20; i++){
            Button button = new Button(this);
            button.setText("новая кнопка");
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
