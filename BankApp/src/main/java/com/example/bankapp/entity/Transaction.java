package com.example.bankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

@Entity
//@Table(name="transaction")
@Setter
@Getter
public class Transaction {
    @Id
    private UUID id;
    private Byte type;
    private Double amount;
//    @OneToOne
//    private Client Sender;
    private String description;
    private Date createdAt;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private UUID debitAccountId; //account`s id FK references accounts(id)|
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private UUID creditAccountId; //account`s id FK references accounts(id)|


}
