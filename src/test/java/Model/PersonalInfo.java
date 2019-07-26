package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo {
    private boolean gender;
    private String email;
    private String firstName;
    private String lastName;
    private String day;
    private String month;
    private String year;
}
