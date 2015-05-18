package ejemplo2.tse.myejemplo2;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import ejemplo2.tse.myejemplo2.data.CustomAdapter;
import ejemplo2.tse.myejemplo2.models.Room;


public class RoomListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        ListView list = getListView();
        ArrayList<Room> rooms = new ArrayList<Room>();

        for (String room : getResources().getStringArray(R.array.array_rooms_standard)){
            Room one_room = new Room(Room.STANDARD_ROOM,room);
            rooms.add(one_room);
        }

        for (String room : getResources().getStringArray(R.array.array_rooms_luxury)){
            Room one_room = new Room(Room.LUXURY_ROOM,room);
            rooms.add(one_room);
        }

        CustomAdapter adapter = new CustomAdapter(this,rooms,true);
        setListAdapter(adapter);

    }


}
