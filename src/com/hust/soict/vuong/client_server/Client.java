package com.hust.soict.vuong.client_server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] Args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9898);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println(in.readLine());
        Scanner scanner = new Scanner(System.in);
        String message;
        System.out.print("Enter numbers separated by a space character: ");
        while (true){
            message = scanner.nextLine();
            if (message.equals("")){
                break;
            }
            out.println(message);
            System.out.println(in.readLine());
        }
        scanner.close();
        socket.close();
    }
}
