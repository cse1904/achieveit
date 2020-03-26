package com.projects.achieveit.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * nio socket服务端
 */
public class SocketServer {

    /**
     * 启动socket服务，开启监听
     *
     * @param port
     * @throws IOException
     */
    public void startSocketServer(int port) {
        try{
            //创建serverSocket，等待请求
            ServerSocket server=null;
            try{
                server=new ServerSocket(port);
                System.out.println("Server start is ok...");
            }catch (IOException e){
                System.out.println("Can not listen to:"+e);
            }

            Socket socket=null;
            try{
                socket=server.accept();
            } catch (IOException e) {
                System.out.println("Error."+e);
            }

            //获取输入流
            String line;
            BufferedReader in=new BufferedReader(new InputStreamReader((socket.getInputStream())));
            //获取输出流
            PrintWriter writer=new PrintWriter(socket.getOutputStream());

            BufferedReader br =new BufferedReader((new InputStreamReader(System.in)));
            System.out.println("Client:"+in.readLine());

            line=br.readLine();

            while(!line.equals("end")){
                writer.println(line);
                writer.flush();
                System.out.println("Server:"+line);
                System.out.println("Client"+in.readLine());

                line=br.readLine();
            }


            writer.close();
            in.close();
            socket.close();
            server.close();
        }catch (Exception e){
            System.out.println("Error."+e);
        }

    }


}