package LinkedInLearning.SpringBootApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



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

}