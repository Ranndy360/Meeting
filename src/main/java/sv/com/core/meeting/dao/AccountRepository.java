package sv.com.core.meeting.dao;

import org.springframework.data.repository.CrudRepository;
import sv.com.core.meeting.model.Account;

import java.util.Optional;


public interface AccountRepository extends CrudRepository<Account, Integer> {

    Optional<Account> findOneByUsername(String username);

}
