import java.util.Random;

public class main {
    public static void main(String[] args) {
        // �������� �������

        City flowerCity = new City("��������� �����", 0, null);

        Street appleSquare = new Street("�������� �������", flowerCity, null);
        Street cookieStreet = new Street("����� �������", flowerCity, null);
        Street lollipopStreet = new Street("���������� �����", flowerCity, null);

        House storyHouse = new House(10, 3, "���, � ������� ���� ������� �� ������ ����������", appleSquare, null);
        House basedHouse1 = new House(48, 3, "������� ���", appleSquare, null);
        House basedHouse2 = new House(12, 3, "������� ���", cookieStreet, null);
        House basedHouse3 = new House(31, 3, "������� ���", cookieStreet, null);
        House basedHouse4 = new House(33, 3, "������� ���", lollipopStreet, null);
        House basedHouse5 = new House(46, 3, "������� ���", lollipopStreet, null);

        Room basedRoom1 = new Room(1, 1, "������� �������", storyHouse);
        Room storyRoom = new Room(2, 2, "������� ������� � ������� �����", storyHouse);
        Room basedRoom2 = new Room(3, 3, "������� �������", storyHouse);
        Room basedRoom3 = new Room(1, 1, "������� �������", basedHouse1);
        Room basedRoom4 = new Room(2, 2, "������� �������", basedHouse1);
        Room basedRoom5 = new Room(3, 3, "������� �������", basedHouse1);
        Room basedRoom6 = new Room(1, 1, "������� �������", basedHouse2);
        Room basedRoom7 = new Room(2, 2, "������� �������", basedHouse2);
        Room basedRoom8 = new Room(3, 3, "������� �������", basedHouse2);
        Room basedRoom9 = new Room(1, 1, "������� �������", basedHouse3);
        Room basedRoom10 = new Room(2, 2, "������� �������", basedHouse3);
        Room basedRoom11 = new Room(3, 3, "������� �������", basedHouse3);
        Room basedRoom12 = new Room(1, 1, "������� �������", basedHouse4);
        Room basedRoom13 = new Room(2, 2, "������� �������", basedHouse4);
        Room basedRoom14 = new Room(3, 3, "������� �������", basedHouse4);
        Room basedRoom15 = new Room(1, 1, "������� �������", basedHouse5);
        Room basedRoom16 = new Room(2, 2, "������� �������", basedHouse5);
        Room basedRoom17 = new Room(3, 3, "������� �������", basedHouse5);

        Street[] streetsForCity = {appleSquare, cookieStreet, lollipopStreet};

        House[] housesForStreet1 = {storyHouse, basedHouse1};
        House[] housesForStreet2 = {basedHouse2, basedHouse3};
        House[] housesForStreet3 = {basedHouse4, basedHouse5};

        Room[] roomsForHouse1 = {basedRoom1, storyRoom, basedRoom2};
        Room[] roomsForHouse2 = {basedRoom3, basedRoom4, basedRoom5};
        Room[] roomsForHouse3 = {basedRoom6, basedRoom7, basedRoom8};
        Room[] roomsForHouse4 = {basedRoom9, basedRoom10, basedRoom11};
        Room[] roomsForHouse5 = {basedRoom12, basedRoom13, basedRoom14};
        Room[] roomsForHouse6 = {basedRoom15, basedRoom16, basedRoom17};

        flowerCity.streets = streetsForCity;

        appleSquare.houses = housesForStreet1;
        cookieStreet.houses = housesForStreet2;
        lollipopStreet.houses = housesForStreet3;

        storyHouse.rooms = roomsForHouse1;
        basedHouse1.rooms = roomsForHouse2;
        basedHouse2.rooms = roomsForHouse3;
        basedHouse3.rooms = roomsForHouse4;
        basedHouse4.rooms = roomsForHouse5;
        basedHouse5.rooms = roomsForHouse6;

        // �������� ����������

        UniquePerson Tyubik = new UniquePerson("�����", Talent.ARTIST);
        UniquePerson Guslya = new UniquePerson("�����", Talent.MUSICIAN);

        OrdinaryPerson[] ordinaryPersons = {
            new OrdinaryPerson("����", "", flowerCity),
            new OrdinaryPerson("����", "", flowerCity),
            new OrdinaryPerson("����", "", flowerCity),
            new OrdinaryPerson("����", "", flowerCity),
            new OrdinaryPerson("���", "", flowerCity),
            new OrdinaryPerson("���", "", flowerCity)
        };

        flowerCity.citizensCount += ordinaryPersons.length;

        // ������ ��������

        Tyubik.changeCity(flowerCity);
        Guslya.changeCity(flowerCity);

        for (int i = 0; i < ordinaryPersons.length; i++) {
            ordinaryPersons[i].findOut(Tyubik.name + " - " + Tyubik.talent.name + " � " + Guslya.name + " - " + Guslya.talent.name);
        }

        for (int i = 0; i < ordinaryPersons.length; i++) {
            ordinaryPersons[i].changeDesire("��������� ���� �� ������");
        }

        Random rn = new Random();
        Tyubik.seeAction(cookieStreet.repair("������"));
        House randomHouse = lollipopStreet.houses[rn.nextInt(lollipopStreet.houses.length)];
        Guslya.seeAction(randomHouse.repair("�����"));

        Tyubik.changeHouse(storyHouse);
        Guslya.changeHouse(storyHouse);

        for (int i = 0; i < ordinaryPersons.length; i++) {
            ordinaryPersons[i].findOut(Tyubik.name + " ���������(����) � ���� �� ����� " + Tyubik.house.street.name + " �" + Tyubik.house.number + " � ������������ " + Tyubik.house.feature);
            ordinaryPersons[i].findOut(Guslya.name + " ���������(����) � ���� �� ����� " + Guslya.house.street.name + " �" + Guslya.house.number + " � ������������ " + Guslya.house.feature);
        }

        Tyubik.getInterested(storyRoom.feature());

        Tyubik.changeRoom(storyRoom);
        Guslya.changeRoom(storyRoom);
    }
}