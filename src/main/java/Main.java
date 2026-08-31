import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        int port = 6379;
        try {
//            while (true){
                serverSocket = new ServerSocket(port);
                serverSocket.setReuseAddress(true);
                clientSocket = serverSocket.accept();

                InputStream inputStream = clientSocket.getInputStream();
                Scanner sc = new Scanner(inputStream);

                System.out.println(sc.nextLine());
//                OutputStream outputStream = clientSocket.getOutputStream();
//                outputStream.write("+PONG\r\n".getBytes());
//            }

        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try{
                if (clientSocket != null) {
                    clientSocket.close();
                }
            }
            catch (IOException e){
                    System.out.println("IOException: " + e.getMessage());
            }
        }
    }
}
