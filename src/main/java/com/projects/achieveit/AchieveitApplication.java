package com.projects.achieveit;


import com.projects.achieveit.Util.SocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.projects.achieveit.dao")
@SpringBootApplication
public class AchieveitApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchieveitApplication.class, args);

        //起socket服务
        SocketServer server = new SocketServer();
        server.startSocketServer(8088);
    }

}
