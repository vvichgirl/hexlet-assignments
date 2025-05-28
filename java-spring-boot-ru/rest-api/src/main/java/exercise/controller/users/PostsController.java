package exercise.controller.users;

import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Post>> index(@PathVariable String id) {
        List<Post> result = posts.stream()
                .filter(post -> id.equals(Integer.toString(post.getUserId())))
                .toList();

        return ResponseEntity.ok()
                .body(result);
    }

    @PostMapping("/users/{id}/posts") // Создание поста
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> create(@PathVariable String id, @RequestBody Post post) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);
        URI location = URI.create("/users/" + id + "/posts" + post.getSlug());

        return ResponseEntity.created(location).body(post);
    }
}
// END
