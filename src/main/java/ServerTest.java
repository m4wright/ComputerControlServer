import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(9091, 10);
        int n = 0;
        byte[] data = new byte[1024];

        while (true)
        {
            Socket request = serverSocket.accept();
            int read = request.getInputStream().read(data);
            String input = new String(data, 0, read, "UTF-8");
            System.out.println(input);
            String toSend = String.format(
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Connection: close\r\n" +
                    "Refresh: 5\r\n" +
                    "\r\n" +
                    "<!DOCTYPE HTML>" +
                    "<html>" +
                    "Output: %d" +
                    "</html>\r\n\r\n", n);
            System.out.println(toSend);
            request.getOutputStream().write(toSend.getBytes("UTF-8"));
            request.getOutputStream().close();

            n++;
            System.out.println("Incremented n to " + n);
        }
    }
}
