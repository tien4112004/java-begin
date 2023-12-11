// package com.phanttien.socket_programming;

import java.io.*;
import java.net.*;

public class Client {
    Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private BufferedReader buffer = null;

    public Client(String smtpServer, int port) {
        try {
            socket = new Socket(smtpServer, port);
            System.out.println("[SMTP] Connected to " + smtpServer + ":" + port + "!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        buffer = new BufferedReader(new InputStreamReader(System.in));

        String command = "";
        String response = "";
        while (!command.equals("QUIT")) {
            try {
                System.out.println("Command: ");
                command = buffer.readLine();
                out.writeUTF(command);
                out.flush();

                System.out.println("Waiting response from server...");
                response = in.readUTF();
                System.out.println("Server: " + response);

            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 2225);
    }
}
