package co.uk.atlantis.dvsatestfinder.enums;

public enum FinderEnum {

    UNAVAILABLE_TEST_DATE("No More Available Test Date");

    private String message;

    FinderEnum(String message) {
        this.message = message;
    }

    public String messages() {
        return  message;
    }
}
