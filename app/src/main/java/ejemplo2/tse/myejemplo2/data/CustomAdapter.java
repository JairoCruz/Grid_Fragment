package ejemplo2.tse.myejemplo2.data;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ejemplo2.tse.myejemplo2.R;
import ejemplo2.tse.myejemplo2.models.Room;

/**
 * Created by TSE on 15/05/2015.
 */
public class CustomAdapter extends ArrayAdapter<Room> {

    ArrayList<Room> data;
    LayoutInflater inflater;
    //para grid list
    boolean is_list;

    /* constructor de clase*/
    public CustomAdapter(Context context, ArrayList<Room> objects, boolean is_list) {
        super(context, -1, objects);
        this.is_list = is_list;

        this.data = objects;
        this.inflater = LayoutInflater.from(context);
    }


    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Room current_room = data.get(position);
        String room_type = current_room.getRoom_type();

        Log.e("Error-1", room_type);
        int img_resource = 0;
        if (room_type.equals(Room.STANDARD_ROOM)) {
            img_resource = R.mipmap.hotel2;
            Log.e("Error-2", room_type);
        } else {
            Log.e("Error-3", room_type);
            img_resource = R.mipmap.hotel1;
        }


        //este codigo es para el grid
        int layout = is_list? R.layout.list_row:R.layout.grid_element;

        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img_row);
            holder.title = (TextView) convertView.findViewById(R.id.txt_row_title);
            holder.subtitle = (TextView) convertView.findViewById(R.id.txt_row_subtitle);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(current_room.getRoom_number());
        holder.subtitle.setText(current_room.getRoom_type());
        holder.img.setImageResource(img_resource);

        return convertView;
    }

    private static class ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView subtitle;
    }
}
