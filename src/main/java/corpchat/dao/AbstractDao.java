package corpchat.dao;



import corpchat.model.AbstractEntity;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity> {

  T findById(Long id);

  List<T> findAll();
}
