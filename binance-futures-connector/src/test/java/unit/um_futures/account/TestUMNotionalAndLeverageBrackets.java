package unit.um_futures.account;

import static org.junit.Assert.assertEquals;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import java.util.LinkedHashMap;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;

public class TestUMNotionalAndLeverageBrackets {
    private MockWebServer mockWebServer;
    private String baseUrl;


    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testNotionalAndLeverageBracketsNoSymbol() {
        String path = "fapi/v1/leverageBracket";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(MockData.API_KEY, MockData.SECRET_KEY, baseUrl);
        String result = client.account().getLeverageBracket(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testNotionalAndLeverageBrackets() {
        String path = "fapi/v1/leverageBracket?symbol=BNBUSDT";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(MockData.API_KEY, MockData.SECRET_KEY, baseUrl);
        String result = client.account().getLeverageBracket(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}