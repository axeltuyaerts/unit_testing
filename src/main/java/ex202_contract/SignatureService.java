package ex202_contract;

public class SignatureService {
    private final ConnectivePluginAdapter connectivePluginAdapter;

    private String connectiveUrl;
    private String connectiveUserId;
    private String connectivePassword;

    public SignatureService(ConnectivePluginAdapter connectivePluginAdapter) {
        this.connectivePluginAdapter = connectivePluginAdapter;
    }

    public SignatureResult signDocument(Document document, Person person) {
        if (connectivePluginAdapter.isPluginReady()) {
            try {
                ConnectiveConnection connection = connectivePluginAdapter.connectToPlatform(connectiveUrl, connectiveUserId, connectivePassword);
                connectivePluginAdapter.uploadDocumentToSign(connection, document);
                Document signedDocument = connectivePluginAdapter.requestSignatureFromUser(connection, person);
                return SignatureResult.success(signedDocument);
            }
            catch (ConnectiveException e) {
                return SignatureResult.failure("Technical failure");
            }
        }
        else {
            return SignatureResult.failure("Plugin is not ready for signature");
        }
    }

    public void setConnectiveUrl(String connectiveUrl) {
        this.connectiveUrl = connectiveUrl;
    }

    public void setConnectiveUserId(String connectiveUserId) {
        this.connectiveUserId = connectiveUserId;
    }

    public void setConnectivePassword(String connectivePassword) {
        this.connectivePassword = connectivePassword;
    }
}
