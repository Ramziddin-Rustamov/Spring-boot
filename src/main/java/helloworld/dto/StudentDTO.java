package helloworld.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private String id;
    @NotNull(message="Name required !")
    private  String name;
    @NotNull(message="Surname required !")
    private String surname;
    @NotNull(message="Age required !")
    private Integer age;
}
