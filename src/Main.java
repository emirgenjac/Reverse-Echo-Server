import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(2000);
        Socket stk = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(stk.getInputStream()));
        PrintStream out = new PrintStream(stk.getOutputStream());

        String message;
        StringBuilder sb;
        do {
            //Reading from client
            message = in.readLine();

            sb = new StringBuilder(message);
            sb.reverse();
            message = sb.toString();

            //Writing to client
            out.println(message);
        } while (!message.equals("dne"));
        stk.close();
    }
}