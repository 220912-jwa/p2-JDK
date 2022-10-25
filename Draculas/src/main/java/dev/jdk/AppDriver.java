package dev.jdk;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class AppDriver {
    public static void main(String[] args) {


        Javalin app = Javalin.create(config -> {
                    config.enableCorsForAllOrigins();
                    config.addStaticFiles("/public", Location.CLASSPATH);
                }
        ).start(8080);
    }
}
