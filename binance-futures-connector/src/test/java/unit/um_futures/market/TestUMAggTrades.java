package unit.um_futures.market;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import java.util.LinkedHashMap;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;

public class TestUMAggTrades {
    private MockWebServer mockWebServer;
    private String baseUrl;

    private final long startTime = System.currentTimeMillis();
    private final long endTime = startTime + 1000;
    private final int limit = 1000;
    private final int fromId = 1000;

    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testAggTradesWithoutSymbol() {
        String path = "fapi/v1/aggTrades";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().aggTrades(parameters));
    }

    @Test
    public void testAggTrades() {
        String path = "fapi/v1/aggTrades?symbol=BNBUSDT";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().aggTrades(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testAggTradesWithLimit() {
        String path = "fapi/v1/aggTrades?symbol=BNBUSDT&limit=1000";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("limit", limit);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().aggTrades(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testAggTradesWithFromId() {
        String path = "fapi/v1/aggTrades?symbol=BNBUSDT&fromId=1000";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("fromId", fromId);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().aggTrades(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testAggTradesWithTimestamp() {
        String path = String.format("fapi/v1/aggTrades?symbol=BNBUSDT&startTime=%s&endTime=%s", startTime, endTime);
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        parameters.put("symbol", "BNBUSDT");
        parameters.put("startTime", startTime);
        parameters.put("endTime", endTime);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().aggTrades(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}