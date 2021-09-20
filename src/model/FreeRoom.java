package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, RoomType enumeration){
        super(roomNumber,0,enumeration);
    }

    @Override
    public String toString(){
        return "Room: " + roomNumber + " ——" + enumeration + " bed" + "\n"
                + "Price: $0.0 per night";
    }
}
