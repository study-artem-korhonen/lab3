public class City {
    String name;
    int citizensCount;
    Street[] streets;

    public City(String name, int citizensCount, Street[] streets) {
        this.name = name;
        this.citizensCount = citizensCount;
        this.streets = streets;
    }

    public void addCitizen(String name) {
        this.citizensCount += 1;
        System.out.println("� ������ " + this.name + " ��������� ����� ������ �� ����� " + name);
        System.out.println("������ � ������ ���� " + this.citizensCount + " �������");
    }

    @Override
    public String toString() {
        return this.name + " - ��� �����, � ������� ���� " + this.citizensCount + " �������";
    }

    @Override
    public int hashCode() {
        return this.citizensCount + this.name.length() + this.streets.length * this.streets.length;
    }

    public boolean equals(City city) {
        return this.name.equals(city.name) && this.citizensCount == city.citizensCount && this.streets.equals(city.streets);
    }

}