package wka.com.remmembergps.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.ParseException;

import java.util.ArrayList;
import java.util.UUID;

import java.util.List;

import wka.com.remmembergps.Utils.Constants;
import wka.com.remmembergps.Utils.Constants.PositionsDatabase.PositionTable;
import wka.com.remmembergps.data.local.PositionsDbHelper;

/**
 * Created by slave00 on 6/2/16.
 */
public class PositionsDB implements PositionDataSource {
    protected SQLiteDatabase database;
    private PositionsDbHelper dbHelper;
    private Context mContext;

    public PositionsDB(Context context){
        this.mContext = context;
        dbHelper = PositionsDbHelper.getHelper(mContext);
        open();
    }

    @Override
    public void addPosition(Position p) {
        ContentValues values = new ContentValues();
        values.put(PositionTable.Columns.UUID, p.getUuid().toString());
        values.put(PositionTable.Columns.LATITUDE, String.valueOf(p.getLatitude()));
        values.put(PositionTable.Columns.LONGITUDE, String.valueOf(p.getLongitude()));
        values.put(PositionTable.Columns.DESCRIPTION, p.getDescription());

        database.insertWithOnConflict(PositionTable.NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<Position>();

        Cursor cursor = database.query(PositionTable.NAME,
                new String[] { PositionTable.Columns.LATITUDE,
                               PositionTable.Columns.LONGITUDE,
                               PositionTable.Columns.DESCRIPTION }, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Position position = new Position();
            position.setLatitude(cursor.getString(0));
            position.setLongitude(cursor.getString(1));
            position.setDescription(cursor.getString(2));

            positions.add(position);
        }
        return positions;
    }

    public void open() throws SQLException {
        if(dbHelper == null)
            dbHelper = PositionsDbHelper.getHelper(mContext);
        database = dbHelper.getWritableDatabase();
    }

    public void Close() throws SQLException {
        database.close();
        database = null;
    }
}
