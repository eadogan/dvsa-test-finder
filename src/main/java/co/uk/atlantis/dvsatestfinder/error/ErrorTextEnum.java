package co.uk.atlantis.dvsatestfinder.error;

public enum ErrorTextEnum {

    INVALID_LICENCE_NUMBER("Invalid Licence Number"),
    INVALID_REFEERENCCE_NUMBER("Invalid Reference Number"),
    NOT_FOUND("Not Found");

    private String errorMessage;

    ErrorTextEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String message() {
        return  errorMessage;
    }

}
