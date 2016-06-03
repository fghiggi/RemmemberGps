package wka.com.remmembergps.data;

import java.util.UUID;

/**
 * Created by slave00 on 6/2/16.
 */
public class Position {
    private UUID uuid;
    private String latitude;
    private String longitude;
    private String description;

    public Position() {
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return  latitude + ", " + longitude;
    }
}
