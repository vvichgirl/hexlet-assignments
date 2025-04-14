package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        var page = new PostsPage(posts);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashClass(ctx.consumeSessionAttribute("flashClass"));
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            String name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();
            String body = ctx.formParam("body").trim();

            Post post = new Post(name.trim(), body);
            PostRepository.save(post);
            ctx.sessionAttribute("flash", "Post was successfully created!");
            ctx.sessionAttribute("flashClass", "success");
            ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            String name = ctx.formParam("name").trim();
            String body = ctx.formParam("body").trim();
            var page = new BuildPostPage(name, body, e.getErrors());
            ctx.render("posts/build.jte", model("page", page)).status(422);
        }
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
