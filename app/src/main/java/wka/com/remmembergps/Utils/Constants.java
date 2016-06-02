package wka.com.remmembergps.Utils;

/**
 * Created by slave00 on 6/1/16.
 */
public class Constants {
    public static final String BROADCAST_LOCATION_SIGNATURE = "com.wka.remmembergps.intent.action.GPSMANAGER";

    public static final class DatabaseConstants {
        public static final String COMMA_SEP = ", ";

        public static final String TEXT_TYPE = " TEXT";

        public static final String DECIMAL_TYPE = " DOUBLE";

        public static final String INTEGER_TYPE = " INTEGER"
                ;
        public static final String PRIMARY_TYPE = " PRIMARY KEY";

        public static final String GENERATED_ID = "_id";

        public static final String INCREMENT_TYPE = " AUTOINCREMENT";
    }

    public static final class MapConstants {
        public static final String MAP_URL = "http://maps.googleapis.com/maps/api/staticmap?";
        public static final String CENTER_LOCATION = "center=";
        public static final String ZOOM = "&zoom=13";
        public static final String SCALE = "&scale=2";
        public static final String MAP_SIZE = "&size=180x283";
        public static final String MAP_TYPE = "&maptype=roadmap";
        public static final String MAP_IMAGE_FORMAT = "&format=jpg";
        public static final String VISUAL_REFRESH = "&visual_refresh=true";
        public static final String MARK_NOW_CONFIGURATION = "&markers=size:mid%7Ccolor:0x0053ff%7Clabel:%7C";
        public static final String MARK_FAV_CONFIGURATION = "&markers=size:small%7Ccolor:0x1faa37%7Clabel:%7C";
    }

    public static final class Intents {
        public static final int BOOKMARK_POSITION = 1;
        public static final String LOCATION_STATUS_LONGITUDE = "longitude";
        public static final String LOCATION_STATUS_LATITUDE = "latitude";
        public static final String LOCATION_STATUS_ALTITUDE = "altitude";
        public static final String LOCATION_STATUS_SPEED = "speed";
    }
}
