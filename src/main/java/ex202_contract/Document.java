package ex202_contract;

public class Document {
    private final byte[] documentContents;

    public Document(byte[] documentContents) {
        this.documentContents = documentContents;
    }

    public byte[] toByteArray() {
        return documentContents;
    }
}
