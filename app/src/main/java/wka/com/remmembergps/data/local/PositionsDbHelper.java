package wka.com.remmembergps.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import wka.com.remmembergps.Utils.Constants.PositionsDatabase;

/**
 * Created by slave00 on 6/2/16.
 */
public class PositionsDbHelper extends SQLiteOpenHelper {
    private static PositionsDbHelper INSTANCE = null;

    public static synchronized PositionsDbHelper getHelper(Context context) {
        if (INSTANCE == null)
            INSTANCE = new PositionsDbHelper(context);
        return INSTANCE;
    }

    private PositionsDbHelper(Context context) {
        super(context, PositionsDatabase.DATABASE_NAME, null, PositionsDatabase.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PositionsDatabase.SQL_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
