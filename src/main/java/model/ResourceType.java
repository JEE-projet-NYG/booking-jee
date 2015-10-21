package model;

/**
 * Created by ferrilata on 19/10/15.
 */

import javax.persistence.*;

@Entity
public class ResourceType {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    public ResourceType() {
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

    @Override
    public String toString() {
        return "ResourceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
