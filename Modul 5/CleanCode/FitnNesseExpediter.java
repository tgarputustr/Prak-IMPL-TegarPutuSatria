package CleanCode;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class FitnNesseExpediter implements ResponseSender {
    private Socket socket;
    private InputStream input;
    private OutputStream output;
    private Request request;
    private Responder response;
    private FitnesseContext context;
    private long requestParsingTimeLimit;
    private long requestProgress;
    private long requestParsingDeadline;
    private boolean hasError;
}
