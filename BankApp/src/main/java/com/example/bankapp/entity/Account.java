package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.AccountStatus;
import com.example.bankapp.entity.enums.AccountType;
import com.example.bankapp.entity.enums.ClientStatus;
import com.example.bankapp.entity.enums.CurrencyCode;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name="account")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;  //id key of entity - unique, not null, PK

    //валидация - проверяем чтоб поля не были пустыми и занимали не более определенного размера.
    @NotBlank(message = "Please fill the account holder`s first name") //указываем что пользватель должен был заполнить
   // @Length(max = 255, message = "Message too long(more than 255 bytes)")
    @Column(name="firstName")
    private String firstName;

    @NotBlank(message = "Please fill the account holder`s last name") //указываем что пользватель должен был заполнить
  //  @Length(max = 255, message = "Message too long(more than 255 bytes)")
    @Column(name="lastName")
    private String lastName;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private AccountType type;  // account from enum AccountType           |

    @Column(name="account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;  // status from enum AccountStatus          |

    @Column(name="balance")
    private Double balance; // balance of the account

    @Column(name="currencyCode")
    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode; // currency code from enum CurrencyCode    |

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name="updatedAt")
    private Date updatedAt;

    @OneToMany(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", referencedColumnName = "id")
    private Client clientId; //client`s id FK references clients(id)

    @OneToMany(mappedBy = "debitAccount")
    private List<Transaction> transactionDebit;

    @OneToMany(mappedBy = "creditAccount")
    private List<Transaction> transactionCredit;





}
