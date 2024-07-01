package htwberlin.todolist_backend.api;

import htwberlin.todolist_backend.model.Notebook;
import htwberlin.todolist_backend.service.NotebookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class NotebookControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private NotebookController notebookController;

    @Mock
    private NotebookService notebookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(notebookController).build();
    }

    @Test
    void testGetAllNotebooks() throws Exception {
        Notebook notebook = new Notebook("description", "owner");
        notebook.setId(1L);

        when(notebookService.findAll()).thenReturn(Collections.singletonList(notebook));

        mockMvc.perform(get("/notebook")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("description"));
    }


    @Test
    void testDeleteNotebook() throws Exception {
        mockMvc.perform(delete("/notebook/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}