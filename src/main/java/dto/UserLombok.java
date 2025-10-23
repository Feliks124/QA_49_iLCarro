package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class UserLombok {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

}
