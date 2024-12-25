public class House {
    int number;
    int floors;
    String feature;
    Room[] rooms;
    Street street;

    public House(int number, int floors, String feature, Street street, Room[] rooms) {
        this.number = number;
        this.floors = floors;
        this.feature = feature;
        this.street = street;
        this.rooms = rooms;
    }

    public String repair(String subject) {
        return "� ���� �" + this.number + " �� ����� " + this.street.name + " ������������� " + subject;
    }

    @Override
    public String toString() {
        return "��� ��� �" + this.number + ", ����������� �� ����� " + this.street + ", � ������� " + this.floors + " ������";
    }

    @Override
    public int hashCode() {
        return this.number*1000 + this.floors*100 + this.feature.length()*10 + this.street.hashCode() + this.rooms.length;
    }

    public boolean equals(House house) {
        return this.number == house.number && this.floors == house.floors && this.feature.equals(house.feature) && this.rooms.equals(house.rooms);
    }
}