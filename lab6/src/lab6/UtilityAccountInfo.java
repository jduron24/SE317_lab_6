package lab6;

class UtilityAccountInfo {
    private String username;
    private String password;
    private String pin;
    private String amountDue;

    public UtilityAccountInfo(String username, String password, String pin, String amountDue) {
        this.username = username;
        this.password = password;
        this.pin = pin;
        this.amountDue = amountDue;
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
    
    public String getAmountDue() {
        return amountDue;
    }
    
}
