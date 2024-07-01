package htwberlin.todolist_backend.service;

import htwberlin.todolist_backend.model.Notebook;
import htwberlin.todolist_backend.persistence.NotebookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class NotebookServiceTest {

    @InjectMocks
    private NotebookService notebookService;

    @Mock
    private NotebookRepository notebookRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetNotebook() {
        Notebook notebook = new Notebook("description", "owner");
        notebook.setId(1L);

        when(notebookRepository.findById(1L)).thenReturn(Optional.of(notebook));

        Notebook found = notebookService.get(1L);
        assertEquals("description", found.getDescription());
        assertEquals("owner", found.getOwner());
    }

    @Test
    void testSaveNotebook() {
        Notebook notebook = new Notebook("description", "owner");

        when(notebookRepository.save(notebook)).thenReturn(notebook);

        Notebook saved = notebookService.save(notebook);
        assertEquals("description", saved.getDescription());
        assertEquals("owner", saved.getOwner());
    }

    @Test
    void testDeleteNotebook() {
        notebookService.delete(1L);
        verify(notebookRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateNotebook_NotFound() {
        Notebook notebook = new Notebook("description", "owner");
        notebook.setId(1L);

        when(notebookRepository.existsById(1L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> {
            notebookService.update(notebook);
        });
    }
}
