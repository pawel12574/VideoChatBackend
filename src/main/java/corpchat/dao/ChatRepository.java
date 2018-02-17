package corpchat.dao;

import corpchat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sun.plugin2.message.Message;

import java.util.List;

public interface ChatRepository  extends JpaRepository<Chat, Long>, AbstractDao<Chat> {

    @Query("select c from Chat c left join fetch c.messages where c.userOne.id = ?1 and c.userTwo = ?2 or c.userOne.id = ?2 and c.userTwo = ?1 ")
    Chat getChat(Long userOneId, Long userTwoId);
}
