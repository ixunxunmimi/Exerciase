package e.l.exercise430.poem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public class PoemDataBase {

    private PoemDBHelper helper;
    private Context context;
    private  SQLiteDatabase db;

    public PoemDataBase(Context context) {
        this.context = context;
        helper = new PoemDBHelper(context);
        db = helper.getReadableDatabase();
    }

    public void insert(String table, String nullColumnHack, ContentValues values){
        db.insert(table,nullColumnHack,values);
    }

    public Cursor query(String sql, String[] selectionArgs){
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        return  cursor;
    }
}
