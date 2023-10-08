package ex202_contract;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ConnectiveConnection {
    private final String url;
    private final ZonedDateTime connectionStart;
    private final String bearerToken;

    public ConnectiveConnection(String url, ZonedDateTime connectionStart, String bearerToken) {
        this.url = url;
        this.connectionStart = connectionStart;
        this.bearerToken = bearerToken;
    }

    public boolean isConnectionActive() {
        return connectionStart.until(ZonedDateTime.now(), ChronoUnit.SECONDS) < 600;
    }

    public String getUrl() {
        return url;
    }

    public String getBearerToken() {
        return bearerToken;
    }
}
