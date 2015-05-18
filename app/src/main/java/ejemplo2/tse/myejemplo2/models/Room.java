package ejemplo2.tse.myejemplo2.models;

/**
 * Created by TSE on 15/05/2015.
 */
public class Room {

    public final static String LUXURY_ROOM = "De Lujo";
    public final static String STANDARD_ROOM = "Estandar";
    private String room_type;
    private String room_number;


    public Room(String room_type, String room_number) {
        this.room_type = room_type;
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }
}
