package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.ClientStatus;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@Setter
@Getter
public class Client implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long clientId;     //id key of entity - unique, not null, PK

    @Column(name = "client_status")
    @Enumerated(EnumType.STRING)
    private ClientStatus clientStatus;     // client's status from enum ClientStatus        |

    @Column(name = "tax_code")
    private Integer taxCode; //    | varchar(16) | client's TAX code unique                      |

    @NotBlank(message = "Username can`t be empty")
    private String firstName;

    @NotBlank(message = "Username can`t be empty")
    private String lastName;
    @NotBlank(message = "Username can`t be empty")
    private String email;
    @NotBlank(message = "Username can`t be empty")
    private String address;
    @NotBlank(message = "Username can`t be empty")
    private String phone;
    @NotBlank(message = "Username can`t be empty")
    private Date createdAt;
    @NotBlank(message = "Username can`t be empty")
    private Date updatedAt;
    @NotBlank(message = "Username can`t be empty")
    private String password;

    // @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    private Long managerId; //manager`s id FK references managers(id)


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
