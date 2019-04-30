package e.l.exercise430.photo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public class PictureDatabaseDao {

    private PictureDBHelper helper;
    private Context context;
    private SQLiteDatabase db;

    public PictureDatabaseDao(Context context) {
        this.context = context;
        helper = new PictureDBHelper(context);
        db = helper.getReadableDatabase();
    }

    public void insert(String table, String nullColumnHack, ContentValues values){
        db.insert(table,nullColumnHack,values);
    }
}
