package home.andrey.italian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnPopUp = (Button) findViewById(R.id.buttonPopUp);
        btnPopUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPopUp:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
