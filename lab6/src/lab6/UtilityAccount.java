package lab6;

public class UtilityAccount {
    private String accountId;
    private String providerName;

    public UtilityAccount(String accountId, String providerName) {
        this.accountId = accountId;
        this.providerName = providerName;
    }

    // Getters for accountId and providerName
    public String getAccountId() {
        return accountId;
    }

    public String getProviderName() {
        return providerName;
    }
}
