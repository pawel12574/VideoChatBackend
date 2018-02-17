package corpchat.dao;

import corpchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, AbstractDao<User> {

    User findByEmail(String email);

    @Query("select u from User u left join fetch u.friend where u.email = ?1")
    User userWithFriends(String email);

    User save(User user);



}


