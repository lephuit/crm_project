package model;

public enum UserColumn {
    ID("id"), EMAIL("email"),PASSWORD("password"),FULLNAME("fullname"), FISTNAME("firstName "),
    LASTNAME("lastName "),AVATAR("avatar"),
        ROLE_ID("role_id"),ROLE_NAME("role_name");
    private String value;
    UserColumn(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
