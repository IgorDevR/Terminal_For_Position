package unit.cm_futures.market;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import java.util.LinkedHashMap;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;

public class TestCMTrades {
    private MockWebServer mockWebServer;
    private String baseUrl;

    private final int limit = 1000;

    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testTradesWithoutSymbol() {
        String path = "dapi/v1/trades";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().trades(parameters));
    }

    @Test
    public void testTrades() {
        String path = "dapi/v1/trades?symbol=BNBUSDT";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().trades(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testTradesWithLimit() {
        String path = "dapi/v1/trades?symbol=BNBUSDT&limit=1000";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("limit", limit);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().trades(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}