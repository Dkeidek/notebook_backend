package htwberlin.todolist_backend.api;

import htwberlin.todolist_backend.model.Notebook;
import htwberlin.todolist_backend.service.NotebookService;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
@CrossOrigin
@RestController
public class NotebookController {
    @Autowired
    NotebookService notebookService;



    @GetMapping("/notebook/{id}")
    public Notebook getNotebook(@PathVariable String id) {
        Long thingId = Long.parseLong(id);
        return notebookService.get(thingId);
    }

   @PostMapping("/notebook")
    public Notebook createNotebook(@RequestBody Notebook notebook) {
        return notebookService.save(notebook);
    }







}
