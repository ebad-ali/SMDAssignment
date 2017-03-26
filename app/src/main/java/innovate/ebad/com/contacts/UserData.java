package innovate.ebad.com.contacts;



public class UserData {

    String name;
    String phoneNumber;

    public UserData(String name, String phoneNumber, String initials) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.initials = initials;
    }

    String initials;

    public String getInitials() {
        return initials;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
