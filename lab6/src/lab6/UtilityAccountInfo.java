package lab6;

class UtilityAccountInfo {
    private String username;
    private String password;
    private String pin;

    public UtilityAccountInfo(String username, String password, String pin) {
        this.username = username;
        this.password = password;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPin() {
        return pin;
    }
}
