package com.example.bankapp.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Manager {

    //id key of row - unique, not null, primary key
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    private String status; //manager's status from enum ManagerStatus
    private Date createdAt;
    private Date updatedAt;

}
