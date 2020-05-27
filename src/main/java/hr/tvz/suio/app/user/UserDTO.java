package hr.tvz.suio.app.user;

import java.util.Set;

import lombok.Data;

@Data
public class UserDTO {

	  private Long id;

	    private String username;

	    private String firstName;

	    private String lastName;

	    private Set<String> authorities;

}
