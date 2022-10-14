package org.sid.ebankservice.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankservice.enums.AccountType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    @Id

    private String id;
    private Date createdAt;
    private Double balance;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private AccountType type;
    private String currency;


}

