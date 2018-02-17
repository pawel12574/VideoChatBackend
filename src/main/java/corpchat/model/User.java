package corpchat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends AbstractEntity{

    private String email;
    private String password;

    @OneToMany
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private Set<Chat> chats;

    @ManyToMany
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private Set<User> friend = new HashSet<>();

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Chat> getChats() {
        return chats;
    }

    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }

    public Set<User> getFriend() {
        return friend;
    }

    public void setFriend(Set<User> friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
