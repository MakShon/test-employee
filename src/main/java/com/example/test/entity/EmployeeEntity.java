package com.example.test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "mt_employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 symbols")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must contains only english letters")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Gender can not be blank")
    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be 'Male' or 'Female'")
    @Column(name = "gender")
    private String gender;

    @NotNull(message = "Date of birth cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Pattern(
            regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Date of birth must be in the past and should be in the format 'yyyy-MM-dd'"
    )
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender can not be blank")
    @Pattern(regexp = "^[a-zA-Z]+,\\s*[a-zA-Z]+,\\s*[a-zA-Z]+$",
            message = "Address must be in format 'City, Region, Country' with English letters only")
    @Column(name = "address")
    private String address;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String name, String gender, LocalDate dateOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
