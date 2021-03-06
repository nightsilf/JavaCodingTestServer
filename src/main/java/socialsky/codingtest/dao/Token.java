
package socialsky.codingtest.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Token")
public class Token {

    @Id
    @Column(name = "token", nullable = false)
    String token;

    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Token(String token) {
        this.token = token;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    User user;
    
    
    
}
