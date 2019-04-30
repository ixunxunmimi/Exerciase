package e.l.exercise430.photo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public class PictureDBHelper extends SQLiteOpenHelper{

    public static final String PIC = "pic";

    public PictureDBHelper(Context context) {
        super(context, "1609img.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PIC + "(imgsrc text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
