import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5555); // Connect to the server

            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            Scanner scanner = new Scanner(System.in);

            new Thread(() -> {
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];
                        int bytesRead = input.read(buffer);

                        if (bytesRead == -1) {
                            System.out.println("Server has disconnected.");
                            System.exit(0);
                        }

                        String message = new String(buffer, 0, bytesRead);
                        System.out.println("Received message: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                System.out.print("Enter a message: ");
                String message = scanner.nextLine();

                output.write(message.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
