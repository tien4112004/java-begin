// package Envelope;

import java.net.*;
import java.util.*;

// import Message.Message;

public class Envelope {
    public String sender;
    public String recipients;

    public String destHost;
    public InetAddress destIP;

    public Message message;

    public Envelope() {
        sender = "";
        recipients = "";
        destHost = "";
        destIP = null;
        message = null;
    }

    public Envelope(Message message, String localServer) throws UnknownHostException {
        sender = message.getSender();
        recipients = message.getRecipients();

        message = escapeMessge(message);

        destHost = localServer;
        try {
            destIP = InetAddress.getByName(destHost);
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + destHost);
            System.out.println(e);
            throw e;
        }
        return;
    }

    private Message escapeMessge(Message message) {
        String escapedBody = "";
        String token;
        StringTokenizer parser = new StringTokenizer(message.body, "\r\n", true);

        while (parser.hasMoreTokens()) {
            token = parser.nextToken();
            if (token.startsWith(token, '.')) {
                token = "." + token;
            }
            escapedBody += token;
        }
        message.body = escapedBody;
        return message;
    }

    public String toString() {
        String res = "";
        res += "Sender: " + sender + "\n";
        res += "recipients: " + recipients + "\n";
        res += "MX-hpst: " + destHost + ", address: " + destIP + "\n";
        res += message.toString();
        return res;
    }
}
