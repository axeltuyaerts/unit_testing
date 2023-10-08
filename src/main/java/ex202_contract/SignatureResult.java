package ex202_contract;

public class SignatureResult {
    private final SignatureResultValue signatureResultValue;
    private final String errorMessage;
    private final Document document;

    private SignatureResult(SignatureResultValue signatureResultValue, String errorMessage, Document document) {
        this.signatureResultValue = signatureResultValue;
        this.errorMessage = errorMessage;
        this.document = document;
    }

    public static SignatureResult failure(String errorMessage) {
        return new SignatureResult(SignatureResultValue.FAILURE, errorMessage, null);
    }

    public static SignatureResult success(Document document) {
        return new SignatureResult(SignatureResultValue.SUCCESS, null, document);
    }

    public boolean isSuccessfullySigned() {
        return signatureResultValue == SignatureResultValue.SUCCESS;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Document getDocument() {
        return document;
    }

    private enum SignatureResultValue {
        FAILURE,
        SUCCESS
    }
}
