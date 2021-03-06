package model;

import enumeration.TransactionType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Negin Mousavi
 */
@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private double amount;
    private Date date;
    @ManyToOne
    private Account account;

    public double deposit() {
        account.setBalance(account.getBalance() + amount);
        return account.getBalance();
    }

    public double withdraw() {
        double balance = account.getBalance();
        if (balance < amount)
            throw new RuntimeException("balance is not enough");

        account.setBalance(balance - amount);
        return account.getBalance();
    }
}
