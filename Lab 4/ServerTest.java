import edu.mirea.rksp.pr4.Server.DefaultSimpleService;
import io.rsocket.Payload;
import io.rsocket.util.DefaultPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;

class ServerTest {

    DefaultSimpleService defSimServ = new DefaultSimpleService();

    @Test
    @DisplayName("Correct F&F result")
    public void fnfTest() {
        defSimServ.fireAndForget(DefaultPayload.create(MessageMapper.messageToJson(new Message("Test Message"))));
    }

    @Test
    @DisplayName("Correct reqResponse result")
    public void reqRTest() {
        defSimServ.requestResponse(DefaultPayload.create(MessageMapper.messageToJson(new Message("Test Message"))));
    }

    @Test
    @DisplayName("Correct reqStream result")
    public void reqSTest() {
        defSimServ.requestStream(DefaultPayload.create(MessageMapper.messageToJson(new Message("Test Message"))));
    }

    @Test
    @DisplayName("Correct reqChanel result")
    public void reqCTest() {
        // ПРИМЕЧАНИЕ: Раскомментируйте следующую строку после реализации метода
        // requestChannel в DefaultSimpleService
        // defSimServ.requestChannel((Publisher<Payload>)
        // DefaultPayload.create(MessageMapper.messageToJson(new Message("Test
        // Message"))));
    }

    @Test
    @DisplayName("Should always pass")
    public void uselessTest() {
        Assertions.assertTrue(true);
    }
}
