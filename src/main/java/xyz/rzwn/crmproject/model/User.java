package xyz.rzwn.crmproject.model;

import java.util.Scanner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userPhone;
    private int roleID;
    }
