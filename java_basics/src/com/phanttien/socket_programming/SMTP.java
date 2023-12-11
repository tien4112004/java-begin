import java.net.*;
import java.io.*;

public class SMTPConnection {
    private Socket connection;
    private BufferedReader fromServer;
    private DataOutputStream toServer;

    private static final int SMTP_PORT = 25;
    private static final String CRLF = "\r\n";
    private boolean isConnected = false;

    public SMTPConnection(String smtpServer, int smtp_port) throws IOException {
        connection = new Socket(smtpServer, smtp_port);
        fromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        toServer = new DataOutputStream(connection.getOutputStream());

        String response = fromServer.readLine();
        System.out.println("Server Response: " + response);

        if (!response.startsWith("220")) {
            throw new IOException("Exception in connecting to SMTP server");
        }

        String localhost = InetAddress.getLocalHost().getHostName();
        sendCommand("HELO " + localhost, 250);

        isConnected = true;
    }

    public void send(String from, String to, String subject, String body) throws IOException {
        sendCommand("MAIL FROM: <" + from + ">", 250);
        sendCommand("RCPT TO: <" + to + ">", 250);
        sendCommand("DATA", 354);
        toServer.writeBytes("Subject: " + subject + CRLF + CRLF + body + CRLF + "." + CRLF);
        sendCommand("", 250);
    }

    public void close() {
        isConnected = false;
        try {
            sendCommand("QUIT", 221);
            connection.close();
        } catch (IOException e) {
            System.out.println("Unable to close connection: " + e);
            isConnected = true;
        }
    }

    private void sendCommand(String command, int rc) throws IOException {
        toServer.writeBytes(command + CRLF);
        String response = fromServer.readLine();
        System.out.println("Server Response: " + response);

        if (!response.startsWith(String.valueOf(rc))) {
            throw new IOException("Exception in sending command: " + command);
        }
    }

    public static void main(String args[]) {
        try {
            SMTPConnection smtp = new SMTPConnection("127.0.0.1", 2225);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}