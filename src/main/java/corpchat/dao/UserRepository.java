package corpchat.dao;

import corpchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, AbstractDao<User> {

    User findByEmail(String email);
    User save(User user);



}


