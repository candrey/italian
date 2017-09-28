package home.andrey.italian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLessons;
    Button btnGramma;
    Button btnDict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btnLessons = (Button) findViewById(R.id.buttonLes);
        btnLessons.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLes:
                Intent intent = new Intent(this, LessonsActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
