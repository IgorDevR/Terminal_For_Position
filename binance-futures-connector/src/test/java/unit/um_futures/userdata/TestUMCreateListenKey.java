package unit.um_futures.userdata;

import static org.junit.Assert.assertEquals;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;

public class TestUMCreateListenKey {
    private MockWebServer mockWebServer;
    private String baseUrl;


    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testCreateListenKey() {
        String path = "fapi/v1/listenKey";
        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.POST, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);
        UMFuturesClientImpl client = new UMFuturesClientImpl(MockData.API_KEY, MockData.SECRET_KEY, baseUrl);
        String result = client.userData().createListenKey();
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}