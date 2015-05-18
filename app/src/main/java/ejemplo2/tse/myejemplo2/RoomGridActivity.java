package ejemplo2.tse.myejemplo2;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import ejemplo2.tse.myejemplo2.data.CustomAdapter;
import ejemplo2.tse.myejemplo2.models.Room;


public class RoomGridActivity extends Activity {

    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_grid);

        grid = (GridView) findViewById(R.id.grid_rooms);

        ArrayList<Room> rooms = new ArrayList<Room>();

        for (String room : getResources().getStringArray(R.array.array_rooms_standard)) {
            Room one_room = new Room(Room.STANDARD_ROOM, room);
            rooms.add(one_room);
        }

        for (String room : getResources().getStringArray(R.array.array_rooms_luxury)) {
            Room one_room = new Room(Room.LUXURY_ROOM, room);
            rooms.add(one_room);
        }

        CustomAdapter adapter = new CustomAdapter(this, rooms,false);
        grid.setAdapter(adapter);

    }


}
