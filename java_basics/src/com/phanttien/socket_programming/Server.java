// package com.phanttien.socket_programming;

import java.io.*;
import java.net.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private BufferedReader buffer = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Started server at port " + port + ".");

            System.out.println("Waiting for a client...");

            socket = server.accept();
            System.out.println("Client " + socket.getInetAddress() + " accepted!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String command = "";
            String response = "";
            buffer = new BufferedReader(new InputStreamReader(System.in));

            while (command.equals("QUIT") == false) {
                try {
                    System.out.println("Waiting command from client...");
                    command = in.readUTF();
                    System.out.println("Client: " + command);

                    System.out.println("Response: ");
                    response = buffer.readLine();
                    out.writeUTF(response);
                    out.flush();
                } catch (IOException i) {
                    System.out.println(i);
                    break;
                }
            }

            // // close connection
            socket.close();
            System.out.println("Connection closed!");
            in.close();
            server.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        int port = 2225;
        if (args.length > 0) {
            if (args[0].equals("-s")) {
                port = Integer.parseInt(args[1]);
            } else {
                System.out.println("Invalid argument!");
                System.exit(0);
            }
        }
        Server server = new Server(port);
    }
}
