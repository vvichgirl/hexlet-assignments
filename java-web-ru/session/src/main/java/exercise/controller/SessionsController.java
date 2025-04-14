package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        String name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String password = ctx.formParam("password");
        String encriptedPassword = Security.encrypt(password);
        User user = UsersRepository.findByName(name).orElse(null);
        String userPassword = user != null ? user.getPassword() : null;

        if (user == null || !userPassword.equals(encriptedPassword)) {
            String error = "Wrong username or password";
            var page = new LoginPage(name, error);
            ctx.render("build.jte", model("page", page));
            return;
        }

        var page = new MainPage(user);
        ctx.sessionAttribute("currentUser", name);
        ctx.redirect("/");
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
