
package socialsky.codingtest.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "User")
@NamedQueries({
    @NamedQuery(name = "socialsky.codingtest.dao.User.findByName",
            query = "SELECT p FROM User p WHERE p.name= :pname")})

//  WHERE p.name = :pname
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = true)
    private String password;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + '}';
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.ALL})
    @Transient
    Token token;

    public void setToken(Token token) {
        this.token = token;
    }

}
