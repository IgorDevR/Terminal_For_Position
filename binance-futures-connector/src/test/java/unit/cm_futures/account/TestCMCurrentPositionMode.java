package unit.cm_futures.account;

import static org.junit.Assert.assertEquals;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import java.util.LinkedHashMap;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;

public class TestCMCurrentPositionMode {
    private MockWebServer mockWebServer;
    private String baseUrl;


    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testCurrentPositionMode() {
        String path = "dapi/v1/positionSide/dual";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(MockData.API_KEY, MockData.SECRET_KEY, baseUrl);
        String result = client.account().getCurrentPositionMode(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}
