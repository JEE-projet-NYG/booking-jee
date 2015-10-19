package model;

import javax.persistence.*;

/**
 * Created by ferrilata on 19/10/15.
 */
@Entity
public class Ressource {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="localisation", nullable = false)
    private String localisation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="responsibleId")
    private User responsible;

    @ManyToOne
    @JoinColumn(name="typeId")
    private RessourceType type;

    public Ressource() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public RessourceType getType() {
        return type;
    }

    public void setType(RessourceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ressource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", localisation='" + localisation + '\'' +
                ", responsible=" + responsible +
                ", type=" + type +
                '}';
    }
}
