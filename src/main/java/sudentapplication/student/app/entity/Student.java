package sudentapplication.student.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sudentapplication.student.app.validation.RegistrationCode;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "this field is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "this field is required")
    @Email(message = "email not valid")
    @Column(name = "email")
    private String email;

    @NotNull(message = "this field is required")
    @Column(name = "enrolled_year")
    private Integer enrolledYear;

    @Column(name = "registration_code")
    @RegistrationCode
    private String registrationCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnrolledYear() {
        return enrolledYear;
    }

    public void setEnrolledYear(Integer enrolledYear) {
        this.enrolledYear = enrolledYear;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enrolledYear=" + enrolledYear +
                '}';
    }
}
