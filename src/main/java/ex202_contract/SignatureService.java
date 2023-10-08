package ex202_contract;

public class SignatureService {
    private final ConnectivePlugin connectivePlugin;

    private String connectiveUrl;
    private String connectiveUserId;
    private String connectivePassword;

    public SignatureService(ConnectivePlugin connectivePlugin) {
        this.connectivePlugin = connectivePlugin;
    }

    public SignatureResult signDocument(Document document, Person person) {
        if (connectivePlugin.isPluginReady()) {
            try {
                ConnectiveConnection connection = connectivePlugin.connectToPlatform(connectiveUrl, connectiveUserId, connectivePassword);
                connectivePlugin.uploadDocumentToSign(connection, document);
                Document signedDocument = connectivePlugin.requestSignatureFromUser(connection, person);
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
