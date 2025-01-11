package LinkedInLearning.SpringBootApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/dirty-secrets")
public class DirtySecretsRestController {

    private DirtySecretsRepository repository;

    public DirtySecretsRestController(DirtySecretsRepository repository){
        this.repository = repository;
    }


    @GetMapping("/count")
    public int count() {
        return this.repository.count();
    }

    @GetMapping("/{id}")
    public DirtySecret getById(@PathVariable String id) {
        var secret = this.repository.getById(id);
        return secret.orElse(null);
    }

    @PostMapping
    public DirtySecret post(@RequestBody DirtySecret secret){
        return this.repository.save(secret);
    }

}
