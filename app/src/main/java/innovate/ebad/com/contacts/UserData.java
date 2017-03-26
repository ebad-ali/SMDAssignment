package innovate.ebad.com.contacts;

class UserData {

    private String name;
    private String phoneNumber;
    private String initials;

    UserData(String name, String phoneNumber, String initials) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.initials = initials;
    }

    String getInitials() {
        return initials;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
