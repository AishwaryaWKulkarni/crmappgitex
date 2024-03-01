package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Pattern(regexp = "[A-Za-z]*", message = "Cust Name should not contain space or special characters")
    private String custName;

    @NotNull
    private String custAddress;


    private double custAccBalance;

    @Column(unique = true)
    @Range(min = 1000000000, max = 9999999999L, message = "ContactNo must be 10 digit")
    private long custContactNo;

    @JsonFormat(pattern = "dd-MM-yyyy")

    private Date custDOB;

    @Column(unique = true)
    @Range(min = 100000000000L, max = 999999999999L, message = "UID must be 12 digit")
    private long custUID;

    @Column(unique = true)
    private String custPanCard;

    @Column(unique = true)
    @Email(message = "Email Should be valid")
    private String custEmailId;

    @Size(min = 4, message = "Password atlest of 4 characters")
    private String custPassword;
}
