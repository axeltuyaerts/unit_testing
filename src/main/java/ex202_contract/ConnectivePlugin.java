package ex202_contract;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

public class ConnectivePlugin {
    public boolean isPluginReady() {
        // check if browser session is active and Connective plugin is loaded
        return true;
    }

    public ConnectiveConnection connectToPlatform(String connectiveUrl, String connectiveUserId, String connectivePassword) {
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        try {
            HttpResponse<String> httpResponse = getHttpClient().send(HttpRequest.newBuilder()
                            .header("userId", Base64.getEncoder().encodeToString(connectiveUrl.getBytes()))
                            .header("password", Base64.getEncoder().encodeToString(connectiveUrl.getBytes()))
                            .uri(URI.create(connectiveUrl + "/connect"))
                            .GET()
                            .build(),
                    responseBodyHandler);

            if (httpResponse.statusCode() != 200) {
                throw new ConnectiveException("Failed to sign in to Connective");
            }

            return new ConnectiveConnection(connectiveUrl, ZonedDateTime.now(), httpResponse.body());
        } catch (IOException e) {
            throw new ConnectiveException("Can't connect to the Connective platform", e);
        } catch (InterruptedException e) {
            throw new ConnectiveException("A problem occurred while connecting to the Connective platform", e);
        }
    }

    private static HttpClient getHttpClient() {
        return HttpClient.newBuilder()
                .connectTimeout(Duration.of(600, ChronoUnit.SECONDS))
                .authenticator(Authenticator.getDefault())
                .build();
    }

    public void uploadDocumentToSign(ConnectiveConnection connection, Document document) {
        if (!connection.isConnectionActive()) {
            throw new ConnectiveException("Connection timeout");
        }

        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        try {
            HttpResponse<String> httpResponse = getHttpClient().send(HttpRequest.newBuilder()
                            .header("bearer", Base64.getEncoder().encodeToString(connection.getBearerToken().getBytes()))
                            .uri(URI.create(connection.getUrl() + "/upload"))
                            .POST(HttpRequest.BodyPublishers.ofByteArray(document.toByteArray()))
                            .build(),
                    responseBodyHandler);

            if (httpResponse.statusCode() != 200) {
                throw new ConnectiveException("Failed to sign in to Connective");
            }

        } catch (IOException e) {
            throw new ConnectiveException("Can't connect to the Connective platform", e);
        } catch (InterruptedException e) {
            throw new ConnectiveException("A problem occurred while uploading to the Connective platform", e);
        }
    }

    public Document requestSignatureFromUser(ConnectiveConnection connection, Person person) {
        // Use the plugin to fetch the user digital signature (ex. ItsMe)
        return new Document();
    }
}
