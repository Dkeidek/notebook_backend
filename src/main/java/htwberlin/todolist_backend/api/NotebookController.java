package htwberlin.todolist_backend.api;

import htwberlin.todolist_backend.model.Notebook;
import htwberlin.todolist_backend.service.NotebookService;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
@CrossOrigin
@RestController
public class NotebookController {
    @Autowired
    NotebookService notebookService;



    @GetMapping("/notebook/{id}")
    public Notebook getNotebook(@PathVariable String id) {
        Long notebookid = Long.parseLong(id);
        return notebookService.get(notebookid);
    }

    @GetMapping("/notebook")
    public List <Notebook> getAllNotebooks() {
        return notebookService.findAll();
    }

   @PostMapping("/notebook")
    public Notebook createNotebook(@RequestBody Notebook notebook) {
        return notebookService.save(notebook);
    }
    @GetMapping(path= "/api/a1/task")
    public ResponseEntity<List<Notebook>> fetchTask(){
        List<Notebook> tasks = notebookService.findAll();
        System.out.println("Fetched tasks: " + tasks);
        return ResponseEntity.ok(tasks);
    }


    @PutMapping("/notebook/{id}")
    public Notebook updateNotebook(@PathVariable Long id, @RequestBody Notebook notebook) {
        notebook.setId(id);
        return notebookService.update(notebook);
    }

    @DeleteMapping("/notebook/{id}")
    public ResponseEntity<Void> deleteNotebook(@PathVariable Long id) {
        notebookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
