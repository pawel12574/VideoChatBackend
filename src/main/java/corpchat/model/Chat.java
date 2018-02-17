package corpchat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Chat extends AbstractEntity {

    @OneToOne
    private User userOne;

    @OneToOne
    private User userTwo;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy="chat")
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private Set<Message> messages = new HashSet<Message>();

    public Chat() {
    }

    public User getUserOne() {
        return userOne;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public void setUserTwo(User userTwo) {
        this.userTwo = userTwo;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
