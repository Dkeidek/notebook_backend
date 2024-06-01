package htwberlin.todolist_backend.service;

import htwberlin.todolist_backend.model.Notebook;
import htwberlin.todolist_backend.persistence.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotebookService {
    @Autowired
    NotebookRepository repo;

    public Notebook get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    public Notebook save(Notebook notebook) {
        return repo.save(notebook);
    }



}
