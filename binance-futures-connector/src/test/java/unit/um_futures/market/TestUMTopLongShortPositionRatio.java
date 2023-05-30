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

public class TestUMTopLongShortPositionRatio {
    private MockWebServer mockWebServer;
    private String baseUrl;

    private final long startTime = System.currentTimeMillis();
    private final long endTime = startTime + 1000;
    private final int limit = 1000;

    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testTopLongShortPositionRatioWithoutSymbol() {
        String path = "/futures/data/topLongShortPositionRatio?period=5m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("period", "5m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().topTraderLongShortPos(parameters));
    }

    @Test
    public void testTopLongShortPositionRatioWithoutPeriod() {
        String path = "/futures/data/topLongShortPositionRatio?symbol=BNBUSDT";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().topTraderLongShortPos(parameters));
    }

    @Test
    public void testTopLongShortPositionRatio() {
        String path = "/futures/data/topLongShortPositionRatio?symbol=BNBUSDT&period=5m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("period", "5m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().topTraderLongShortPos(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testTopLongShortPositionRatioWithParameters() {
        String path = String.format("/futures/data/topLongShortPositionRatio?symbol=BNBUSDT&period=5m&limit=1000&startTime=%s&endTime=%s", startTime, endTime);
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("period", "5m");
        parameters.put("limit", limit);
        parameters.put("startTime", startTime);
        parameters.put("endTime", endTime);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().topTraderLongShortPos(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}