package model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Negin Mousavi
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "national_code")
    private String nationalCode;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private UserType type;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<Account> accounts = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Update> updates = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nationalCode='" + nationalCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type=" + type +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                ", accounts=" + accounts +
                '}';
    }
}
