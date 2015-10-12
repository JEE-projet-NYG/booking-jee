package model;

//@Entity
public class User {

    //@Id
    //@Column(name = "id", nullable = false)
    private Long id;

    //@Column(name = "login", nullable = false)
    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
