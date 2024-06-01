package htwberlin.todolist_backend.model;


import jakarta.persistence.*;


@Entity (name = "notebook")
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
   private String description;
    @Column(name = "owner")
   private String owner;


    public Notebook() {}

    public Notebook(String description, String owner) {
        this.description = description;
        owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        owner = owner;
    }
}
