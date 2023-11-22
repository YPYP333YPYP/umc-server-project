package umc.spring.apiPayload.code.status;

public enum SuccessStatus {
    _OK;

    public String getCode() {
        return "2000";
    }

    public String getMessage() {
        return "OK";
    }
}
