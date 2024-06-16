package htwberlin.todolist_backend.service;

import htwberlin.todolist_backend.model.Notebook;
import htwberlin.todolist_backend.persistence.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Notebook> findAll() {
        Iterable<Notebook> iterator = repo.findAll();
        List<Notebook> notebooks = new ArrayList<>();
        for (Notebook note : iterator) {
            notebooks.add(note);
        }
        return notebooks;
    }



    public Notebook update(Notebook notebook) {
        if (repo.existsById(notebook.getId())) {
            return repo.save(notebook);
        } else {
            throw new RuntimeException("Notebook not found");
        }
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }



}
