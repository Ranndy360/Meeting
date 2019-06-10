package sv.com.core.meeting.dao;

import org.springframework.data.repository.CrudRepository;
import sv.com.core.meeting.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {


}
