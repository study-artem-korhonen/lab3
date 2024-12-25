public class OrdinaryPerson extends Person {
    String name;
    String desire;
    City city;

    public OrdinaryPerson(String name, String desire, City city) {
        this.name = name;
        this.desire = desire;
        this.city = city;
    }

    public void changeDesire(String new_desire) {
        this.desire = new_desire;
        System.out.println(name + " ����� " + new_desire);
    }

    public void findOut(String information) {
        System.out.println(name + " �����(�) � ���, ��� " + information);
    }

    @Override
    public void changeCity(City city) {
        this.city = city;
        System.out.println(this.name + " �������� � ����� " + city);
    }

    @Override
    public String toString() {
        return this.name + " - ������ ������ " + this.city.name;
    }

    @Override
    public int hashCode() {
        return this.name.length()*110 - this.city.name.length() * this.city.name.length() + this.desire.length() - 3;
    }

    public boolean equals(OrdinaryPerson person) {
        return this.name.equals(person.name) && this.desire.equals(person.desire) && this.city.equals(person.city);
    }
}