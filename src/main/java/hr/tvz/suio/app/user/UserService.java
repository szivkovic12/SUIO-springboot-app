package hr.tvz.suio.app.user;

import java.util.Optional;

public interface UserService {
	
	Optional<UserDTO> findByUsername(String username);
	
}
