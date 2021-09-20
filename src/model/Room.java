package model;

public class Room implements IRoom{
    protected String roomNumber;
    protected double price;
    protected RoomType enumeration;
    public Room(String roomNumber, double price, RoomType enumeration){
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setEnumeration(RoomType enumeration) {
        this.enumeration = enumeration;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return price == 0;
    }

    @Override
    public String toString(){
        return "Room: " + roomNumber + " ——" + enumeration + " bed" + "\n"
                + "Price: $" + price + " per night";
    }
}
