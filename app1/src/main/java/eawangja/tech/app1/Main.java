package eawangja.tech.app1;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(javalinConfig -> {
                    javalinConfig.staticFiles.add(staticFileConfig -> {
                        staticFileConfig.hostedPath = "/";
                        staticFileConfig.directory = "/public";
                        staticFileConfig.location = Location.CLASSPATH;
                    });
                })
                .start(7080);

        app.get("/", ctx -> {
            ctx.redirect("index.html");
        });
    }

}