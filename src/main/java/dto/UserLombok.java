package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class UserLombok {

    private String username;
    private String password;
    private String firstName;
    private String lastName;


}
