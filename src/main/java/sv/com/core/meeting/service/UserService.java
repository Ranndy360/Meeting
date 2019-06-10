package sv.com.core.meeting.service;


import org.springframework.stereotype.Service;
import sv.com.core.meeting.dao.UserRepository;
import sv.com.core.meeting.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        List<User> users=new ArrayList<>();
        for (User user:userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }


}
