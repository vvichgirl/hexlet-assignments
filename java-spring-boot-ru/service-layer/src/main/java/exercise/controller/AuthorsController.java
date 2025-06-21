package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> index() {
        var authors = authorService.getAll();
        return authors;
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO findById(@PathVariable Long id) {
        var author = authorService.findById(id);
        return author;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@Valid @RequestBody AuthorCreateDTO authorData) {
        var author = authorService.create(authorData);
        return author;
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO update(@RequestBody @Valid AuthorUpdateDTO authorData, @PathVariable Long id) {
        var author = authorService.update(authorData, id);
        return author;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        authorService.delete(id);
    }
    // END
}
