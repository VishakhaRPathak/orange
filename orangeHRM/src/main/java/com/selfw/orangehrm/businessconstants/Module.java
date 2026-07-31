package com.selfw.orangehrm.businessconstants;

public enum Module {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    RECRUITMENT("Recruitment");

    private final String displayName;

    Module(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
