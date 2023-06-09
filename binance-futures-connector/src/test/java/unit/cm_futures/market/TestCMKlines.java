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

public class TestCMKlines {
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
    public void testKlinesWithoutSymbol() {
        String path = "dapi/v1/klines?interval=1m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("interval", "1m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().klines(parameters));
    }

    @Test
    public void testKlinesWithoutInterval() {
        String path = "dapi/v1/klines?symbol=BNBUSDT";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().klines(parameters));
    }

    @Test
    public void testKlines() {
        String path = "dapi/v1/klines?symbol=BNBUSDT&interval=1m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("interval", "1m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().klines(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testKlinesWithParameters() {
        String path = String.format("dapi/v1/klines?symbol=BNBUSDT&interval=1m&limit=1000&startTime=%s&endTime=%s", startTime, endTime);
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("interval", "1m");
        parameters.put("limit", limit);
        parameters.put("startTime", startTime);
        parameters.put("endTime", endTime);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().klines(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}
