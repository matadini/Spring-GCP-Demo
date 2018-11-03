package pl.matadini.springservice.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfiguration {

    @Bean
    AtomicInteger atomicInteger() {
        return new AtomicInteger();
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // @Bean
    // Connection connection(){
    //     Connection conn = null;
    //     String url = "jdbc:postgresql://google/test?cloudSqlInstance=flowing-indexer-220912:us-central1:kubernetes-test-postgresql&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=admin&password=admin";
    //     //log("connecting to: " + url);
    //     try {
    //       conn = DriverManager.getConnection(url);
    //     } catch (SQLException e) {
    //       System.out.println(e);
    //     }
    //     return conn;

    // }

}