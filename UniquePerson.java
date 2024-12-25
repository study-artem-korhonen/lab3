public class UniquePerson extends Person {
    String name = null;
    Talent talent = null;
    City city = null;
    Street street = null;
    House house = null;
    Room room = null;

    public UniquePerson(String name, Talent talent) {
        this.name = name;
        this.talent = talent;
    }

    public void seeAction(String action) {
        System.out.println(this.name + " ������(�), ��� " + action);
    }

    public void getInterested(String object) {
        System.out.println(object + " �������������(�) " + this.name);
    }

    @Override
    public void changeCity(City city) {
        this.city = city;
        System.out.println(this.name + " ������� � ����� " + city.name);
        city.addCitizen(name);
    }

    public void changeStreet(Street street) {
        try {
            if (city == null) {
                throw new AddressException("!!! ����� �� ���������, �� ���������� ����� !!!");
            }
            this.street = street;
            System.out.println(this.name + " ��������� �� ����� " + street.name);
        } catch (AddressException e) {
            System.out.println(e.getMessage());
            this.changeCity(street.city);
            this.changeStreet(street);
        }
    }

    public void changeHouse(House house) {
        try {
            if (street == null) {
                throw new AddressException("!!! ����� �� ����������, �� ��������� ��� !!!");
            }
            this.house = house;
            System.out.println(this.name + " ��������� � ���� �" + house.number);
        } catch (AddressException e) {
            System.out.println(e.getMessage());
            this.changeStreet(house.street);
            this.changeHouse(house);
        }
    }

    public void changeRoom(Room room) {
        try {
            if (this.house == null) {
                throw new AddressException("!!! ��� �� ���������, �� ���������� ������� � ���� !!!");
            }
            this.room = room;
            System.out.println(this.name + " ���������(����) � ������� �" + room.number() + " �� " + room.floor() + "-� �����");
        } catch (AddressException e) {
            System.out.println(e.getMessage());
            this.changeHouse(room.house());
            this.changeRoom(room);
        }
    }

    @Override
    public String toString() {
        if (this.city == null) {
            return this.name + " - " + this.talent.name;
        } else if (this.street == null) {
            return this.name + " - " + this.talent.name + ", ������� ���� � ������";
        } else if (this.house == null) {
            return this.name + " - " + this.talent.name + ", ������� ���� � ������ " + this.city.name + " �� ����� " + this.street.name;
        } else if (this.room == null) {
            return this.name + " - " + this.talent + ", ������� ���� � ������ " + this.city.name + " �� ����� " + this.street.name + " � ���� �" + this.house.number;
        } else {
            return this.name + " - " + this.talent.name + ", ������� ���� � ������ " + this.city.name + " �� ����� " + this.street.name + " � ���� �" + this.house.number + " � ������� " + this.room.number() + " �� " + this.room.floor() + "-� �����";
        }
    }

    @Override
    public int hashCode() {
        if (this.city == null) {
            return this.name.length() + this.talent.name.length();
        } else if (this.street == null) {
            return this.name.length() + this.talent.name.length() + this.city.hashCode();
        } else if (this.house == null) {
            return this.name.length() + this.talent.name.length() + this.city.hashCode() + this.street.hashCode();
        } else if (this.room == null) {
            return this.name.length() + this.talent.name.length() + this.city.hashCode() + this.street.hashCode() + this.house.hashCode();
        } else {
            return this.name.length() + this.talent.name.length() + this.city.hashCode() + this.street.hashCode() + this.house.hashCode() + this.room.hashCode();
        }
    }

    public boolean equals(UniquePerson person) {
        return this.name.equals(person.name) && this.talent.equals(person.talent) && this.city.equals(person.city) && this.street.equals(person.street) && this.house.equals(person.house) && this.room.equals(person.room);
    }
}