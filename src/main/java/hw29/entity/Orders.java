package hw29.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "orders_date")
    private LocalDate orderDate = LocalDate.now();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buying_album_id")
    private BuyingAlbum buyingAlbum;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Orders(BuyingAlbum buyingAlbum, Customer customer) {
        this.buyingAlbum = buyingAlbum;
        this.customer = customer;
    }
}
