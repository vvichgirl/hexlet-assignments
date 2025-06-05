package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::toPostDTO)
                .toList();
        return result;
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {

        var post =  postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return toPostDTO(post);
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());

        var comments = commentRepository.findByPostId(post.getId());
        var commentsDTO = comments.stream()
                .map(comment -> {
                    var commentDto = new CommentDTO();
                    commentDto.setId(comment.getId());
                    commentDto.setBody(comment.getBody());
                    return commentDto;
                })
                .toList();
        dto.setComments(commentsDTO);

        return dto;
    }

}
// END
