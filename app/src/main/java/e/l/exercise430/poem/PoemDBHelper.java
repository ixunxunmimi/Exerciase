package e.l.exercise430.poem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public class PoemDBHelper extends SQLiteOpenHelper{

    public static final String POEM = "poem";

    public PoemDBHelper(Context context) {
        super(context, "1609" + POEM + ".db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + POEM + " (title text,author text,content text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
