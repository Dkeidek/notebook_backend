package htwberlin.todolist_backend.api;

import htwberlin.todolist_backend.model.Notebook;
import htwberlin.todolist_backend.service.NotebookService;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
@CrossOrigin
@RestController
public class NotebookController {
    @Autowired
    NotebookService notebookService;



    @GetMapping("/things/{id}")
    public Notebook getThing(@PathVariable String id) {
        Long thingId = Long.parseLong(id);
        return notebookService.get(thingId);
    }




}
