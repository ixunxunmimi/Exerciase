package e.l.exercise430;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import e.l.exercise430.photo.PictureActivity;
import e.l.exercise430.poem.PoemActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button getPoem;
    private Button layout;
    private Button photo;

    private int a = 1;
    private int b = 2;
    private int c = 3;
    private int d = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        getPoem = (Button) findViewById(R.id.getPoem);
        layout = (Button) findViewById(R.id.layout);
        photo = (Button) findViewById(R.id.photo);

        getPoem.setOnClickListener(this);
        layout.setOnClickListener(this);
        photo.setOnClickListener(this);

        a += 9;

        Log.e("tag","a:::"+a);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getPoem:
                Intent intent_poem = new Intent(MainActivity.this,PoemActivity.class);
                startActivity(intent_poem);
                break;
            case R.id.layout:
                Intent intent_layout = new Intent(MainActivity.this,LayoutActivity.class);
                startActivity(intent_layout);
                break;
            case R.id.photo:
                Intent intent_picture = new Intent(MainActivity.this,PictureActivity.class);
                startActivity(intent_picture);
                break;
        }
    }
}
