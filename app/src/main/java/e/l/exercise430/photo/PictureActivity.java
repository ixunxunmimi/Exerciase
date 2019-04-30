package e.l.exercise430.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

import e.l.exercise430.R;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public class PictureActivity extends AppCompatActivity implements View.OnClickListener {

    private Button open;
    private PictureDatabaseDao dao;
    private String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        initView();
        dao = new PictureDatabaseDao(this);

    }

    private void initView() {
        open = (Button) findViewById(R.id.open);

        open.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open:
                openPic();
                break;
        }
    }

    private void openPic() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}
