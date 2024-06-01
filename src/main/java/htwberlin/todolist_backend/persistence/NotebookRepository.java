package htwberlin.todolist_backend.persistence;


import htwberlin.todolist_backend.model.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> { }