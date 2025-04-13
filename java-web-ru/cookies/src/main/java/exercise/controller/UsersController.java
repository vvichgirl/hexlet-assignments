package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) throws Exception {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String encriptedPassword = Security.encrypt(ctx.formParam("password"));
        String token = Security.generateToken();
        User user = new User(firstName, lastName, email, encriptedPassword, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) throws Exception {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        String userToken = user.getToken();

        if (userToken.equals(ctx.cookie("token"))) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }


    }
    // END
}
