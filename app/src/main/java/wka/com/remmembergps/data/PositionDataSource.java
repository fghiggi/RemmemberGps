package wka.com.remmembergps.data;

import java.util.List;

/**
 * Created by slave00 on 6/2/16.
 */
public interface PositionDataSource {
    void addPosition(Position p);
    List<Position> getPositions();
}
