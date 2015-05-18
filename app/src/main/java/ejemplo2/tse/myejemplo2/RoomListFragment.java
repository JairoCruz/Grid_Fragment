package ejemplo2.tse.myejemplo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import ejemplo2.tse.myejemplo2.data.CustomAdapter;
import ejemplo2.tse.myejemplo2.models.Room;


public class RoomListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


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

        CustomAdapter adapter = new CustomAdapter(getActivity(),rooms,true);
        setListAdapter(adapter);

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Room clicked_room = (Room) l.getItemAtPosition(position);
        Intent intent = new Intent(getActivity(), RoomDetailActivity.class);
        intent.putExtra(RoomDetailActivity.ROOM_TYPE,clicked_room.getRoom_type());
        intent.putExtra(RoomDetailActivity.ROOM_NUMBER,clicked_room.getRoom_number());
        startActivity(intent);
    }
}
