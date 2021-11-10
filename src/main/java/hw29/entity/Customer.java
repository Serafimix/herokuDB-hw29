package hw29.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;

    public Customer(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
