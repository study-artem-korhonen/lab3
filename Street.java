public class Street {
    String name;
    House[] houses;
    City city;

    public Street(String name, City city, House[] houses) {
        this.name = name;
        this.city = city;
        this.houses = houses;
    }

    public String repair(String subject) {
        return "Ќа улице " + this.name + " ремонтируетс€ " + subject;
    }

    @Override
    public String toString() {
        return this.name + " - улица, наход€ща€с€ в городе " + this.city.name;
    }

    @Override
    public int hashCode() {
        return this.houses.length * 50 - this.name.length() * 3 + this.city.hashCode();
    }

    public boolean equals(Street street) {
        return this.name.equals(street.name) && this.houses.equals(street.houses) && this.city.equals(street.city);
    }
}