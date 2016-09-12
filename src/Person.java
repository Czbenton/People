/**
 * Created by Zach on 9/12/16.
 */
public class Person implements Comparable {
    private String iD;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String ipAddress;

    public Person(String iD, String firstName, String lastName, String email, String country, String ipAddress) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ipAddress = ipAddress;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o; //casting person to object
        return lastName.compareTo(p.lastName);
    }

    @Override
    public String toString() {
        return String.format("%s %s from %s.",firstName, lastName, country);
    }
}